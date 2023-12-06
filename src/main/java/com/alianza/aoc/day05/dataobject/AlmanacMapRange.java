package com.alianza.aoc.day05.dataobject;

import lombok.Getter;
import lombok.Setter;

public class AlmanacMapRange {
    @Getter long srcStart;
    @Getter long srcEnd;
    @Getter long destStart;
    @Getter long destEnd;
    @Getter long rangeLen;

    public AlmanacMapRange(long destStart, long srcStart, long rangeLen) {
        this.srcStart = srcStart;
        this.destStart = destStart;
        this.rangeLen = rangeLen;
        this.srcEnd = srcStart + rangeLen - 1;
        this.destEnd = destStart + rangeLen - 1;
    }

    public boolean isWithininSourceRange(long num){
        return num >= this.srcStart && num <= this.srcEnd;
    }

    public long getDestination(long srcNum) {
        if(!this.isWithininSourceRange(srcNum)) {
            return -1L;
        }

        long distance = srcNum - this.srcStart;

        //System.out.println("[DEBUG AlmanacMapRange] getDestination: srcNum " + srcNum + " srcStart " + this.srcStart + " distance " + distance + " destination " + (this.destStart + distance));

        return this.destStart + distance;
    }

    public boolean isWithininDestinationRange(long num){
        return num >= this.destStart && num <= this.destEnd;
    }

    @Override
    public String toString() { 
        String result = this.destStart + " " + this.srcStart + " " + this.rangeLen;
        return result;
    } 
}
