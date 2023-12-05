package com.alianza.aoc.day05;

import com.alianza.aoc.common.ITransform;
import com.alianza.aoc.day05.dataobject.Almanac;
import com.alianza.aoc.day05.dataobject.AlmanacMapRange;

public class Day05Part1Transform implements ITransform<Object> {
    enum ParsingState {
        SEEDS,
        SEEDTOSOIL,
        SOILTOFERTILIZER,
        FERTILIZERTOWATER,
        WATERTOLIGHT,
        LIGHTTOTEMPERATURE,
        TEMPERATURETOHUMIDITY,
        HUMIDITYTOLOCATION
    };

    ParsingState parsingState;
    Almanac almanac;

    public Day05Part1Transform() {
        parsingState = ParsingState.SEEDS;
        this.almanac = new Almanac();
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
            for(int i = 0; seeds.length > i; i++) {
                this.almanac.getSeeds().add(Long.parseLong(seeds[i]));
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

            AlmanacMapRange mapRange = new AlmanacMapRange();
            mapRange.setDestStart(Long.parseLong(parts[0]));
            mapRange.setSourceStart(Long.parseLong(parts[1]));
            mapRange.setRangeLength(Long.parseLong(parts[2]));

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

            AlmanacMapRange mapRange = new AlmanacMapRange();
            mapRange.setDestStart(Long.parseLong(parts[0]));
            mapRange.setSourceStart(Long.parseLong(parts[1]));
            mapRange.setRangeLength(Long.parseLong(parts[2]));

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

            AlmanacMapRange mapRange = new AlmanacMapRange();
            mapRange.setDestStart(Long.parseLong(parts[0]));
            mapRange.setSourceStart(Long.parseLong(parts[1]));
            mapRange.setRangeLength(Long.parseLong(parts[2]));

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

            AlmanacMapRange mapRange = new AlmanacMapRange();
            mapRange.setDestStart(Long.parseLong(parts[0]));
            mapRange.setSourceStart(Long.parseLong(parts[1]));
            mapRange.setRangeLength(Long.parseLong(parts[2]));

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

            AlmanacMapRange mapRange = new AlmanacMapRange();
            mapRange.setDestStart(Long.parseLong(parts[0]));
            mapRange.setSourceStart(Long.parseLong(parts[1]));
            mapRange.setRangeLength(Long.parseLong(parts[2]));

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

            AlmanacMapRange mapRange = new AlmanacMapRange();
            mapRange.setDestStart(Long.parseLong(parts[0]));
            mapRange.setSourceStart(Long.parseLong(parts[1]));
            mapRange.setRangeLength(Long.parseLong(parts[2]));

            this.almanac.getTemperatureToHumidity().getRanges().add(mapRange);

            System.out.println("[DEBUG Transform] Map " + this.almanac.getTemperatureToHumidity().getRanges().toString());
        }
    }

    private void parseHumidityToLocation(String in) {
        if(in.matches("^\\d+\\s+\\d+\\s+\\d+")) {
            String[] parts = in.split("\\s+");

            AlmanacMapRange mapRange = new AlmanacMapRange();
            mapRange.setDestStart(Long.parseLong(parts[0]));
            mapRange.setSourceStart(Long.parseLong(parts[1]));
            mapRange.setRangeLength(Long.parseLong(parts[2]));

            this.almanac.getHumiditytoLocation().getRanges().add(mapRange);

            System.out.println("[DEBUG Transform] Map " + this.almanac.getHumiditytoLocation().getRanges().toString());
        }
    }
}