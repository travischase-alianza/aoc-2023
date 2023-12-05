package com.alianza.aoc.day05;

import com.alianza.aoc.common.ITransform;

public class Day05Part1Transform implements ITransform<Object> {
    public Object transform(int id, String in) {
         // TODO: REPLACE TEMPLATE

         System.out.println("[DEBUG Transform] New Transform: " + in);

         return in;
    }
}