package org.lognet.springboot.grpc.demo;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;

public class DelegatingTracingServerInterceptor implements ServerInterceptor {

    private ServerInterceptor tracingServerInterceptor;

    public DelegatingTracingServerInterceptor(ServerInterceptor tracingServerInterceptor) {
        this.tracingServerInterceptor = tracingServerInterceptor;
    }
    
    
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        return this.tracingServerInterceptor.interceptCall(call, headers, next);
    }
}
