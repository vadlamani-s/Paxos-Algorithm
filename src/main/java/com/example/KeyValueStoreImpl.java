package com.example;

import com.example.grpc.Keyvalue;
import com.example.grpc.Server;
import com.example.grpc.ServerRPCGrpc;
import com.example.grpc.keyValueStoreGrpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * The KeyValueStoreImpl has all the implementations of the server class. The class method's are
 * responsible for getting the response from the client, processing and responding back..
 */
public class KeyValueStoreImpl extends keyValueStoreGrpc.keyValueStoreImplBase {

  private static final Map<Integer, String> dictionary = new HashMap<>();
  private static Logger LOGGER;
  private static String serverName;
  private static String portNumber;
  private static String[] listOfPortNos;
  private static int PID;

  /**
   * Log setup method initializes the logging setup in the class.
   */
  public static void logSetup(String sName, String portNo, String[] portNos) {
    serverName = sName;
    portNumber = portNo;
    listOfPortNos = portNos;
    LOGGER = Logger.getLogger(serverName);
    LOGGER.setLevel(Level.ALL);
    PID = 0;
  }

  /**
   * Method for updating dictionary in each server after Paxos is implemented
   *
   * @param operation the dictionary operation to be performed
   * @param key       the key in the dictionary
   * @param varArgs   the value in the dictionary
   */
  public static void dictionaryUpdate(String operation, int key, String... varArgs) {
    if (operation.equals("put")) {
      dictionary.put(key, varArgs[0]);
    }
    if (operation.equals("delete")) {
      dictionary.remove(key);
    }
  }

  /**
   * Method for returning the dictionary handled by the server.
   *
   * @return the dictionary
   */
  public static Map<Integer, String> getDictionary() {
    return dictionary;
  }

  /**
   * Method for returning the Server name.
   *
   * @return the server name
   */
  public static String getServerName() {
    return serverName;
  }

  /**
   * The method generates a list of all the stubs.
   *
   * @return list of all the stubs
   */
  private List<ServerRPCGrpc.ServerRPCBlockingStub> storeServerStubs() {
    List<ServerRPCGrpc.ServerRPCBlockingStub> stubsList = new ArrayList<>();
    for (String port : listOfPortNos) {
      String target = "localhost:" + port;
      final ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
              .usePlaintext().build();
      ServerRPCGrpc.ServerRPCBlockingStub stubServer = ServerRPCGrpc.newBlockingStub(channel);
      stubsList.add(stubServer);
    }
    return stubsList;
  }

  /**
   * Initiating the Learn Phase.
   *
   * @param listOfStubs   list of the all the stubs
   * @param serverRequest Request for sending the value to other servers
   */
  private void initLearnPhase(List<ServerRPCGrpc.ServerRPCBlockingStub> listOfStubs,
                              Server.RequestServer serverRequest) {
    for (ServerRPCGrpc.ServerRPCBlockingStub stub : listOfStubs) {
      try {
        Server.ResponseServer responseServer = stub.withDeadlineAfter(2, TimeUnit.SECONDS)
                .learn(serverRequest);
//        System.out.println(responseServer.getResponseMessage());
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }

  /**
   * The method is responsible for performing actions on the dictionary stored in each of the
   * servers.
   *
   * @param request          the request containing the operation to be performed along with the key
   *                         and value
   * @param responseObserver the response sent after the operation is performed
   */
  @Override
  public void dictionaryOperation(Keyvalue.RequestOperation request,
                                  StreamObserver<Keyvalue.ResponseOperation> responseObserver) {
    int key = -1;
    String value;
    Keyvalue.ResponseOperation clientResponse = null;

    // Operation received from client
    String operation = request.getOperation();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // List for storing the stubs
    List<ServerRPCGrpc.ServerRPCBlockingStub> listOfStubs = storeServerStubs();
    int totalServers = listOfStubs.size() + 1;

    try {
      switch (operation.toLowerCase()) {
        case "put":
          PID += 1;
          key = (int) request.getKey();
          value = request.getValue();
          if (dictionary.containsKey(key)) {
            throw new IllegalArgumentException("Key already exists");
          }
          // Initiating Paxos Algorithm
          //Prepare Phase -> sending promise to all acceptors
          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Initiating Prepare Phase");
          int count = 0;
          while (count < (totalServers / 2 + 1)) {
            String req = Integer.toString(PID);
            Server.RequestServer serverRequest = Server.RequestServer.newBuilder().setRequestMessage(req).build();
            System.out.println("PID: " + PID);

            count = preparePhase(listOfStubs, count, serverRequest, totalServers);
          }
          System.out.println("Prepare phase completed");
          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Prepare Complete");

          // Accept Phase -> sending promise and value to be stored
          int acceptorCount = 0;
          int prevValueAcceptorCount = 0;
          String consensusValue = "";
          String prevValue = null;

          String req = Integer.toString(PID);
          Server.RequestServer serverRequest = Server.RequestServer.newBuilder().setRequestMessage(req)
                  .setOperation(operation).setKey(key).setValue(value).build();
          String currentValue = operation.toLowerCase() + " " + key + " " + value.toLowerCase();
          for (ServerRPCGrpc.ServerRPCBlockingStub stub : listOfStubs) {
            try {
              Server.ResponseServer responseServer = stub.withDeadlineAfter(2, TimeUnit.SECONDS)
                      .accept(serverRequest);
              // Check if all the servers have come to a consensus. Promise ID|Operation|Key|Value
              prevValue = responseServer.getResponseMessage().split(" ")[1] + " "
                      + responseServer.getResponseMessage().split(" ")[2] + " "
                      + responseServer.getResponseMessage().split(" ")[3];
//              System.out.println("Reached the accept block");
              if (!prevValue.equals(currentValue)) {
                prevValueAcceptorCount += 1;
              } else {
                acceptorCount += 1;
              }
            } catch (Exception e) {
//              System.out.println("Reached the catch block");
            }
          }
          if (prevValueAcceptorCount >= (totalServers / 2 + 1)) {
            consensusValue = prevValue;
          } else if (acceptorCount >= (totalServers / 2 + 1)) {
            consensusValue = currentValue;
          } else {
            LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                    + " Accept Phase rejected");
            throw new IllegalArgumentException("Accept Phase rejected");
          }
          System.out.println("Accept phase completed");
          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Accept Phase complete !!");

          // Learner is called
          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Learn phase initiated");

          serverRequest = Server.RequestServer.newBuilder()
                  .setOperation(consensusValue.split(" ")[0])
                  .setKey(Integer.parseInt(consensusValue.split(" ")[1]))
                  .setValue(consensusValue.split(" ")[2]).build();

          // Add data from current Server
          dictionaryUpdate(consensusValue.split(" ")[0],
                  Integer.parseInt(consensusValue.split(" ")[1]),
                  consensusValue.split(" ")[2]);

          // Initiating Learn Phase
          initLearnPhase(listOfStubs, serverRequest);

          System.out.println(getDictionary());

          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Learn Phase Complete !!");
          clientResponse = Keyvalue.ResponseOperation.newBuilder().setResponse("The key value pair"
                  + " are added to the dictionary").build();
          break;

        case "get":
          key = (int) request.getKey();
          if (!(dictionary.containsKey(key))) {
            throw new IllegalArgumentException("Key is not present");
          }
          value = dictionary.get((key));
          clientResponse = Keyvalue.ResponseOperation.newBuilder()
                  .setResponse("Value: " + value).build();
          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Value returned by Dictionary");
          break;

        case "delete":
          PID += 1;
          key = (int) request.getKey();
          if (!(dictionary.containsKey(key))) {
            throw new IllegalArgumentException("Key is not present");
          }

          // Initiating Paxos Algorithm
          // Prepare Phase -> sending promise to all acceptors
          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Initiating Prepare Phase");
          count = 0;
          while (count < (totalServers / 2 + 1)) {
            req = Integer.toString(PID);
            serverRequest = Server.RequestServer.newBuilder().setRequestMessage(req).build();
            System.out.println("PID " + PID + " Delete");
            count = preparePhase(listOfStubs, count, serverRequest, totalServers);
          }

          // Accept Phase -> sending promise and value to be stored
          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Accept Phase Initiated");
          acceptorCount = 0;
          prevValueAcceptorCount = 0;
          prevValue = null;

          req = Integer.toString(PID);
          serverRequest = Server.RequestServer.newBuilder().setRequestMessage(req)
                  .setOperation(operation).setKey(key).build();
          currentValue = operation.toLowerCase() + " " + key;
          for (ServerRPCGrpc.ServerRPCBlockingStub stub : listOfStubs) {
            try {
              Server.ResponseServer responseServer = stub.withDeadlineAfter(2, TimeUnit.SECONDS)
                      .accept(serverRequest);

              // Check if all the servers have come to a consensus
              prevValue = responseServer.getResponseMessage().split(" ")[1] + " "
                      + responseServer.getResponseMessage().split(" ")[2];
              if (!prevValue.equals(currentValue)) {
                prevValueAcceptorCount += 1;
              } else {
                acceptorCount += 1;
              }
            } catch (Exception ignored) {
            }
          }
          if (prevValueAcceptorCount >= (totalServers / 2 + 1)) {
            consensusValue = prevValue;
          } else if (acceptorCount >= (totalServers / 2 + 1)) {
            consensusValue = currentValue;
          } else {
            LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                    + " Accept Phase Rejected");
            throw new IllegalArgumentException("Accept Phase rejected");
          }

          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Learn Phase initiated");
          // Learner is called
          serverRequest = Server.RequestServer.newBuilder()
                  .setOperation(consensusValue.split(" ")[0])
                  .setKey(Integer.parseInt(consensusValue.split(" ")[1]))
                  .build();

          // Delete data from current Server
          dictionaryUpdate(consensusValue.split(" ")[0],
                  Integer.parseInt(consensusValue.split(" ")[1]));

          // Initiating Learn Phase
          initLearnPhase(listOfStubs, serverRequest);

          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Learn Phase Complete !!");
          clientResponse = Keyvalue.ResponseOperation.newBuilder().setResponse("The key value pair"
                  + " are deleted from the dictionary").build();
          break;

        default:
          throw new IllegalArgumentException("Incorrect operation provided");
      }
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Thread ID: " + Thread.currentThread().getId() + " "
              + e.getMessage());

      switch (operation.toLowerCase()) {
        case "put":
          clientResponse = Keyvalue.ResponseOperation.newBuilder()
                  .setResponse("Received unsolicited clientResponse acknowledging unknown PUT with "
                          + "an " + "invalid Key : " + key).build();
          break;
        case "get":
          clientResponse = Keyvalue.ResponseOperation.newBuilder()
                  .setResponse("Received unsolicited clientResponse acknowledging unknown GET with "
                          + "an " + "invalid key : " + key).build();
          break;
        case "delete":
          clientResponse = Keyvalue.ResponseOperation.newBuilder()
                  .setResponse("Received unsolicited clientResponse acknowledging unknown DELETE "
                          + "with an " + "invalid key : " + key).build();
          break;
        default:
          clientResponse = Keyvalue.ResponseOperation.newBuilder()
                  .setResponse(e.getMessage()).build();
          break;
      }
    }

    // method sends the clientResponse to the Client
    responseObserver.onNext(clientResponse);

    // called after a method has sent the clientResponse
    responseObserver.onCompleted();
  }

  private int preparePhase(List<ServerRPCGrpc.ServerRPCBlockingStub> listOfStubs, int count,
                           Server.RequestServer serverRequest, int totalServers) {
    for (ServerRPCGrpc.ServerRPCBlockingStub stub : listOfStubs) {
      try {
        Server.ResponseServer responseServer = stub.withDeadlineAfter(2, TimeUnit.SECONDS)
                .prepare(serverRequest);
        Thread.sleep(2000);
        if (!responseServer.getResponseMessage().contains("Reject")) {
          count += 1;
        }
      } catch (Exception ignored) {
//       System.out.println("reached the catch block");
      }
    }
    LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
            + count + " Servers agreed on a Promise");
    if (count < (totalServers / 2 + 1)) {
      count = 0;
    }
    return count;
  }

}
