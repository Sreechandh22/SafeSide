package com.safeside.model;

import java.util.List;

public class Route {
    private String userId;
    private List<Location> locations;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Route{" +
                "userId='" + userId + '\'' +
                ", locations=" + locations +
                '}';
    }
}
