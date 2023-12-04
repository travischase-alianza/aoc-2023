package com.alianza.aoc.day4;

import com.alianza.aoc.common.IAggregate;

public class Day4Part2Aggregate implements IAggregate {
    int sum = 0;

    public Object aggregate(int id, Object in) {
        int nextNumber = Integer.parseInt(in.toString());

        System.out.println("[DEBUG Aggregate] Next number: " + Integer.toString(nextNumber));

        this.sum += nextNumber;

        System.out.println("[DEBUG Aggregate] New Sum: " + Integer.toString(this.sum));

        return Integer.toString(this.sum);
    } 
}
