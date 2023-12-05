package com.alianza.aoc.day05.dataobject;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class AlmanacMap {
    @Getter @Setter ArrayList<AlmanacMapRange> ranges;
    
    public AlmanacMap() {
        this.ranges = new ArrayList<>();
    }
}
