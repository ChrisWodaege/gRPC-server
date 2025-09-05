package org.example;


import com.example.grpc.HelloServiceGrpc;
import com.example.grpc.HelloServiceProto.HelloRequest;
import com.example.grpc.HelloServiceProto.HelloResponse;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    String name = request.getName();
    String message = "Hallo, " + name + "!";
    System.out.println(name + " is calling");
    HelloResponse response = HelloResponse.newBuilder()
        .setMessage(message)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}

