package Server;

import com.example.KeyValueStoreImpl;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import io.grpc.*;

/**
 * The Server class is responsible for starting the server at a particular port.
 */
public class Server implements ThreadFactory {

  private static Logger LOGGER;

  /**
   * Log setup method initializes the logging setup in the class.
   */
  public static void logSetup(String serverName) {
    LOGGER = Logger.getLogger(serverName);
    SimpleFormatter simpleFormatter = new SimpleFormatter();
    FileHandler fileHandler;
    try {
      fileHandler = new FileHandler(serverName + ".log");
      fileHandler.setFormatter(simpleFormatter);

      LOGGER.addHandler(fileHandler);
    } catch (IOException e) {
      e.printStackTrace();
    }
    LOGGER.setLevel(Level.ALL);
  }

  @Override
  public Thread newThread(Runnable r) {
    return new Thread(r);
  }

  public io.grpc.Server serverStart(String portNumber, String serverName) throws IOException, InterruptedException {
    io.grpc.Server server = ServerBuilder.forPort(Integer.parseInt(portNumber))
            .addService(new KeyValueStoreImpl()).addService(new ServerCoordinatorImpl())
            .executor(Executors.newFixedThreadPool(16)).build();

    server.start();
    server.awaitTermination();
    LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId() +
            " Server has been started on port: " + server.getPort() + "-" + serverName);
    return server;
  }

  /**
   * The entry point for starting a server.
   *
   * @param args the input arguments
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  public static void main(String[] args) throws IOException, InterruptedException {

    Server serverObject = new Server();
    

    try {
      if (args[0].equals("")) {
        throw new IllegalArgumentException("enter the server port");
      }
      // portNumber|serverName,port2|port3|port4|port5

      String portNumber = args[0].split(",")[0].split("\\|")[0];
      String serverName = args[0].split(",")[0].split("\\|")[1];

      // List of port numbers of other Servers
      String[] listOfServers = args[0].split(",")[1].split("\\|");

      // Log initialization
      logSetup(serverName);

//    Server object initialization
      io.grpc.Server server = ServerBuilder.forPort(Integer.parseInt(portNumber))
              .addService(new KeyValueStoreImpl()).addService(new ServerCoordinatorImpl())
              .executor(Executors.newFixedThreadPool(8)).build();

        server.start();

      LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId() +
              " Server has been started on port: " + server.getPort() + "-" + serverName);


      // Initialising the service logs
      KeyValueStoreImpl.logSetup(serverName, portNumber, listOfServers);
      ServerCoordinatorImpl.logSetup(serverName);

      // Await termination
      server.awaitTermination();
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, e.getMessage());
    }
  }


}
