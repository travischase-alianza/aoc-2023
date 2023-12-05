package com.alianza.aoc.day01;

import com.alianza.aoc.common.IAggregate;

public class Day01Part2Aggregate implements IAggregate<Object> {
    int sum = 0;

    public String aggregate(int id, Object in) {
        int nextNumber = Integer.parseInt(in.toString());

        System.out.println("[DEBUG Aggregate] Next number: " + Integer.toString(nextNumber));

        this.sum += nextNumber;

        System.out.println("[DEBUG Aggregate] New Sum: " + Integer.toString(this.sum));

        return Integer.toString(this.sum);
    } 
}
