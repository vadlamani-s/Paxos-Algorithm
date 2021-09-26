package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: keyvalue.proto")
public final class keyValueStoreGrpc {

  private keyValueStoreGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.keyValueStore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Keyvalue.RequestOperation,
      com.example.grpc.Keyvalue.ResponseOperation> getDictionaryOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dictionaryOperation",
      requestType = com.example.grpc.Keyvalue.RequestOperation.class,
      responseType = com.example.grpc.Keyvalue.ResponseOperation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Keyvalue.RequestOperation,
      com.example.grpc.Keyvalue.ResponseOperation> getDictionaryOperationMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Keyvalue.RequestOperation, com.example.grpc.Keyvalue.ResponseOperation> getDictionaryOperationMethod;
    if ((getDictionaryOperationMethod = keyValueStoreGrpc.getDictionaryOperationMethod) == null) {
      synchronized (keyValueStoreGrpc.class) {
        if ((getDictionaryOperationMethod = keyValueStoreGrpc.getDictionaryOperationMethod) == null) {
          keyValueStoreGrpc.getDictionaryOperationMethod = getDictionaryOperationMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Keyvalue.RequestOperation, com.example.grpc.Keyvalue.ResponseOperation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "dictionaryOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Keyvalue.RequestOperation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Keyvalue.ResponseOperation.getDefaultInstance()))
              .setSchemaDescriptor(new keyValueStoreMethodDescriptorSupplier("dictionaryOperation"))
              .build();
        }
      }
    }
    return getDictionaryOperationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static keyValueStoreStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<keyValueStoreStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<keyValueStoreStub>() {
        @java.lang.Override
        public keyValueStoreStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new keyValueStoreStub(channel, callOptions);
        }
      };
    return keyValueStoreStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static keyValueStoreBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<keyValueStoreBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<keyValueStoreBlockingStub>() {
        @java.lang.Override
        public keyValueStoreBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new keyValueStoreBlockingStub(channel, callOptions);
        }
      };
    return keyValueStoreBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static keyValueStoreFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<keyValueStoreFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<keyValueStoreFutureStub>() {
        @java.lang.Override
        public keyValueStoreFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new keyValueStoreFutureStub(channel, callOptions);
        }
      };
    return keyValueStoreFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class keyValueStoreImplBase implements io.grpc.BindableService {

    /**
     */
    public void dictionaryOperation(com.example.grpc.Keyvalue.RequestOperation request,
        io.grpc.stub.StreamObserver<com.example.grpc.Keyvalue.ResponseOperation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDictionaryOperationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDictionaryOperationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Keyvalue.RequestOperation,
                com.example.grpc.Keyvalue.ResponseOperation>(
                  this, METHODID_DICTIONARY_OPERATION)))
          .build();
    }
  }

  /**
   */
  public static final class keyValueStoreStub extends io.grpc.stub.AbstractAsyncStub<keyValueStoreStub> {
    private keyValueStoreStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected keyValueStoreStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new keyValueStoreStub(channel, callOptions);
    }

    /**
     */
    public void dictionaryOperation(com.example.grpc.Keyvalue.RequestOperation request,
        io.grpc.stub.StreamObserver<com.example.grpc.Keyvalue.ResponseOperation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDictionaryOperationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class keyValueStoreBlockingStub extends io.grpc.stub.AbstractBlockingStub<keyValueStoreBlockingStub> {
    private keyValueStoreBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected keyValueStoreBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new keyValueStoreBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.Keyvalue.ResponseOperation dictionaryOperation(com.example.grpc.Keyvalue.RequestOperation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDictionaryOperationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class keyValueStoreFutureStub extends io.grpc.stub.AbstractFutureStub<keyValueStoreFutureStub> {
    private keyValueStoreFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected keyValueStoreFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new keyValueStoreFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Keyvalue.ResponseOperation> dictionaryOperation(
        com.example.grpc.Keyvalue.RequestOperation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDictionaryOperationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DICTIONARY_OPERATION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final keyValueStoreImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(keyValueStoreImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DICTIONARY_OPERATION:
          serviceImpl.dictionaryOperation((com.example.grpc.Keyvalue.RequestOperation) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Keyvalue.ResponseOperation>) responseObserver);
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

  private static abstract class keyValueStoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    keyValueStoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.Keyvalue.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("keyValueStore");
    }
  }

  private static final class keyValueStoreFileDescriptorSupplier
      extends keyValueStoreBaseDescriptorSupplier {
    keyValueStoreFileDescriptorSupplier() {}
  }

  private static final class keyValueStoreMethodDescriptorSupplier
      extends keyValueStoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    keyValueStoreMethodDescriptorSupplier(String methodName) {
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
      synchronized (keyValueStoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new keyValueStoreFileDescriptorSupplier())
              .addMethod(getDictionaryOperationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
