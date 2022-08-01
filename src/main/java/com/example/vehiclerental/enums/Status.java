package com.example.vehiclerental.enums;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    AVAILABLE("AVAILABLE"),
    BOOKED("BOOKED"),
    MAINTENANCE("MAINTENANCE");

    private String status;

    Status(String status) {
        this.status = status;
    }

    private static Map<String, Status> statusMap = new HashMap<String, Status>();
    static {
        for (Status property: Status.values()) {
            statusMap.put(property.name().toUpperCase(), property);
        }
    }

    public static Status getStatus(final String name) {
        String key = name != null ? name.toUpperCase() : name;
        return statusMap.get(key);
    }

    public String getStatus() {
        return this.status;
    }
}
