package com.app;

import com.logistics.creator.Logistics;
import com.logistics.creator.RoadLogistics;
import com.logistics.creator.SeaLogistics;

public final class LogisticsSelector {

    private LogisticsSelector() {
    }

    public static Logistics select(DeliveryMode mode) {
        return switch (mode) {
            case ROAD -> new RoadLogistics();
            case SEA -> new SeaLogistics();
        };
    }
}