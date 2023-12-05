package com.alianza.aoc.day05;

import com.alianza.aoc.common.IReport;
import com.alianza.aoc.day05.dataobject.Almanac;

public class Day05Part1Report implements IReport {
    public void report(int lineCount, Object transformResult, Object aggregateResult) {
        System.out.println("[DEBUG Report] New Report");

        Almanac almanac = ((Almanac)transformResult);

        for(int i = 0; almanac.getSeeds().size() > i; i++) {
            // TODO: process seeds
        }
    } 
}
