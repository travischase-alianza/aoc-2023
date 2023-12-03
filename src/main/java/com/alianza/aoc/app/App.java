package com.alianza.aoc.app;

import com.alianza.aoc.controller.FileProcessor;

// Day 1 Part 1
// import com.alianza.aoc.day1.Day1Part1Aggregate;
// import com.alianza.aoc.day1.Day1Part1Transform;

// Day 1 Part 2
import com.alianza.aoc.day1.Day1Part2Aggregate;
import com.alianza.aoc.day1.Day1Part2Transform;

public class App 
{
    public static void main( String[] args )
    {
        String day1FilePath = "./inputs/day1.txt";

        System.out.println( "--- Advent of Code! ---" );

        // Day 1 Part 1
        // Day1Part1Transform transformer = new Day1Part1Transform();
        // Day1Part1Aggregate aggregator = new Day1Part1Aggregate();

        // Day 1 Part 2
        Day1Part2Transform transformer = new Day1Part2Transform();
        Day1Part2Aggregate aggregator = new Day1Part2Aggregate();

        FileProcessor stringFileProcessor = new FileProcessor(day1FilePath, transformer, aggregator);
        stringFileProcessor.run();
    }
}
