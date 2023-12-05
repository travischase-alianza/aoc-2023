package com.alianza.aoc.day05.dataobject;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class Almanac {
    @Getter @Setter ArrayList<Long> seeds;
    @Getter @Setter AlmanacMap seedToSoil;
    @Getter @Setter AlmanacMap soilToFertilizer;
    @Getter @Setter AlmanacMap fertilizerToWater;
    @Getter @Setter AlmanacMap waterToLight;
    @Getter @Setter AlmanacMap lightToTemperature;
    @Getter @Setter AlmanacMap temperatureToHumidity;
    @Getter @Setter AlmanacMap humiditytoLocation;

    public Almanac() {
        this.seeds = new ArrayList<>();
        this.seedToSoil = new AlmanacMap();
        this.soilToFertilizer = new AlmanacMap();
        this.fertilizerToWater = new AlmanacMap();
        this.waterToLight = new AlmanacMap();
        this.lightToTemperature = new AlmanacMap();
        this.temperatureToHumidity = new AlmanacMap();
        this.humiditytoLocation = new AlmanacMap();
    }
}
