package com.alianza.aoc.app;

import com.alianza.aoc.controller.FileProcessor;

// Day 5 Part 1
import com.alianza.aoc.day05.Day05Part1Aggregate;
import com.alianza.aoc.day05.Day05Part1Transform;
import com.alianza.aoc.day05.Day05Part1Report;

public class App 
{
    public static void main( String[] args )
    {
        // Day 5
        String filePath = "./inputs/day05.txt";

        System.out.println( "--- Advent of Code! ---" );

        // Day 5 Part 1
        Day05Part1Transform transformer = new Day05Part1Transform();
        Day05Part1Aggregate aggregator = new Day05Part1Aggregate();
        Day05Part1Report reporter = new Day05Part1Report();

        FileProcessor stringFileProcessor = new FileProcessor(filePath, transformer, aggregator, reporter);
        stringFileProcessor.run();
    }
}
