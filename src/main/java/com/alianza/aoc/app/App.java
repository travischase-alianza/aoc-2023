package com.alianza.aoc.app;

import com.alianza.aoc.controller.FileProcessor;

// Day 4 Part 1
import com.alianza.aoc.day4.Day4Part1Aggregate;
import com.alianza.aoc.day4.Day4Part1Transform;

public class App 
{
    public static void main( String[] args )
    {
        // Day 4
        String filePath = "./inputs/day4.txt";

        System.out.println( "--- Advent of Code! ---" );

        // Day 4 Part 1
        Day4Part1Transform transformer = new Day4Part1Transform();
        Day4Part1Aggregate aggregator = new Day4Part1Aggregate();

        FileProcessor stringFileProcessor = new FileProcessor(filePath, transformer, aggregator);
        stringFileProcessor.run();
    }
}
