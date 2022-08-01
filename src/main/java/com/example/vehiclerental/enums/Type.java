package com.example.vehiclerental.enums;

import java.util.HashMap;
import java.util.Map;

public enum Type {
    CAR("CAR"),
    BIKE("BIKE"),
    BUS("BUS"),
    VAN("VAN");

    private String type;

    Type(String type) {
        this.type = type;
    }

    private static Map<String, Type> typeMap = new HashMap<String, Type>();
    static {
        for (Type property: Type.values()) {
            typeMap.put(property.name().toUpperCase(), property);
        }
    }

    public static Type getType(final String name) {
        String key = name != null ? name.toUpperCase() : name;
        return typeMap.get(key);
    }

    public String getType() {
        return this.type;
    }
}
