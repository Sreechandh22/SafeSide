# API Design

## Endpoints

### GET /api/route
Retrieve the optimal evacuation route for a user.

**Request Parameters:**
- `userId`: The ID of the user.

**Response:**
- `Route`: The calculated evacuation route.

## gRPC Service
The gRPC service defines a method for retrieving evacuation routes in real-time.

### Service Definition
```proto
syntax = "proto3";

service EvacuationService {
    rpc GetRoute(UserRequest) returns (RouteResponse);
}

message UserRequest {
    string userId = 1;
}

message RouteResponse {
    string route = 1;
}
