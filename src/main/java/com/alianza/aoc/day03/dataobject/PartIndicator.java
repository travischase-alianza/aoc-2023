package com.alianza.aoc.day03.dataobject;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PartIndicator {
    @Getter int lineIndex;
    @Getter int lineNumber;
    @Getter String symbol;

    ArrayList<PartNumber> attachedParts;

    public PartIndicator(int lineIndex, int lineNumber, String symbol) {
        this.lineIndex = lineIndex;
        this.lineNumber = lineNumber;
        this.symbol = symbol;

        attachedParts = new ArrayList<>();
    }

    public boolean isGear() {
        return this.symbol.matches("\\*");
    }

    public void addAttachedPart(PartNumber part) {
        this.attachedParts.add(part);
    }

    public ArrayList<PartNumber> getAttachedParts() {
        return this.attachedParts;
    }
}
