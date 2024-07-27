package com.safeside.util;

import com.safeside.model.Location;

public class BeaconProcessor {

    public Location processBeaconSignal(BeaconSignal signal) {
        // Process signal to determine location
        double x = signal.getX();
        double y = signal.getY();
        return new Location(x, y);
    }
}
