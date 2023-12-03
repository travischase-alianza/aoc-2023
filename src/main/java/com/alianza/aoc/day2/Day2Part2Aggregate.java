package com.alianza.aoc.day2;

import com.alianza.aoc.common.IAggregate;

public class Day2Part2Aggregate implements IAggregate {
    int sum = 0;

    public String aggregate(String in) {
        int nextNumber = Integer.parseInt(in);

        System.out.println("[DEBUG Aggregate] Next number: " + Integer.toString(nextNumber));

        this.sum += nextNumber;

        System.out.println("[DEBUG Aggregate] New Sum: " + Integer.toString(this.sum));

        return Integer.toString(this.sum);
    } 
}
