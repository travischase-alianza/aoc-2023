package com.alianza.aoc.app;

import java.time.Instant;
import java.time.Duration;

import com.alianza.aoc.controller.FileProcessor;

// Day 5 Part 2
import com.alianza.aoc.day05.Day05Part2Aggregate;
import com.alianza.aoc.day05.Day05Part2Transform;
import com.alianza.aoc.day05.Day05Part2Report;

public class App {
    public static void main( String[] args ) {
        Instant start = Instant.now();
        // Day 5
        String filePath = "./inputs/day05.txt";

        System.out.println( "--- Advent of Code! ---" );

        // Day 5 Part 1
        Day05Part2Transform transformer = new Day05Part2Transform();
        Day05Part2Aggregate aggregator = new Day05Part2Aggregate();
        Day05Part2Report reporter = new Day05Part2Report();

        FileProcessor stringFileProcessor = new FileProcessor(filePath, transformer, aggregator, reporter);
        stringFileProcessor.run();

        Instant end = Instant.now();
        System.out.println("** TIME ELAPSED: " + Duration.between(start, end) + " **"); // prints PT1M3.553S
    }
}
