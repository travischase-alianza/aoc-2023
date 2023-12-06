package com.alianza.aoc.day05;

import com.alianza.aoc.common.IReport;
import com.alianza.aoc.day05.dataobject.Almanac;
import com.alianza.aoc.day05.dataobject.ProductType;
import com.alianza.aoc.day05.dataobject.SeedAtlas;

public class Day05Part1Report implements IReport {
    public void report(int lineCount, Object transformResult, Object aggregateResult) {
        System.out.println("[DEBUG Report] New Report");

        Almanac almanac = ((Almanac)transformResult);
        SeedAtlas seedAtlas = ((SeedAtlas)aggregateResult);

        long smallestSeed = -1L;
        long smallestLocation = -1L;

        for(int i = 0; almanac.getSeeds().size() > i; i++) {
            long seed = almanac.getSeeds().get(i);
            long location =  seedAtlas.getSeedMap(seed).getStep(ProductType.LOCATION.getValue());

            if (smallestLocation == -1L || location < smallestLocation) {
                smallestLocation = location;
                smallestSeed = seed;
            }

            System.out.println("[DEBUG Report] seed " + seed + " location " + location);
        }

        System.out.println("RESULT: seed " + smallestSeed + " location " + smallestLocation);
    } 
}
