package com.safeside.service;

import com.safeside.model.Route;
import org.springframework.stereotype.Service;

@Service
public class EvacuationService {

    public Route calculateRoute(String userId) {
        // Logic to calculate the evacuation route based on user ID
        Route route = new Route();
        // Example: Add dummy locations to the route
        route.setLocations(List.of(new Location(1.0, 2.0), new Location(3.0, 4.0)));
        return route;
    }
}
