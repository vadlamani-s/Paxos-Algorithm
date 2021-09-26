package Client;

import com.example.grpc.Keyvalue;
import com.example.grpc.keyValueStoreGrpc;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * The Client has the implementation methods for creating a client. It communicates with the server
 * via studs.
 */
public class Client {

  private static Logger LOGGER;
  private static DateTimeFormatter dtf;
  private static keyValueStoreGrpc.keyValueStoreBlockingStub clientStub = null;


  private static void setupLog(String clientName) {
    LOGGER = Logger.getLogger(clientName);
    dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
    FileHandler fileHandler;
    try {
      fileHandler = new FileHandler(clientName + ".log");
      fileHandler.setFormatter(new SimpleFormatter());

      LOGGER.addHandler(fileHandler);
    } catch (IOException e) {
      e.printStackTrace();
    }
    LOGGER.setLevel(Level.ALL);
  }

  private static String demoRuns() {
    return "put 1 data1\n" + "put 2 data2\n" + "get 1\n" + "get 2\n" + "delete 1\n" + "delete 2\n"
            + "put 3 data3\n" + "delete 3\n" + "get 3\n" + "put 4 data4\n" + "put 1 data1\n"
            + "get 4\n" + "get 5\n" + "delete 4\n" + "add 5\n";
  }

  private static Keyvalue.RequestOperation requestResponse(String data) {
    Keyvalue.RequestOperation request = null;

    if (data.split(" ").length == 2) {
      String[] req = data.split(" ");
      request = Keyvalue.RequestOperation.newBuilder()
              .setOperation(req[0]).setKey(Integer.parseInt(req[1])).build();
    } else if (data.split(" ").length >= 3) {
      String[] req = data.split(" ");
      request = Keyvalue.RequestOperation.newBuilder()
              .setOperation(req[0]).setKey(Integer.parseInt(req[1])).setValue(req[2]).build();
    }
    return request;
  }

  private static void clientOperations(String clientName) throws InterruptedException {
    // Input data via console
    Scanner sc = new Scanner(System.in);
//    String[] demoOperations = demoRuns().split("\n");
//    for (String operation : demoOperations) {
//      System.out.println("Enter operation and data");
//      System.out.println(operation);
//      Keyvalue.RequestOperation request = requestResponse(operation);
//      Keyvalue.ResponseOperation response = clientStub.dictionaryOperation(request);
//      Thread.sleep(6000);
//      LOGGER.log(Level.INFO, dtf.format(LocalDateTime.now()) + " " + clientName + ": "
//              + operation + "\nResponse: " + response);
//    }

    while (true) {
      System.out.println("Enter operation and data\n");
      String data = sc.nextLine();
      if (data.toLowerCase().equals("exit")) {
        break;
      }
      Keyvalue.RequestOperation request = requestResponse(data);
      Keyvalue.ResponseOperation response = clientStub.dictionaryOperation(request);
      LOGGER.log(Level.INFO, dtf.format(LocalDateTime.now()) + " " + clientName + ": "
              + response);
      Thread.sleep(6000);
    }

  }

  /**
   * The entry point of Client application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {

    try {
      if (args[0].equals("")) {
        throw new IllegalArgumentException("enter the server port");
      }

      String portNumber = args[0].split("\\|")[0];
      String clientName = args[0].split("\\|")[1];

      // Log setup
      setupLog(clientName);

      String targetPort = "localhost:" + portNumber;
      // Making a connection to the server
      final ManagedChannel channel = ManagedChannelBuilder.forTarget(targetPort)
              .usePlaintext().build();

      // Client Stub created
      clientStub = keyValueStoreGrpc.newBlockingStub(channel);

      LOGGER.log(Level.INFO, dtf.format(LocalDateTime.now()) + " " + clientName + ": "
              + channel.toString());

      Client.clientOperations(clientName);

      // Disconnecting the Client
      channel.shutdownNow();
      LOGGER.log(Level.INFO, dtf.format(LocalDateTime.now()) + " " + clientName + ": "
              + " Channel Disconnected");

    } catch (Exception e) {
      LOGGER.log(Level.WARNING, dtf.format(LocalDateTime.now()) + " " + " "
              + args[0].split("\\|")[0] + ": " + e.getMessage());
    }

  }
}

