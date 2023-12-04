package com.alianza.aoc.day3.dataobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class PartIndicator {
    @Getter @Setter int lineIndex;
    @Getter @Setter int lineNumber;
    @Getter @Setter String symbol;
}
