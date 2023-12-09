package com.alianza.aoc.day06.dataobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class RaceStat {
    @Getter @Setter int time;
    @Getter @Setter int distance;

    @Override
    public String toString() {
        String result = "(time:" + time + ", distance:" + distance + ")";
        return result;
    }
}
