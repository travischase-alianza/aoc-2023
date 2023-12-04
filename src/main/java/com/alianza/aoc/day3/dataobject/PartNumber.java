package com.alianza.aoc.day3.dataobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class PartNumber {
    @Getter @Setter int number;
    @Getter @Setter int lineNumber;
    @Getter @Setter int startingLineIndex;
    @Getter @Setter int endingLineIndex;
}
