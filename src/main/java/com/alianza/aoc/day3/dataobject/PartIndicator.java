package com.alianza.aoc.day3.dataobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PartIndicator {
    @Getter int lineIndex;
    @Getter int lineNumber;
    @Getter String symbol;
}
