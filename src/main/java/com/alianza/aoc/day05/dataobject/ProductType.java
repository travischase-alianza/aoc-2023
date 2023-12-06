package com.alianza.aoc.day05.dataobject;

public enum ProductType {
    SEEDS(0),
    SOIL(1),
    FERTILIZER(2),
    WATER(3),
    LIGHT(4),
    TEMPERATURE(5),
    HUMIDITY(6),
    LOCATION(7);
    
    private final int value;
    private ProductType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
