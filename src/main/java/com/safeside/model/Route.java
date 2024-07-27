package com.safeside.model;

import java.util.List;

public class Route {
    private List<Location> locations;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Route{" +
                "locations=" + locations +
                '}';
    }
}
