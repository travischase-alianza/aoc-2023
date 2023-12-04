package com.alianza.aoc.day3;

import java.util.HashMap;
import java.util.ArrayList;

import com.alianza.aoc.common.IAggregate;
import com.alianza.aoc.day3.dataobject.PartIndicator;
import com.alianza.aoc.day3.dataobject.PartNumber;

public class Day3Part1Aggregate implements IAggregate {

    int sum;

    Object previousLine;

    public Object aggregate(int id, Object in) {
        if (this.previousLine == null) {
            this.previousLine = in;
        } else {
            ArrayList<PartNumber> prevPartNumbers = (ArrayList<PartNumber>)(((HashMap<String, Object>) previousLine).get("parts"));
            ArrayList<PartIndicator> prevPartIndicators = (ArrayList<PartIndicator>)(((HashMap<String, Object>) previousLine).get("indicators"));

            ArrayList<PartIndicator> currPartIndicators = (ArrayList<PartIndicator>)(((HashMap<String, Object>) in).get("indicators"));
            ArrayList<PartNumber> currPartNumbers = (ArrayList<PartNumber>)(((HashMap<String, Object>) in).get("parts"));

            // Check previous line numbers with current line symbols 
            for(int i = 0; currPartIndicators.size() > i; i++) {
                for(int n = 0; prevPartNumbers.size() > n; n++) {
                    PartNumber part = prevPartNumbers.get(n);
                    PartIndicator indicator = currPartIndicators.get(i);

                    if(!part.isRealPart()) {
                        int startingIndexDiff = part.getStartingLineIndex() - indicator.getLineIndex();
                        int endingIndexDiff = indicator.getLineIndex() - part.getEndingLineIndex();

                        System.out.println("[DEBUG Aggregate] Checking Part (Curr Sym, Prev Part): Start Diff - " + startingIndexDiff + " End Diff - " + endingIndexDiff + " Part - " + part.getNumber());

                        if(startingIndexDiff == 0 || startingIndexDiff == 1 || endingIndexDiff == 0 || endingIndexDiff == 1) {
                            prevPartNumbers.get(n).setRealPart(true);
                            this.sum += part.getNumber();

                            System.out.println("[DEBUG Aggregate] Part Found (Curr Sym, Prev Part): " + part.getNumber());
                        }
                    }
                }
            }
            // Check current line numbers with previous line symbols
            for(int i = 0; prevPartIndicators.size() > i; i++) {
                for(int n = 0; currPartNumbers.size() > n; n++) {
                    PartNumber part = currPartNumbers.get(n);
                    PartIndicator indicator = prevPartIndicators.get(i);

                    if(!part.isRealPart()) {
                        int startingIndexDiff = part.getStartingLineIndex() - indicator.getLineIndex();
                        int endingIndexDiff = indicator.getLineIndex() - part.getEndingLineIndex();

                        System.out.println("[DEBUG Aggregate] Checking Part (Prev Sym, Curr Part): Start Diff - " + startingIndexDiff + " End Diff - " + endingIndexDiff + " Part - " + part.getNumber());

                        if(startingIndexDiff == 0 || startingIndexDiff == 1 || endingIndexDiff == 0 || endingIndexDiff == 1) {
                            currPartNumbers.get(n).setRealPart(true);
                            this.sum += part.getNumber();

                            System.out.println("[DEBUG Aggregate] Part Found (Prev Sym, Curr Part): " + part.getNumber());
                        }
                    }
                }
            }

            // Check current line numbers with current line symbols
            for(int i = 0; currPartIndicators.size() > i; i++) {
                for(int n = 0; currPartNumbers.size() > n; n++) {
                    PartNumber part = currPartNumbers.get(n);
                    PartIndicator indicator = currPartIndicators.get(i);

                    if(!part.isRealPart()) {
                        int startingIndexDiff = part.getStartingLineIndex() - indicator.getLineIndex();
                        int endingIndexDiff = indicator.getLineIndex() - part.getEndingLineIndex();

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
