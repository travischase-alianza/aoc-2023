package com.alianza.aoc.day3;

import java.util.HashMap;
import java.util.ArrayList;

import com.alianza.aoc.common.IAggregate;
import com.alianza.aoc.day3.dataobject.PartIndicator;
import com.alianza.aoc.day3.dataobject.PartNumber;

public class Day3Part2Aggregate implements IAggregate {

    int sum;

    Object previousLine;

    ArrayList<PartIndicator> gears;

    public Day3Part2Aggregate() {
        this.gears = new ArrayList<>();
    }

    public Object aggregate(int id, Object in) {
        System.out.println("[DEBUG Aggregate] ~~~ Current Line: " + id);

        ArrayList<PartIndicator> currPartIndicators = (ArrayList<PartIndicator>)(((HashMap<String, Object>) in).get("indicators"));
        ArrayList<PartNumber> currPartNumbers = (ArrayList<PartNumber>)(((HashMap<String, Object>) in).get("parts"));

        System.out.println("[DEBUG Aggregate] --- Checking current line  for gears (" + currPartIndicators.size() + ")");
        // Check current line numbers with current line symbols
        for(int i = 0; currPartIndicators.size() > i; i++) {
            PartIndicator indicator = currPartIndicators.get(i);

            if(indicator.isGear()) {
                System.out.println("[DEBUG Aggregate] Gear Found");

                this.gears.add(indicator);
            }
        } 

        System.out.println("[DEBUG Aggregate] --- Checking current line parts (" + currPartNumbers.size() + ") with gears (" + this.gears.size() + ")");
        // Check current line numbers with current line symbols
        for(int i = 0; this.gears.size() > i; i++) {
            PartIndicator indicator = this.gears.get(i);

            for(int n = 0; currPartNumbers.size() > n; n++) {
                PartNumber part = currPartNumbers.get(n);

                System.out.println("[DEBUG Aggregate] Part " + part.getNumber() + " (" + part.getStartingLineIndex() + ", " + part.getEndingLineIndex() + ") and Indicator at " + indicator.getLineIndex());
                if(!part.isRealPart()) {
                    int lineDiff = Math.abs(part.getLineNumber() - indicator.getLineNumber());
                    int startingIndexDiff = Math.abs(part.getStartingLineIndex() - indicator.getLineIndex());
                    int endingIndexDiff = Math.abs(indicator.getLineIndex() - part.getEndingLineIndex());

                    System.out.println("[DEBUG Aggregate] Checking Part (Curr Sym, Curr Part): Start Diff - " + startingIndexDiff + " End Diff - " + endingIndexDiff + " Part - " + part.getNumber());

                    if((lineDiff == 0 || lineDiff == 1) && (startingIndexDiff == 0 || startingIndexDiff == 1 || endingIndexDiff == 0 || endingIndexDiff == 1)) {
                        currPartNumbers.get(n).setRealPart(true);

                        this.gears.get(i).addAttachedPart(part);

                        System.out.println("[DEBUG Aggregate] Part Found and adding to Gear: " + part.getNumber());
                    }
                }
            }
        }

        if (this.previousLine == null) {
            this.previousLine = in;

            System.out.println("[DEBUG Aggregate] First Line so ignoring Previous line checking");
        } else {
            ArrayList<PartNumber> prevPartNumbers = (ArrayList<PartNumber>)(((HashMap<String, Object>) previousLine).get("parts"));

            System.out.println("[DEBUG Aggregate] --- Checking previous line parts (" + prevPartNumbers.size() + ") with gears (" + this.gears.size() + ")");
            // Check current line numbers with previous line symbols
            for(int i = 0; this.gears.size() > i; i++) {
                for(int n = 0; prevPartNumbers.size() > n; n++) {
                    PartNumber part = prevPartNumbers.get(n);
                    PartIndicator indicator = this.gears.get(i);

                    System.out.println("[DEBUG Aggregate] Part " + part.getNumber() + " (" + part.getStartingLineIndex() + ", " + part.getEndingLineIndex() + ") and Indicator at " + indicator.getLineIndex());
                    if(!part.isRealPart()) {
                        int lineDiff = Math.abs(part.getLineNumber() - indicator.getLineNumber());
                        int startingIndexDiff = Math.abs(part.getStartingLineIndex() - indicator.getLineIndex());
                        int endingIndexDiff = Math.abs(indicator.getLineIndex() - part.getEndingLineIndex());

                        System.out.println("[DEBUG Aggregate] Checking Part (Prev Sym, Curr Part): Line Diff - " + lineDiff + " Start Diff - " + startingIndexDiff + " End Diff - " + endingIndexDiff + " Part - " + part.getNumber());

                        if((lineDiff == 0 || lineDiff == 1) && (startingIndexDiff == 0 || startingIndexDiff == 1 || endingIndexDiff == 0 || endingIndexDiff == 1)) {
                            prevPartNumbers.get(n).setRealPart(true);

                            this.gears.get(i).addAttachedPart(part);

                            System.out.println("[DEBUG Aggregate] Part Found and adding to Gear: " + part.getNumber());
                        }
                    }
                }
            }

            this.previousLine = in; 
        }

        return this.sumGears();
    } 

    private int sumGears() {
        this.sum = 0;

        for(int i = 0; this.gears.size() > i; i++) {
            ArrayList<PartNumber> attachedParts = this.gears.get(i).getAttachedParts();

            // Only calculate gears with exactly two attached parts
            if(attachedParts.size() == 2) {
                int gear1 = attachedParts.get(0).getNumber();
                int gear2 = attachedParts.get(1).getNumber();

                System.out.println("[DEBUG Aggregate] Summing Gear: " + gear1 + " " + gear2);

                this.sum += (gear1 * gear2);
            }
            else {
                System.out.println("[DEBUG Aggregate] Ignoring Not Gear: " + attachedParts.toString());
            }
        }

        return this.sum;
    }
}
