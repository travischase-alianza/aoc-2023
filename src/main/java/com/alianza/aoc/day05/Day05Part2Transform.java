package com.alianza.aoc.day05;

import com.alianza.aoc.common.ITransform;
import com.alianza.aoc.day05.dataobject.AlmanacSeedRange;
import com.alianza.aoc.day05.dataobject.AlmanacMapRange;
import com.alianza.aoc.day05.dataobject.ParsingState;

import lombok.Getter;

public class Day05Part2Transform implements ITransform<Object> {
    @Getter ParsingState parsingState;
    @Getter AlmanacSeedRange almanac;

    public Day05Part2Transform() {
        parsingState = ParsingState.SEEDS;
        this.almanac = new AlmanacSeedRange();
    }

    public Object transform(int id, String in) {
        return this.processState(in);
    }

    private Object processState(String in) {
        System.out.println("[DEBUG Transform] -- State " + this.parsingState + " --");

        switch(this.parsingState) {
            case SEEDS:
                this.parseSeeds(in);
                break;
            case SEEDTOSOIL:
                this.parseSeedToSoil(in);
                break;
            case SOILTOFERTILIZER:
                this.parseSoilToFertilizer(in);
                break;
            case FERTILIZERTOWATER:
                this.parseFertilizerToWater(in);
                break;
            case WATERTOLIGHT:
                this.parseWaterToLight(in);
                break;
            case LIGHTTOTEMPERATURE:
                this.parseLightToTemperature(in);
                break;
            case TEMPERATURETOHUMIDITY:
                this.parseTemperatureToHumidity(in);
                break;
            case HUMIDITYTOLOCATION:
                this.parseHumidityToLocation(in);
                break;
        }

        this.almanac.setMetaParsingState(this.parsingState);

        return this.almanac;
    }

    private void parseSeeds(String in) {
        if(in.matches("^seed-to-soil map:")) {
            this.parsingState = ParsingState.SEEDTOSOIL;
            return;
        }

        if(in.matches("^seeds:.*")) {
            String[] parts = in.split("\\:\\s+");
            String[] seeds = parts[1].split("\\s+");

            long Seed1Start = Long.parseLong(seeds[0]);
            long Seed1Length = Long.parseLong(seeds[1]);
            long Seed2Start = Long.parseLong(seeds[2]);
            long Seed2Length = Long.parseLong(seeds[3]);

            for(int i = 0; seeds.length > i; i+=2) {
                long seedStart = Long.parseLong(seeds[i]);
                long seedLength = Long.parseLong(seeds[i + 1]);

                AlmanacMapRange mapRange = new AlmanacMapRange(seedStart, seedStart, seedLength);

                this.almanac.getSeedRanges().getRanges().add(mapRange);
            }

            System.out.println("[DEBUG Transform] Seeds " + this.almanac.getSeeds().toString());
        }
    }

    private void parseSeedToSoil(String in) {
        if(in.matches("^soil-to-fertilizer map:")) {
            this.parsingState = ParsingState.SOILTOFERTILIZER;
            return;
        }

        if(in.matches("^\\d+\\s+\\d+\\s+\\d+")) {
            String[] parts = in.split("\\s+");

            AlmanacMapRange mapRange = new AlmanacMapRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]), Long.parseLong(parts[2]));

            this.almanac.getSeedToSoil().getRanges().add(mapRange);

            System.out.println("[DEBUG Transform] Map " + this.almanac.getSeedToSoil().getRanges().toString());
        }
    }

    private void parseSoilToFertilizer(String in) {
        if(in.matches("^fertilizer-to-water map:")) {
            this.parsingState = ParsingState.FERTILIZERTOWATER;
            return;
        }

        if(in.matches("^\\d+\\s+\\d+\\s+\\d+")) {
            String[] parts = in.split("\\s+");

            AlmanacMapRange mapRange = new AlmanacMapRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]), Long.parseLong(parts[2]));

            this.almanac.getSoilToFertilizer().getRanges().add(mapRange);

            System.out.println("[DEBUG Transform] Map " + this.almanac.getSoilToFertilizer().getRanges().toString());
        }
    }

    private void parseFertilizerToWater(String in) {
        if(in.matches("^water-to-light map:")) {
            this.parsingState = ParsingState.WATERTOLIGHT;
            return;
        }

        if(in.matches("^\\d+\\s+\\d+\\s+\\d+")) {
            String[] parts = in.split("\\s+");

            AlmanacMapRange mapRange = new AlmanacMapRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]), Long.parseLong(parts[2]));

            this.almanac.getFertilizerToWater().getRanges().add(mapRange);

            System.out.println("[DEBUG Transform] Map " + this.almanac.getFertilizerToWater().getRanges().toString());
        }
    }

    private void parseWaterToLight(String in) {
        if(in.matches("^light-to-temperature map:")) {
            this.parsingState = ParsingState.LIGHTTOTEMPERATURE;
            return;
        }

        if(in.matches("^\\d+\\s+\\d+\\s+\\d+")) {
            String[] parts = in.split("\\s+");

            AlmanacMapRange mapRange = new AlmanacMapRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]), Long.parseLong(parts[2]));

            this.almanac.getWaterToLight().getRanges().add(mapRange);

            System.out.println("[DEBUG Transform] Map " + this.almanac.getWaterToLight().getRanges().toString());
        }
    }

    private void parseLightToTemperature(String in) {
        if(in.matches("^temperature-to-humidity map:")) {
            this.parsingState = ParsingState.TEMPERATURETOHUMIDITY;
            return;
        }

        if(in.matches("^\\d+\\s+\\d+\\s+\\d+")) {
            String[] parts = in.split("\\s+");

            AlmanacMapRange mapRange = new AlmanacMapRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]), Long.parseLong(parts[2]));

            this.almanac.getLightToTemperature().getRanges().add(mapRange);

            System.out.println("[DEBUG Transform] Map " + this.almanac.getLightToTemperature().getRanges().toString());
        }
    }

    private void parseTemperatureToHumidity(String in) {
        if(in.matches("^humidity-to-location map:")) {
            this.parsingState = ParsingState.HUMIDITYTOLOCATION;
            return;
        }

        if(in.matches("^\\d+\\s+\\d+\\s+\\d+")) {
            String[] parts = in.split("\\s+");

            AlmanacMapRange mapRange = new AlmanacMapRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]), Long.parseLong(parts[2]));

            this.almanac.getTemperatureToHumidity().getRanges().add(mapRange);

            System.out.println("[DEBUG Transform] Map " + this.almanac.getTemperatureToHumidity().getRanges().toString());
        }
    }

    private void parseHumidityToLocation(String in) {
        if(in.matches("^\\d+\\s+\\d+\\s+\\d+")) {
            String[] parts = in.split("\\s+");

            AlmanacMapRange mapRange = new AlmanacMapRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]), Long.parseLong(parts[2]));

            this.almanac.getHumiditytoLocation().getRanges().add(mapRange);

            System.out.println("[DEBUG Transform] Map " + this.almanac.getHumiditytoLocation().getRanges().toString());
        }
    }
}