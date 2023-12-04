package com.alianza.aoc.app;

import com.alianza.aoc.controller.FileProcessor;

// Day 4 Part 2
import com.alianza.aoc.day4.Day4Part2Aggregate;
import com.alianza.aoc.day4.Day4Part2Transform;

public class App 
{
    public static void main( String[] args )
    {
        // Day 4
        String filePath = "./inputs/day4.txt";

        System.out.println( "--- Advent of Code! ---" );

        // Day 4 Part 2
        Day4Part2Transform transformer = new Day4Part2Transform();
        Day4Part2Aggregate aggregator = new Day4Part2Aggregate();

        FileProcessor stringFileProcessor = new FileProcessor(filePath, transformer, aggregator);
        stringFileProcessor.run();
    }
}
