package com.safeside.grpc;

import com.safeside.model.Route;
import com.safeside.service.EvacuationService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

public class EvacuationServiceImpl extends EvacuationServiceGrpc.EvacuationServiceImplBase {

    @Autowired
    private EvacuationService evacuationService;

    @Override
    public void getRoute(UserRequest request, StreamObserver<RouteResponse> responseObserver) {
        String userId = request.getUserId();
        Route route = evacuationService.calculateRoute(userId);
        RouteResponse response = RouteResponse.newBuilder().setRoute(route.toString()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
