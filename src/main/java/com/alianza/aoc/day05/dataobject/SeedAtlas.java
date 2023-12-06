package com.alianza.aoc.day05.dataobject;

import java.util.HashMap;
import lombok.Getter;

public class SeedAtlas {
    @Getter HashMap<Long, SeedMap> atlas;

    public SeedAtlas() {
        this.atlas = new HashMap<>();
    }

    public void addSeed(long seed) {
        this.atlas.put(seed, new SeedMap());
    }
   
    public SeedMap getSeedMap(long seed) {
        return this.atlas.get(seed);
    }

    @Override
    public String toString() { 
        String result = this.atlas.toString();
        return result;
    } 
}
