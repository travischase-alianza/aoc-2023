package com.alianza.aoc.app;

import com.alianza.aoc.controller.FileProcessor;

// Day 1 Part 1
// import com.alianza.aoc.day1.Day1Part1Aggregate;
// import com.alianza.aoc.day1.Day1Part1Transform;

// Day 1 Part 2
// import com.alianza.aoc.day1.Day1Part2Aggregate;
// import com.alianza.aoc.day1.Day1Part2Transform;

// Day 2 Part 1
// import com.alianza.aoc.day2.Day2Part1Aggregate;
// import com.alianza.aoc.day2.Day2Part1Transform;

// Day 2 Part 2
import com.alianza.aoc.day2.Day2Part2Aggregate;
import com.alianza.aoc.day2.Day2Part2Transform;

public class App 
{
    public static void main( String[] args )
    {
        // Day 1
        // String filePath = "./inputs/day1.txt";

        // Day 2
        String filePath = "./inputs/day2.txt";

        System.out.println( "--- Advent of Code! ---" );

        // Day 1 Part 1
        // Day1Part1Transform transformer = new Day1Part1Transform();
        // Day1Part1Aggregate aggregator = new Day1Part1Aggregate();

        // Day 1 Part 2
        // Day1Part2Transform transformer = new Day1Part2Transform();
        // Day1Part2Aggregate aggregator = new Day1Part2Aggregate();

        // Day 2 Part 1
        // Day2Part1Transform transformer = new Day2Part1Transform();
        // Day2Part1Aggregate aggregator = new Day2Part1Aggregate();

        // Day 2 Part 2
        Day2Part2Transform transformer = new Day2Part2Transform();
        Day2Part2Aggregate aggregator = new Day2Part2Aggregate();

        FileProcessor stringFileProcessor = new FileProcessor(filePath, transformer, aggregator);
        stringFileProcessor.run();
    }
}
