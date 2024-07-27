package com.safeside.service;

import com.safeside.model.Route;
import com.safeside.model.Location;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class EvacuationService {

    // Mock method to simulate route calculation based on user ID
    public Route calculateRoute(String userId) {
        // Mock data for the sake of example
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(12.9715987, 77.594566));
        locations.add(new Location(12.2958104, 76.6393805));
        locations.add(new Location(11.0168445, 76.9558321));
        
        Route route = new Route();
        route.setLocations(locations);
        route.setUserId(userId);
        return route;
    }
}
