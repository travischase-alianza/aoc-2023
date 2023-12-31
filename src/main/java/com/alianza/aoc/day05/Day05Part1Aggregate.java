package com.alianza.aoc.day05;

import java.util.ArrayList;

import com.alianza.aoc.common.IAggregate;
import com.alianza.aoc.day05.dataobject.Almanac;
import com.alianza.aoc.day05.dataobject.AlmanacMapRange;
import com.alianza.aoc.day05.dataobject.SeedAtlas;
import com.alianza.aoc.day05.dataobject.SeedMap;
import com.alianza.aoc.day05.dataobject.ParsingState;
import com.alianza.aoc.day05.dataobject.ProductType;

public class Day05Part1Aggregate implements IAggregate<Object> {

    SeedAtlas seedAtlas;

    public Day05Part1Aggregate() {
        this.seedAtlas = new SeedAtlas();
    }

    public Object aggregate(int id, Object in) {
        return this.processState(((Almanac)in));
    }
    
    private SeedAtlas processState(Almanac in) {
        System.out.println("[DEBUG Aggregate] -- State " + in.getMetaParsingState() + " --");

        switch(in.getMetaParsingState()) {
            case SEEDS:
                this.buildSeeds(in);
                break;
            case SEEDTOSOIL:
                this.buildSeedToSoil(in);
                break;
            case SOILTOFERTILIZER:
                this.buildSoilToFertilizer(in);
                break;
            case FERTILIZERTOWATER:
                this.buildFertilizerToWater(in);
                break;
            case WATERTOLIGHT:
                this.buildWaterToLight(in);
                break;
            case LIGHTTOTEMPERATURE:
                this.buildLightToTemperature(in);
                break;
            case TEMPERATURETOHUMIDITY:
                this.buildTemperatureToHumidity(in);
                break;
            case HUMIDITYTOLOCATION:
                this.buildHumidityToLocation(in);
                break;
        }

        System.out.println("[DEBUG Aggregate] " + in.getMetaParsingState() + " built: " + this.seedAtlas.toString());

        return this.seedAtlas;
    }

    private void buildSeeds(Almanac in) {
        for(int i = 0; in.getSeeds().size() > i; i++) {
            long seed = in.getSeeds().get(i);

            this.seedAtlas.addSeed(seed);
            this.seedAtlas.getSeedMap(seed).setStep(ProductType.SEEDS.getValue(), seed);
        }
    }

    private void buildSeedToSoil(Almanac in) {
        for(int i = 0; in.getSeeds().size() > i; i++) {
            long seed = in.getSeeds().get(i);
            SeedMap seedMap = this.seedAtlas.getSeedMap(seed);
            long product = seedMap.getStep(ProductType.SEEDS.getValue());

            ArrayList<AlmanacMapRange> ranges = in.getSeedToSoil().getRanges();
            System.out.println("[DEBUG Aggregate] ranges " + ranges.toString());

            long destination = -1L;
            for(int r = 0; ranges.size() > r; r++) {
                AlmanacMapRange range = ranges.get(r);
                destination = range.getDestination(product);
                if(destination != -1L) {
                    this.seedAtlas.getSeedMap(seed).setStep(ProductType.SOIL.getValue(), destination);
                    break;
                }
            }

            if(destination == -1L) {
                System.out.println("[DEBUG Aggregate] Seed " + seed + ": no map found for " + product + " so using " + product);
                this.seedAtlas.getSeedMap(seed).setStep(ProductType.SOIL.getValue(), seed);
            }
        }

    }

    private void buildSoilToFertilizer(Almanac in) {
        for(int i = 0; in.getSeeds().size() > i; i++) {
            long seed = in.getSeeds().get(i);
            SeedMap seedMap = this.seedAtlas.getSeedMap(seed);
            long product = seedMap.getStep(ProductType.SOIL.getValue());

            ArrayList<AlmanacMapRange> ranges = in.getSoilToFertilizer().getRanges();
            System.out.println("[DEBUG Aggregate] ranges " + ranges.toString());

            long destination = -1L;
            for(int r = 0; ranges.size() > r; r++) {
                AlmanacMapRange range = ranges.get(r);
                destination = range.getDestination(product);
                if(destination != -1L) {
                    this.seedAtlas.getSeedMap(seed).setStep(ProductType.FERTILIZER.getValue(), destination);
                    break;
                }
            }

            if(destination == -1L) {
                System.out.println("[DEBUG Aggregate] Seed " + seed + ": no map found for " + product + " so using " + product);
                this.seedAtlas.getSeedMap(seed).setStep(ProductType.FERTILIZER.getValue(), product);
            }
        }
    }

    private void buildFertilizerToWater(Almanac in) {
        for(int i = 0; in.getSeeds().size() > i; i++) {
            long seed = in.getSeeds().get(i);
            SeedMap seedMap = this.seedAtlas.getSeedMap(seed);
            long product = seedMap.getStep(ProductType.FERTILIZER.getValue());

            ArrayList<AlmanacMapRange> ranges = in.getFertilizerToWater().getRanges();
            System.out.println("[DEBUG Aggregate] ranges " + ranges.toString());

            long destination = -1L;
            for(int r = 0; ranges.size() > r; r++) {
                AlmanacMapRange range = ranges.get(r);
                destination = range.getDestination(product);
                if(destination != -1L) {
                    this.seedAtlas.getSeedMap(seed).setStep(ProductType.WATER.getValue(), destination);
                    break;
                }
            }

            if(destination == -1L) {
                System.out.println("[DEBUG Aggregate] Seed " + seed + ": no map found for " + product + " so using " + product);
                this.seedAtlas.getSeedMap(seed).setStep(ProductType.WATER.getValue(), product);
            }
        }
    }

    private void buildWaterToLight(Almanac in) {
        for(int i = 0; in.getSeeds().size() > i; i++) {
            long seed = in.getSeeds().get(i);
            SeedMap seedMap = this.seedAtlas.getSeedMap(seed);
            long product = seedMap.getStep(ProductType.WATER.getValue());

            ArrayList<AlmanacMapRange> ranges = in.getWaterToLight().getRanges();
            System.out.println("[DEBUG Aggregate] ranges " + ranges.toString());

            long destination = -1L;
            for(int r = 0; ranges.size() > r; r++) {
                AlmanacMapRange range = ranges.get(r);
                destination = range.getDestination(product);
                if(destination != -1L) {
                    this.seedAtlas.getSeedMap(seed).setStep(ProductType.LIGHT.getValue(), destination);
                    break;
                }
            }

            if(destination == -1L) {
                System.out.println("[DEBUG Aggregate] Seed " + seed + ": no map found for " + product + " so using " + product);
                this.seedAtlas.getSeedMap(seed).setStep(ProductType.LIGHT.getValue(), product);
            }
        }
    }

    private void buildLightToTemperature(Almanac in) {
        for(int i = 0; in.getSeeds().size() > i; i++) {
            long seed = in.getSeeds().get(i);
            SeedMap seedMap = this.seedAtlas.getSeedMap(seed);
            long product = seedMap.getStep(ProductType.LIGHT.getValue());

            ArrayList<AlmanacMapRange> ranges = in.getLightToTemperature().getRanges();
            System.out.println("[DEBUG Aggregate] ranges " + ranges.toString());

            long destination = -1L;
            for(int r = 0; ranges.size() > r; r++) {
                AlmanacMapRange range = ranges.get(r);
                destination = range.getDestination(product);
                if(destination != -1L) {
                    this.seedAtlas.getSeedMap(seed).setStep(ProductType.TEMPERATURE.getValue(), destination);
                    break;
                }
            }

            if(destination == -1L) {
                System.out.println("[DEBUG Aggregate] Seed " + seed + ": no map found for " + product + " so using " + product);
                this.seedAtlas.getSeedMap(seed).setStep(ProductType.TEMPERATURE.getValue(), product);
            }
        }
    }

    private void buildTemperatureToHumidity(Almanac in) {
        for(int i = 0; in.getSeeds().size() > i; i++) {
            long seed = in.getSeeds().get(i);
            SeedMap seedMap = this.seedAtlas.getSeedMap(seed);
            long product = seedMap.getStep(ProductType.TEMPERATURE.getValue());

            ArrayList<AlmanacMapRange> ranges = in.getTemperatureToHumidity().getRanges();
            System.out.println("[DEBUG Aggregate] ranges " + ranges.toString());

            long destination = -1L;
            for(int r = 0; ranges.size() > r; r++) {
                AlmanacMapRange range = ranges.get(r);
                destination = range.getDestination(product);
                if(destination != -1L) {
                    this.seedAtlas.getSeedMap(seed).setStep(ProductType.HUMIDITY.getValue(), destination);
                    break;
                }
            }

            if(destination == -1L) {
                System.out.println("[DEBUG Aggregate] Seed " + seed + ": no map found for " + product + " so using " + product);
                this.seedAtlas.getSeedMap(seed).setStep(ProductType.HUMIDITY.getValue(), product);
            }
        }
    }

    private void buildHumidityToLocation(Almanac in) {
        for(int i = 0; in.getSeeds().size() > i; i++) {
            long seed = in.getSeeds().get(i);
            SeedMap seedMap = this.seedAtlas.getSeedMap(seed);
            long product = seedMap.getStep(ProductType.HUMIDITY.getValue());

            ArrayList<AlmanacMapRange> ranges = in.getHumiditytoLocation().getRanges();
            System.out.println("[DEBUG Aggregate] ranges " + ranges.toString());


            long destination = -1L;
            for(int r = 0; ranges.size() > r; r++) {
                AlmanacMapRange range = ranges.get(r);
                destination = range.getDestination(product);
                if(destination != -1L) {
                    this.seedAtlas.getSeedMap(seed).setStep(ProductType.LOCATION.getValue(), destination);
                    break;
                }
            }

            if(destination == -1L) {
                System.out.println("[DEBUG Aggregate] Seed " + seed + ": no map found for " + product + " so using " + product);
                this.seedAtlas.getSeedMap(seed).setStep(ProductType.LOCATION.getValue(), product);
            }
        }
    }
}
