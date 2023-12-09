package com.alianza.aoc.day06;

import java.util.HashMap;

import com.alianza.aoc.common.IAggregate;
import com.alianza.aoc.day06.dataobject.RaceStatList;

public class Day06Part2Aggregate implements IAggregate<Long> {
    public Long aggregate(int id, Object in) {
        HashMap<Integer, RaceStatList> possibleWins = ((HashMap<Integer, RaceStatList>) in);
        long result = 1;

        System.out.println("[DEBUG Aggregate] Races " + possibleWins.size());
        
        for(int i = 0; possibleWins.size() > i; i++) {
            System.out.println("[DEBUG Aggregate] Race " + i + " Possible Wins List " + possibleWins.get(i).getRaceStats());

            long numberPossibleWins = possibleWins.get(i).getRaceStats().size();

            System.out.println("[DEBUG Aggregate] Race " + i + " Possible Wins " + numberPossibleWins);

            result *= numberPossibleWins;
        }

        return result;
    } 
}
