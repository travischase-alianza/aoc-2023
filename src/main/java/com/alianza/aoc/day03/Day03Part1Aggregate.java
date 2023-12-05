package com.alianza.aoc.day03;

import java.util.HashMap;
import java.util.ArrayList;

import com.alianza.aoc.common.IAggregate;
import com.alianza.aoc.day03.dataobject.PartIndicator;
import com.alianza.aoc.day03.dataobject.PartNumber;

public class Day03Part1Aggregate implements IAggregate {

    int sum;

    Object previousLine;

    public Object aggregate(int id, Object in) {
        System.out.println("[DEBUG Aggregate] ~~~ Current Line: " + id);

        ArrayList<PartIndicator> currPartIndicators = (ArrayList<PartIndicator>)(((HashMap<String, Object>) in).get("indicators"));
        ArrayList<PartNumber> currPartNumbers = (ArrayList<PartNumber>)(((HashMap<String, Object>) in).get("parts"));

        if (this.previousLine == null) {
            this.previousLine = in;

            System.out.println("[DEBUG Aggregate] First Line so ignoring Previous line checking");
        } else {
            ArrayList<PartNumber> prevPartNumbers = (ArrayList<PartNumber>)(((HashMap<String, Object>) previousLine).get("parts"));
            ArrayList<PartIndicator> prevPartIndicators = (ArrayList<PartIndicator>)(((HashMap<String, Object>) previousLine).get("indicators"));

            System.out.println("[DEBUG Aggregate] --- Checking previous line parts (" + prevPartNumbers.size() + ") with current line indicators (" + currPartIndicators.size() + ")");
            // Check previous line numbers with current line symbols 
            for(int i = 0; currPartIndicators.size() > i; i++) {
                for(int n = 0; prevPartNumbers.size() > n; n++) {
                    PartNumber part = prevPartNumbers.get(n);
                    PartIndicator indicator = currPartIndicators.get(i);

                    System.out.println("[DEBUG Aggregate] Part " + part.getNumber() + " (" + part.getStartingLineIndex() + ", " + part.getEndingLineIndex() + ") and Indicator at " + indicator.getLineIndex());
                    if(!part.isRealPart()) {
                        int startingIndexDiff = Math.abs(part.getStartingLineIndex() - indicator.getLineIndex());
                        int endingIndexDiff = Math.abs(indicator.getLineIndex() - part.getEndingLineIndex());

                        System.out.println("[DEBUG Aggregate] Checking Part (Curr Sym, Prev Part): Start Diff - " + startingIndexDiff + " End Diff - " + endingIndexDiff + " Part - " + part.getNumber());

                        if(startingIndexDiff == 0 || startingIndexDiff == 1 || endingIndexDiff == 0 || endingIndexDiff == 1) {
                            prevPartNumbers.get(n).setRealPart(true);
                            this.sum += part.getNumber();

                            System.out.println("[DEBUG Aggregate] Part Found (Curr Sym, Prev Part): " + part.getNumber());
                        }
                    }
                }
            }

            System.out.println("[DEBUG Aggregate] --- Checking current line parts (" + currPartNumbers.size() + ") with previous line indicators (" + prevPartIndicators.size() + ")");
            // Check current line numbers with previous line symbols
            for(int i = 0; prevPartIndicators.size() > i; i++) {
                for(int n = 0; currPartNumbers.size() > n; n++) {
                    PartNumber part = currPartNumbers.get(n);
                    PartIndicator indicator = prevPartIndicators.get(i);

                    System.out.println("[DEBUG Aggregate] Part " + part.getNumber() + " (" + part.getStartingLineIndex() + ", " + part.getEndingLineIndex() + ") and Indicator at " + indicator.getLineIndex());
                    if(!part.isRealPart()) {
                        int startingIndexDiff = Math.abs(part.getStartingLineIndex() - indicator.getLineIndex());
                        int endingIndexDiff = Math.abs(indicator.getLineIndex() - part.getEndingLineIndex());

                        System.out.println("[DEBUG Aggregate] Checking Part (Prev Sym, Curr Part): Start Diff - " + startingIndexDiff + " End Diff - " + endingIndexDiff + " Part - " + part.getNumber());

                        if(startingIndexDiff == 0 || startingIndexDiff == 1 || endingIndexDiff == 0 || endingIndexDiff == 1) {
                            currPartNumbers.get(n).setRealPart(true);
                            this.sum += part.getNumber();

                            System.out.println("[DEBUG Aggregate] Part Found (Prev Sym, Curr Part): " + part.getNumber());
                        }
                    }
                }
            }
        
            System.out.println("[DEBUG Aggregate] --- Checking current line parts (" + currPartNumbers.size() + ") with current line indicators (" + currPartIndicators.size() + ")");
            // Check current line numbers with current line symbols
            for(int i = 0; currPartIndicators.size() > i; i++) {
                for(int n = 0; currPartNumbers.size() > n; n++) {
                    PartNumber part = currPartNumbers.get(n);
                    PartIndicator indicator = currPartIndicators.get(i);

                    System.out.println("[DEBUG Aggregate] Part " + part.getNumber() + " (" + part.getStartingLineIndex() + ", " + part.getEndingLineIndex() + ") and Indicator at " + indicator.getLineIndex());
                    if(!part.isRealPart()) {
                        int startingIndexDiff = Math.abs(part.getStartingLineIndex() - indicator.getLineIndex());
                        int endingIndexDiff = Math.abs(indicator.getLineIndex() - part.getEndingLineIndex());

                        System.out.println("[DEBUG Aggregate] Checking Part (Curr Sym, Curr Part): Start Diff - " + startingIndexDiff + " End Diff - " + endingIndexDiff + " Part - " + part.getNumber());

                        if(startingIndexDiff == 0 || startingIndexDiff == 1 || endingIndexDiff == 0 || endingIndexDiff == 1) {
                            currPartNumbers.get(n).setRealPart(true);
                            this.sum += part.getNumber();

                            System.out.println("[DEBUG Aggregate] Part Found (Curr Sym, Curr Part): " + part.getNumber());
                        }
                    }
                }
            }

            this.previousLine = in; 
        }

        return this.sum;
    } 
}
