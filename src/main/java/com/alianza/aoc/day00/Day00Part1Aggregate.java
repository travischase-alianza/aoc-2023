package com.alianza.aoc.day00;

import com.alianza.aoc.common.IAggregate;

public class Day00Part1Aggregate implements IAggregate<Object> {
    public Object aggregate(int id, Object in) {
        // TODO: REPLACE TEMPLATE

        System.out.println("[DEBUG Aggregate] New Aggregate: " + in);

        return in;
    } 
}
