package com.alianza.aoc.day05.dataobject;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class AlmanacSeedRange extends Almanac {
    @Getter @Setter AlmanacMap seedRanges;

    public AlmanacSeedRange() {
        this.seeds = new ArrayList<>();
        this.seedRanges = new AlmanacMap();
        this.seedToSoil = new AlmanacMap();
        this.soilToFertilizer = new AlmanacMap();
        this.fertilizerToWater = new AlmanacMap();
        this.waterToLight = new AlmanacMap();
        this.lightToTemperature = new AlmanacMap();
        this.temperatureToHumidity = new AlmanacMap();
        this.humiditytoLocation = new AlmanacMap();
    }
}
