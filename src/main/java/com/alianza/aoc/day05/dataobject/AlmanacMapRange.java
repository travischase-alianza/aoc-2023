package com.alianza.aoc.day05.dataobject;

import lombok.Getter;
import lombok.Setter;

public class AlmanacMapRange {
    @Getter @Setter long sourceStart;
    @Getter @Setter long destStart;
    @Getter @Setter long rangeLength;

    public AlmanacMapRange() {
        this.sourceStart = -1;
        this.destStart = -1;
        this.rangeLength = 0;
    }

    @Override
    public String toString() { 
        String result = this.destStart + " " + this.sourceStart + " " + this.rangeLength;
        return result;
    } 
}
