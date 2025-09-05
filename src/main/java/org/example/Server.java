package org.example;

import io.grpc.ServerBuilder;
import java.io.IOException;

public class Server {

  private Server() {}

  public static void run() throws IOException, InterruptedException {
    io.grpc.Server server = ServerBuilder.forPort(50051)
        .addService(new HelloServiceImpl())
        .build();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("gRPC Server wird beendet...");
      server.shutdown();
    }));

    System.out.println("gRPC Server startet auf Port 50051...");
    server.start();
    server.awaitTermination();
  }
}
