package com.alianza.aoc.day3;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alianza.aoc.common.ITransformMap;
import com.alianza.aoc.day3.dataobject.PartIndicator;
import com.alianza.aoc.day3.dataobject.PartNumber;

public class Day3Part1Transform implements ITransformMap {
    public Map<String, Object> transform(int lineNumber, String in) {
        ArrayList<PartNumber> parts = this.parseLineForParts(lineNumber, in);
        ArrayList<PartIndicator> indicators = this.parseLineForIndicators(lineNumber, in);

        System.out.println("[DEBUG Transform] New Transform: " + in);

        HashMap<String, Object> parsedLine = new HashMap<>();
        parsedLine.put("parts", parts);
        parsedLine.put("indicators", indicators);

        return parsedLine;
    }

    private ArrayList<PartIndicator> parseLineForIndicators(int lineNumber, String line) {
        ArrayList<PartIndicator> indicators = new ArrayList<>();

        // Split the line into chars
        char[] chars = line.toCharArray();

        for(int i = 0; chars.length > i; i++) {
            String theChar = "" + chars[i];
            Pattern patternIndicator = this.getRegexIndicator();
            Matcher matcherIndicator = patternIndicator.matcher(theChar);

            if(matcherIndicator.matches()) {
                PartIndicator indicator = new PartIndicator(i, lineNumber, theChar);

                indicators.add(indicator);
            }
        }

        return indicators;
    }

    private Pattern getRegexIndicator() {
        return Pattern.compile("[^\\d\\.]");
    }

    private ArrayList<PartNumber> parseLineForParts(int lineNumber, String line) {
        ArrayList<PartNumber> parts = new ArrayList<>();

        return parts;
    }
}