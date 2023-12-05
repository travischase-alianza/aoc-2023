package com.alianza.aoc.app;

import com.alianza.aoc.controller.FileProcessor;

// Day 4 Part 2
import com.alianza.aoc.day04.Day04Part2Aggregate;
import com.alianza.aoc.day04.Day04Part2Transform;

public class App 
{
    public static void main( String[] args )
    {
        // Day 4
        String filePath = "./inputs/day04.txt";

        System.out.println( "--- Advent of Code! ---" );

        // Day 4 Part 2
        Day04Part2Transform transformer = new Day04Part2Transform();
        Day04Part2Aggregate aggregator = new Day04Part2Aggregate();

        FileProcessor stringFileProcessor = new FileProcessor(filePath, transformer, aggregator);
        stringFileProcessor.run();
    }
}
