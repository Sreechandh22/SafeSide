# SafeSide: Real-Time Evacuation Route Guidance

Welcome to the SafeSide project repository. SafeSide is an advanced system designed to provide real-time evacuation routes to users during emergencies using cutting-edge technologies.

## Table of Contents

- [Introduction](#introduction)
- [Project Objectives](#project-objectives)
- [Technology and Tools](#technology-and-tools)
- [Setup](#setup)
- [Usage](#usage)
  - [Running the Application](#running-the-application)
  - [Using the Application](#using-the-application)
- [File Structure](#file-structure)
- [Implementation Details](#implementation-details)
- [Example Workflow](#example-workflow)
- [License](#license)
- [Contact](#contact)

## Introduction

SafeSide is a real-time evacuation route guidance system that leverages technologies such as Java, Spring Framework, gRPC, Bluetooth Beacons, and Google Maps API to provide users with accurate and timely evacuation routes during emergencies.

## Project Objectives

1. Provide real-time evacuation routes to users.
2. Utilize indoor geolocation using Bluetooth beacons.
3. Integrate Google Maps for route visualization.
4. Implement efficient algorithms for route calculation.

## Technology and Tools

- **Backend**: Java, Spring Framework
- **Real-time Data Transfer**: gRPC
- **Indoor Geolocation**: Bluetooth Beacons
- **Mapping and Visualization**: Google Maps API

## Setup

1. **Clone the repository**:

    ```sh
    git clone https://github.com/Sreechandh22/SafeSide.git
    cd SafeSide
    ```

2. **Build the project**:

    ```sh
    ./gradlew build
    ```

3. **Run the Spring Boot application**:

    ```sh
    ./gradlew bootRun
    ```

## Usage

### Running the Application

1. **Start the Spring Boot application**:

    ```sh
    ./gradlew bootRun
    ```

2. **Access the application**:

    Open your web browser and navigate to `http://localhost:8080`

### Using the Application

1. **User Location Update**:
   - Bluetooth beacons send signals to the user’s device, which are processed to determine the user’s current location.

2. **Route Calculation**:
   - The backend server processes the location data and calculates the optimal evacuation route using the RouteCalculator class.

3. **Route Visualization**:
   - The user’s device receives the route data and displays it on a map using the Google Maps API.

## File Structure

        SafeSide/
        ├── src/
        │ ├── main/
        │ │ ├── java/
        │ │ │ └── com/
        │ │ │ └── safeside/
        │ │ │ ├── SafeSideApplication.java
        │ │ │ ├── controller/
        │ │ │ │ └── EvacuationController.java
        │ │ │ ├── grpc/
        │ │ │ │ ├── EvacuationServiceImpl.java
        │ │ │ │ └── proto/
        │ │ │ │ └── evacuation.proto
        │ │ │ ├── model/
        │ │ │ │ └── Route.java
        │ │ │ ├── service/
        │ │ │ │ └── EvacuationService.java
        │ │ │ └── util/
        │ │ │ └── BeaconProcessor.java
        │ │ └── resources/
        │ │ ├── application.properties
        │ │ └── static/
        │ │ └── index.html
        │ ├── test/
        │ │ └── java/
        │ │ └── com/
        │ │ └── safeside/
        │ │ └── SafeSideApplicationTests.java
        ├── .gitignore
        ├── README.md
        ├── build.gradle
        ├── settings.gradle
        └── docs/
        └── design/
        ├── architecture.md
        ├── api-design.md
        └── beacon-setup.md


## Implementation Details

### Backend Development with Java and Spring

1. **Setting up the Spring Framework**:

    ```java
    @SpringBootApplication
    public class SafeSideApplication {
        public static void main(String[] args) {
            SpringApplication.run(SafeSideApplication.class, args);
        }
    }
    ```

2. **Creating RESTful APIs**:

    ```java
    @RestController
    @RequestMapping("/api")
    public class EvacuationController {
        
        @GetMapping("/route")
        public ResponseEntity<Route> getEvacuationRoute(@RequestParam String userId) {
            Route route = evacuationService.calculateRoute(userId);
            return new ResponseEntity<>(route, HttpStatus.OK);
        }
    }
    ```

### gRPC Integration

1. **Defining gRPC Service**:

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
    ```

2. **Implementing gRPC Service**:

    ```java
    public class EvacuationServiceImpl extends EvacuationServiceGrpc.EvacuationServiceImplBase {
        @Override
        public void getRoute(UserRequest request, StreamObserver<RouteResponse> responseObserver) {
            String userId = request.getUserId();
            String route = calculateEvacuationRoute(userId);
            
            RouteResponse response = RouteResponse.newBuilder().setRoute(route).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    ```

### Bluetooth Beacons for Geolocation

1. **Processing Beacon Signals**:

    ```java
    public class BeaconProcessor {
        
        public Location processBeaconSignal(BeaconSignal signal) {
            // Process signal to determine location
            double x = signal.getX();
            double y = signal.getY();
            return new Location(x, y);
        }
    }
    ```

### Route Optimization Algorithm

1. **Calculating Optimal Routes**:

    ```java
    public class RouteCalculator {
        
        public Route calculateOptimalRoute(Location currentLocation, List<Location> exits) {
            // Implement Dijkstra's or A* algorithm to find the shortest path
            Route optimalRoute = new Route();
            // Logic to calculate the shortest path
            return optimalRoute;
        }
    }
    ```

### Integration with Google Maps API

1. **Displaying Routes on Map**:

    ```javascript
    function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 15,
            center: {lat: -34.397, lng: 150.644}
        });
        var routeCoordinates = [
            {lat: -34.397, lng: 150.644},
            {lat: -35.397, lng: 151.644}
        ];
        var routePath = new google.maps.Polyline({
            path: routeCoordinates,
            geodesic: true,
            strokeColor: '#FF0000',
            strokeOpacity: 1.0,
            strokeWeight: 2
        });
        routePath.setMap(map);
    }
    ```

## Example Workflow

1. **User Location Update**:
   - Bluetooth beacons send signals to the user’s device, which are processed to determine the user’s current location.
   - The location data is sent to the backend server via a gRPC request.

2. **Route Calculation**:
   - The backend server processes the location data and calculates the optimal evacuation route using the RouteCalculator class.
   - The calculated route is sent back to the user’s device through a gRPC response.

3. **Route Visualization**:
   - The user’s device receives the route data and displays it on a map using the Google Maps API, guiding the user to safety.

## License

This project is licensed under the MIT License.

---

## Contact

For any inquiries or collaboration opportunities, please contact sreechandh2204@gmail.com.
