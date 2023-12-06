package com.alianza.aoc.day05.dataobject;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class SeedMap {
    @Getter @Setter ArrayList<Long> map;

    public SeedMap() {
        this.map = new ArrayList<>();

        this.map.add(ProductType.SEEDS.getValue(), -1L);
        this.map.add(ProductType.SOIL.getValue(), -1L);
        this.map.add(ProductType.FERTILIZER.getValue(), -1L);
        this.map.add(ProductType.WATER.getValue(), -1L);
        this.map.add(ProductType.LIGHT.getValue(), -1L);
        this.map.add(ProductType.TEMPERATURE.getValue(), -1L);
        this.map.add(ProductType.HUMIDITY.getValue(), -1L);
        this.map.add(ProductType.LOCATION.getValue(), -1L);
    }

    public void setStep(int productType, long id) {
        this.map.set(productType, id);
    }

    public long getStep(int productType) {
        return this.map.get(productType);
    }
    
    @Override
    public String toString() { 
        String result = this.map.toString();
        return result;
    } 
}
