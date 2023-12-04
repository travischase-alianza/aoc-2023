package com.alianza.aoc.day3;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alianza.aoc.common.ITransformMap;
import com.alianza.aoc.day3.dataobject.PartIndicator;
import com.alianza.aoc.day3.dataobject.PartNumber;

public class Day3Part2Transform implements ITransformMap {
    public Map<String, Object> transform(int lineNumber, String in) {
        ArrayList<PartNumber> parts = this.parseLineForParts(lineNumber, in);
        ArrayList<PartIndicator> indicators = this.parseLineForIndicators(lineNumber, in);

        HashMap<String, Object> parsedLine = new HashMap<>();
        parsedLine.put("parts", parts);
        parsedLine.put("indicators", indicators);

        System.out.println("[DEBUG Transform] Line: " + lineNumber);

        for(int p = 0; parts.size() > p; p++) {
            System.out.println("[DEBUG Transform] Part: " + parts.get(p).getNumber());
        }

        for(int i = 0; indicators.size() > i; i++) {
            System.out.println("[DEBUG Transform] Indicator: " + indicators.get(i).getSymbol());
        }

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

    private ArrayList<PartNumber> parseLineForParts(int lineNumber, String line) {
        ArrayList<PartNumber> parts = new ArrayList<>();

        // Split the line into chars
        char[] chars = line.toCharArray();

        boolean capturingNumber = false;
        String capturedNumber = "";
        int startingIndex = -1;
        int endingIndex = -1;

        for(int i = 0; chars.length > i; i++) {
            String theChar = "" + chars[i];
            Pattern patternPartNumber = this.getRegexPartNumber();
            Matcher matcherPartNumber = patternPartNumber.matcher(theChar);

            if(capturingNumber == true) {
                if(matcherPartNumber.matches()) {
                    capturedNumber += theChar;
                    endingIndex = i;
                } else {
                    PartNumber part = new PartNumber(Integer.parseInt(capturedNumber), lineNumber, startingIndex, endingIndex, false);

                    parts.add(part);

                    capturingNumber = false;
                    capturedNumber = "";
                    startingIndex = -1;
                    endingIndex = -1;
                }
            } else if(matcherPartNumber.matches()) {
                capturingNumber = true;
                capturedNumber = theChar;
                startingIndex = i;
            }
        }

        // add last number if there was one we were capturing at the end of the line
        if(capturingNumber == true) {
            PartNumber part = new PartNumber(Integer.parseInt(capturedNumber), lineNumber, startingIndex, endingIndex, false);

            parts.add(part);

            capturingNumber = false;
            capturedNumber = "";
            startingIndex = -1;
            endingIndex = -1;
        }

        return parts;
    }

    private Pattern getRegexIndicator() {
        return Pattern.compile("[^\\d\\.]");
    }

    private Pattern getRegexPartNumber() {
        return Pattern.compile("\\d");
    }
}