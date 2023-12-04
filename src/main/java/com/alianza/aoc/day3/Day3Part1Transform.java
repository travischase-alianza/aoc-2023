package com.alianza.aoc.day3;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.alianza.aoc.common.ITransformMap;
import com.alianza.aoc.day3.dataobject.PartIndicator;
import com.alianza.aoc.day3.dataobject.PartNumber;

public class Day3Part1Transform implements ITransformMap {
    public Map<String, Object> transform(int id, String in) {
        ArrayList<PartNumber> parts = this.parseLineForParts(in);
        ArrayList<PartIndicator> indicators = this.parseLineForIndicators(in);

        System.out.println("[DEBUG Transform] New Transform: " + in);

        HashMap<String, Object> parsedLine = new HashMap<>();
        parsedLine.put("parts", parts);
        parsedLine.put("indicators", indicators);

        return parsedLine;
    }

    private ArrayList<PartIndicator> parseLineForIndicators(String line) {
        ArrayList<PartIndicator> indicators = new ArrayList<>();

        // Split the line into chars
        char[] chars = line.toCharArray();

        return indicators;
    }

    private ArrayList<PartNumber> parseLineForParts(String line) {
        ArrayList<PartNumber> parts = new ArrayList<>();

        return parts;
    }
}