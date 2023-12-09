package com.alianza.aoc.day06.dataobject;

import java.util.ArrayList;

import lombok.Getter;

public class RaceStatList {
    @Getter ArrayList<RaceStat> raceStats;
   
    public RaceStatList() {
        raceStats = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = this.raceStats.toString();
        return result;
    }
}
