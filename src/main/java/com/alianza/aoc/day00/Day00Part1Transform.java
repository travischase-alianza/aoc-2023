package com.alianza.aoc.day00;

import com.alianza.aoc.common.ITransform;

public class Day00Part1Transform implements ITransform<Object> {
    public Object transform(int id, String in) {
         // TODO: REPLACE TEMPLATE

         System.out.println("[DEBUG Transform] New Transform: " + in);

         return in;
    }
}