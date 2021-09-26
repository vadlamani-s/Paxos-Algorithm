package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: Server.proto")
public final class ServerRPCGrpc {

  private ServerRPCGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.ServerRPC";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer,
      com.example.grpc.Server.ResponseServer> getDictionaryServerOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dictionaryServerOperation",
      requestType = com.example.grpc.Server.RequestServer.class,
      responseType = com.example.grpc.Server.ResponseServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer,
      com.example.grpc.Server.ResponseServer> getDictionaryServerOperationMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer, com.example.grpc.Server.ResponseServer> getDictionaryServerOperationMethod;
    if ((getDictionaryServerOperationMethod = ServerRPCGrpc.getDictionaryServerOperationMethod) == null) {
      synchronized (ServerRPCGrpc.class) {
        if ((getDictionaryServerOperationMethod = ServerRPCGrpc.getDictionaryServerOperationMethod) == null) {
          ServerRPCGrpc.getDictionaryServerOperationMethod = getDictionaryServerOperationMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Server.RequestServer, com.example.grpc.Server.ResponseServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "dictionaryServerOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Server.RequestServer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Server.ResponseServer.getDefaultInstance()))
              .setSchemaDescriptor(new ServerRPCMethodDescriptorSupplier("dictionaryServerOperation"))
              .build();
        }
      }
    }
    return getDictionaryServerOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer,
      com.example.grpc.Server.ResponseServer> getInitializationServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "initializationServer",
      requestType = com.example.grpc.Server.RequestServer.class,
      responseType = com.example.grpc.Server.ResponseServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer,
      com.example.grpc.Server.ResponseServer> getInitializationServerMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer, com.example.grpc.Server.ResponseServer> getInitializationServerMethod;
    if ((getInitializationServerMethod = ServerRPCGrpc.getInitializationServerMethod) == null) {
      synchronized (ServerRPCGrpc.class) {
        if ((getInitializationServerMethod = ServerRPCGrpc.getInitializationServerMethod) == null) {
          ServerRPCGrpc.getInitializationServerMethod = getInitializationServerMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Server.RequestServer, com.example.grpc.Server.ResponseServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "initializationServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Server.RequestServer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Server.ResponseServer.getDefaultInstance()))
              .setSchemaDescriptor(new ServerRPCMethodDescriptorSupplier("initializationServer"))
              .build();
        }
      }
    }
    return getInitializationServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer,
      com.example.grpc.Server.ResponseServer> getPrepareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "prepare",
      requestType = com.example.grpc.Server.RequestServer.class,
      responseType = com.example.grpc.Server.ResponseServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer,
      com.example.grpc.Server.ResponseServer> getPrepareMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer, com.example.grpc.Server.ResponseServer> getPrepareMethod;
    if ((getPrepareMethod = ServerRPCGrpc.getPrepareMethod) == null) {
      synchronized (ServerRPCGrpc.class) {
        if ((getPrepareMethod = ServerRPCGrpc.getPrepareMethod) == null) {
          ServerRPCGrpc.getPrepareMethod = getPrepareMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Server.RequestServer, com.example.grpc.Server.ResponseServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "prepare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Server.RequestServer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Server.ResponseServer.getDefaultInstance()))
              .setSchemaDescriptor(new ServerRPCMethodDescriptorSupplier("prepare"))
              .build();
        }
      }
    }
    return getPrepareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer,
      com.example.grpc.Server.ResponseServer> getAcceptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "accept",
      requestType = com.example.grpc.Server.RequestServer.class,
      responseType = com.example.grpc.Server.ResponseServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer,
      com.example.grpc.Server.ResponseServer> getAcceptMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer, com.example.grpc.Server.ResponseServer> getAcceptMethod;
    if ((getAcceptMethod = ServerRPCGrpc.getAcceptMethod) == null) {
      synchronized (ServerRPCGrpc.class) {
        if ((getAcceptMethod = ServerRPCGrpc.getAcceptMethod) == null) {
          ServerRPCGrpc.getAcceptMethod = getAcceptMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Server.RequestServer, com.example.grpc.Server.ResponseServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "accept"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Server.RequestServer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Server.ResponseServer.getDefaultInstance()))
              .setSchemaDescriptor(new ServerRPCMethodDescriptorSupplier("accept"))
              .build();
        }
      }
    }
    return getAcceptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer,
      com.example.grpc.Server.ResponseServer> getLearnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "learn",
      requestType = com.example.grpc.Server.RequestServer.class,
      responseType = com.example.grpc.Server.ResponseServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer,
      com.example.grpc.Server.ResponseServer> getLearnMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Server.RequestServer, com.example.grpc.Server.ResponseServer> getLearnMethod;
    if ((getLearnMethod = ServerRPCGrpc.getLearnMethod) == null) {
      synchronized (ServerRPCGrpc.class) {
        if ((getLearnMethod = ServerRPCGrpc.getLearnMethod) == null) {
          ServerRPCGrpc.getLearnMethod = getLearnMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Server.RequestServer, com.example.grpc.Server.ResponseServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "learn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Server.RequestServer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Server.ResponseServer.getDefaultInstance()))
              .setSchemaDescriptor(new ServerRPCMethodDescriptorSupplier("learn"))
              .build();
        }
      }
    }
    return getLearnMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerRPCStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerRPCStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerRPCStub>() {
        @java.lang.Override
        public ServerRPCStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerRPCStub(channel, callOptions);
        }
      };
    return ServerRPCStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerRPCBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerRPCBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerRPCBlockingStub>() {
        @java.lang.Override
        public ServerRPCBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerRPCBlockingStub(channel, callOptions);
        }
      };
    return ServerRPCBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerRPCFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerRPCFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerRPCFutureStub>() {
        @java.lang.Override
        public ServerRPCFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerRPCFutureStub(channel, callOptions);
        }
      };
    return ServerRPCFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ServerRPCImplBase implements io.grpc.BindableService {

    /**
     */
    public void dictionaryServerOperation(com.example.grpc.Server.RequestServer request,
        io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDictionaryServerOperationMethod(), responseObserver);
    }

    /**
     */
    public void initializationServer(com.example.grpc.Server.RequestServer request,
        io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitializationServerMethod(), responseObserver);
    }

    /**
     */
    public void prepare(com.example.grpc.Server.RequestServer request,
        io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrepareMethod(), responseObserver);
    }

    /**
     */
    public void accept(com.example.grpc.Server.RequestServer request,
        io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAcceptMethod(), responseObserver);
    }

    /**
     */
    public void learn(com.example.grpc.Server.RequestServer request,
        io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLearnMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDictionaryServerOperationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Server.RequestServer,
                com.example.grpc.Server.ResponseServer>(
                  this, METHODID_DICTIONARY_SERVER_OPERATION)))
          .addMethod(
            getInitializationServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Server.RequestServer,
                com.example.grpc.Server.ResponseServer>(
                  this, METHODID_INITIALIZATION_SERVER)))
          .addMethod(
            getPrepareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Server.RequestServer,
                com.example.grpc.Server.ResponseServer>(
                  this, METHODID_PREPARE)))
          .addMethod(
            getAcceptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Server.RequestServer,
                com.example.grpc.Server.ResponseServer>(
                  this, METHODID_ACCEPT)))
          .addMethod(
            getLearnMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Server.RequestServer,
                com.example.grpc.Server.ResponseServer>(
                  this, METHODID_LEARN)))
          .build();
    }
  }

  /**
   */
  public static final class ServerRPCStub extends io.grpc.stub.AbstractAsyncStub<ServerRPCStub> {
    private ServerRPCStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerRPCStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerRPCStub(channel, callOptions);
    }

    /**
     */
    public void dictionaryServerOperation(com.example.grpc.Server.RequestServer request,
        io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDictionaryServerOperationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void initializationServer(com.example.grpc.Server.RequestServer request,
        io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitializationServerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void prepare(com.example.grpc.Server.RequestServer request,
        io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPrepareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void accept(com.example.grpc.Server.RequestServer request,
        io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void learn(com.example.grpc.Server.RequestServer request,
        io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLearnMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServerRPCBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServerRPCBlockingStub> {
    private ServerRPCBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerRPCBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerRPCBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.Server.ResponseServer dictionaryServerOperation(com.example.grpc.Server.RequestServer request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDictionaryServerOperationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.Server.ResponseServer initializationServer(com.example.grpc.Server.RequestServer request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializationServerMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.Server.ResponseServer prepare(com.example.grpc.Server.RequestServer request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPrepareMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.Server.ResponseServer accept(com.example.grpc.Server.RequestServer request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.Server.ResponseServer learn(com.example.grpc.Server.RequestServer request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLearnMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServerRPCFutureStub extends io.grpc.stub.AbstractFutureStub<ServerRPCFutureStub> {
    private ServerRPCFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerRPCFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerRPCFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Server.ResponseServer> dictionaryServerOperation(
        com.example.grpc.Server.RequestServer request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDictionaryServerOperationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Server.ResponseServer> initializationServer(
        com.example.grpc.Server.RequestServer request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitializationServerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Server.ResponseServer> prepare(
        com.example.grpc.Server.RequestServer request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPrepareMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Server.ResponseServer> accept(
        com.example.grpc.Server.RequestServer request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Server.ResponseServer> learn(
        com.example.grpc.Server.RequestServer request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLearnMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DICTIONARY_SERVER_OPERATION = 0;
  private static final int METHODID_INITIALIZATION_SERVER = 1;
  private static final int METHODID_PREPARE = 2;
  private static final int METHODID_ACCEPT = 3;
  private static final int METHODID_LEARN = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServerRPCImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServerRPCImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DICTIONARY_SERVER_OPERATION:
          serviceImpl.dictionaryServerOperation((com.example.grpc.Server.RequestServer) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer>) responseObserver);
          break;
        case METHODID_INITIALIZATION_SERVER:
          serviceImpl.initializationServer((com.example.grpc.Server.RequestServer) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer>) responseObserver);
          break;
        case METHODID_PREPARE:
          serviceImpl.prepare((com.example.grpc.Server.RequestServer) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer>) responseObserver);
          break;
        case METHODID_ACCEPT:
          serviceImpl.accept((com.example.grpc.Server.RequestServer) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer>) responseObserver);
          break;
        case METHODID_LEARN:
          serviceImpl.learn((com.example.grpc.Server.RequestServer) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Server.ResponseServer>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ServerRPCBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerRPCBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.Server.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServerRPC");
    }
  }

  private static final class ServerRPCFileDescriptorSupplier
      extends ServerRPCBaseDescriptorSupplier {
    ServerRPCFileDescriptorSupplier() {}
  }

  private static final class ServerRPCMethodDescriptorSupplier
      extends ServerRPCBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServerRPCMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServerRPCGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerRPCFileDescriptorSupplier())
              .addMethod(getDictionaryServerOperationMethod())
              .addMethod(getInitializationServerMethod())
              .addMethod(getPrepareMethod())
              .addMethod(getAcceptMethod())
              .addMethod(getLearnMethod())
              .build();
        }
      }
    }
    return result;
  }
}
