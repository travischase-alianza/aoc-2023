package com.alianza.aoc.day3.dataobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class PartNumber {
    @Getter int number;
    @Getter int lineNumber;
    @Getter int startingLineIndex;
    @Getter int endingLineIndex;

    @Getter @Setter boolean isRealPart;
}
