package Server;

import com.example.KeyValueStoreImpl;
import com.example.grpc.Server;
import com.example.grpc.ServerRPCGrpc;

import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.stub.StreamObserver;

public class ServerCoordinatorImpl extends ServerRPCGrpc.ServerRPCImplBase {
  private static Logger LOGGER;
  private String req;
  private String operation;
  private int key;
  private String value = "";
  Stack<String> stack = new Stack<>();
  Stack<String> acceptorStack = new Stack<>();
  Random rand = new Random();


  /**
   * Log setup method initializes the logging setup in the class.
   */
  public static void logSetup(String serverName) {
    LOGGER = Logger.getLogger(serverName);
    LOGGER.setLevel(Level.ALL);
  }

  @Override
  public void prepare(Server.RequestServer request,
                      StreamObserver<Server.ResponseServer> responseObserver) {
    String promiseNumber = request.getRequestMessage();

    if (stack.empty()) {
      stack.push(promiseNumber);
      Server.ResponseServer responseServer = Server.ResponseServer.newBuilder()
              .setResponseMessage(promiseNumber).build();
      responseObserver.onNext(responseServer);
      responseObserver.onCompleted();
      LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
              + " Accepted Promise " + promiseNumber + " " + "Prepare Phase by " + LOGGER.getName());
    } else {
      String prevPromiseNo = stack.peek();
      if (Integer.parseInt(prevPromiseNo) < Integer.parseInt(promiseNumber)) {
        Server.ResponseServer responseServer = Server.ResponseServer.newBuilder()
                .setResponseMessage(promiseNumber + ", Accepted " + prevPromiseNo).build();
        stack.push(prevPromiseNo);
        responseObserver.onNext(responseServer);
        responseObserver.onCompleted();
        LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                + " Accepted Promise " + promiseNumber + " " + "Prepare Phase by " + LOGGER.getName());
      } else {
        Server.ResponseServer responseServer = Server.ResponseServer.newBuilder()
                .setResponseMessage("Reject Promise").build();
        stack.push(prevPromiseNo);
        responseObserver.onNext(responseServer);
        responseObserver.onCompleted();
        LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                + responseServer.getResponseMessage() + LOGGER.getName());
      }
    }
  }

  @Override
  public void accept(Server.RequestServer request,
                     StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
    req = request.getRequestMessage();
    operation = request.getOperation();
    key = (int) request.getKey();
    int flag = 0;

    if (operation.toLowerCase().contains("put")) {
      value = request.getValue();
    }
    // Random delay is being generated
    try {
      if (rand.nextInt(4) > 2) {
        Thread.sleep(3000);
        LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                + " Server failed to accept" + " " + LOGGER.getName());
        flag = 1;
        String message = "Server failed to accept" + " " + LOGGER.getName();
        Server.ResponseServer responseServer = Server.ResponseServer.newBuilder()
                .setResponseMessage(message).build();
        responseObserver.onNext(responseServer);
        responseObserver.onCompleted();
      } else {
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if (flag == 0) {
      if (acceptorStack.empty()) {
        String message = req + " " + operation + " " + key + " " + value;
        acceptorStack.push(message);
        Server.ResponseServer responseServer = Server.ResponseServer.newBuilder()
                .setResponseMessage(message).build();
        acceptorStack.push(message);
        responseObserver.onNext(responseServer);
        responseObserver.onCompleted();
        LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                + " Accepted the value" + " " + LOGGER.getName());
      } else {
        String prevAcceptMessage = acceptorStack.peek();
        if (Integer.parseInt(prevAcceptMessage.split(" ")[0]) > Integer.parseInt(req)) {
          throw new IllegalArgumentException("Paxos is functioning incorrectly !! Shouldnt be here");
        }
        String prevNumber = prevAcceptMessage.split(" ")[0];
        String prevOperation = prevAcceptMessage.split(" ")[1];
        String prevKey = prevAcceptMessage.split(" ")[2];
        String message;
        if (prevAcceptMessage.split(" ").length > 3) {
          message = req + " " + prevOperation + " " + prevKey + " "
                  + prevAcceptMessage.split(" ")[3];
        } else {
          message = req + " " + prevOperation + " " + prevKey;
        }
        Server.ResponseServer responseServer = Server.ResponseServer.newBuilder()
                .setResponseMessage(message).build();
        acceptorStack.push(message);
        responseObserver.onNext(responseServer);
        responseObserver.onCompleted();
        LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                + " Accepted the value" + " " + LOGGER.getName());
      }
    }
  }

  @Override
  public void learn(Server.RequestServer request,
                    StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
    operation = request.getOperation();
    key = (int) request.getKey();
    if (operation.toLowerCase().contains("put")) {
      value = request.getValue();
    }
    KeyValueStoreImpl.dictionaryUpdate(operation, key, value);
    Server.ResponseServer responseServer;
    if (operation.equals("put")) {
      responseServer = Server.ResponseServer.newBuilder()
              .setResponseMessage("Successfully added value to Dictionary").build();
    } else {
      responseServer = Server.ResponseServer.newBuilder()
              .setResponseMessage("Successfully deleted value from Dictionary").build();
    }
    stack = new Stack<String>();
    acceptorStack = new Stack<String>();
    System.out.println(KeyValueStoreImpl.getServerName() + " " + KeyValueStoreImpl.getDictionary());
    responseObserver.onNext(responseServer);
    responseObserver.onCompleted();
  }

}