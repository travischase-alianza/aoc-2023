package com.alianza.aoc.day05;

import java.util.ArrayList;

import com.alianza.aoc.common.IReport;
import com.alianza.aoc.day05.dataobject.AlmanacMapRange;
import com.alianza.aoc.day05.dataobject.AlmanacSeedRange;
import com.alianza.aoc.day05.dataobject.ProductType;
import com.alianza.aoc.day05.dataobject.SeedAtlas;
import com.alianza.aoc.day05.dataobject.SeedMap;

public class Day05Part2Report implements IReport {

    long smallestSeed;
    long smallestLocation;

    public void report(int lineCount, Object transformResult, Object aggregateResult) {
        System.out.println("[DEBUG Report] New Report");

        AlmanacSeedRange almanac = ((AlmanacSeedRange)transformResult);
        SeedAtlas seedAtlas = ((SeedAtlas)aggregateResult);

        this.smallestSeed = -1L;
        this.smallestLocation = -1L;

        for(int i = 0; almanac.getSeedRanges().getRanges().size() > i; i++) {
            AlmanacMapRange seedRange = almanac.getSeedRanges().getRanges().get(i);

            long seedStart = seedRange.getSrcStart();
            for(long s = 0; seedRange.getRangeLen() > s; s++) {
                long seed = seedStart + s;
                long location = this.findSmallestLocation(seed, almanac);
                System.out.println("[DEBUG Report] seed " + seed + " location " + location);
            }
        }

        System.out.println("RESULT: seed " + this.smallestSeed + " has the smallest location " + this.smallestLocation);
    }

    private long findSmallestLocation(long seed, AlmanacSeedRange almanac) {
        // buildSeedToSoil
        long seedProduct = seed;

        ArrayList<AlmanacMapRange> ranges = almanac.getSeedToSoil().getRanges();

        long soilProduct = -1L;
        for(int r = 0; ranges.size() > r; r++) {
            AlmanacMapRange range = ranges.get(r);
            soilProduct = range.getDestination(seedProduct);
            if(soilProduct != -1L) {
                break;
            }
        }

        if(soilProduct == -1L) {
            soilProduct = seedProduct;
        }

        // buildSoilToFertilizer
        ranges = almanac.getSoilToFertilizer().getRanges();

        long fertilizerProduct = -1L;
        for(int r = 0; ranges.size() > r; r++) {
            AlmanacMapRange range = ranges.get(r);
            fertilizerProduct = range.getDestination(soilProduct);
            if(fertilizerProduct != -1L) {
                break;
            }
        }

        if(fertilizerProduct == -1L) {
            fertilizerProduct = soilProduct;
        }

        // buildFertilizerToWater
        ranges = almanac.getFertilizerToWater().getRanges();

        long waterProduct = -1L;
        for(int r = 0; ranges.size() > r; r++) {
            AlmanacMapRange range = ranges.get(r);
            waterProduct = range.getDestination(fertilizerProduct);
            if(waterProduct != -1L) {
                break;
            }
        }

        if(waterProduct == -1L) {
            waterProduct = fertilizerProduct;
        }

        // buildWaterToLight
        ranges = almanac.getWaterToLight().getRanges();

        long lightProduct = -1L;
        for(int r = 0; ranges.size() > r; r++) {
            AlmanacMapRange range = ranges.get(r);
            lightProduct = range.getDestination(waterProduct);
            if(lightProduct != -1L) {
                break;
            }
        }

        if(lightProduct == -1L) {
            lightProduct = waterProduct;
        }

        // buildLightToTemperature
        ranges = almanac.getLightToTemperature().getRanges();

        long temperatureProduct = -1L;
        for(int r = 0; ranges.size() > r; r++) {
            AlmanacMapRange range = ranges.get(r);
            temperatureProduct = range.getDestination(lightProduct);
            if(temperatureProduct != -1L) {
                break;
            }
        }

        if(temperatureProduct == -1L) {
            temperatureProduct = lightProduct;
        }

        // buildTemperatureToHumidity
        ranges = almanac.getTemperatureToHumidity().getRanges();

        long humidityProduct = -1L;
        for(int r = 0; ranges.size() > r; r++) {
            AlmanacMapRange range = ranges.get(r);
            humidityProduct = range.getDestination(temperatureProduct);
            if(humidityProduct != -1L) {
                break;
            }
        }

        if(humidityProduct == -1L) {
            humidityProduct = temperatureProduct;
        }

        // buildHumidityToLocation
        ranges = almanac.getHumiditytoLocation().getRanges();

        long locationProduct = -1L;
        for(int r = 0; ranges.size() > r; r++) {
            AlmanacMapRange range = ranges.get(r);
            locationProduct = range.getDestination(humidityProduct);
            if(locationProduct != -1L) {
                break;
            }
        }

        if(locationProduct == -1L) {
            locationProduct = humidityProduct;
        }

        if (this.smallestLocation == -1L || locationProduct < this.smallestLocation) {
            this.smallestLocation = locationProduct;
            this.smallestSeed = seed;
        }

        return locationProduct;
    }
}
