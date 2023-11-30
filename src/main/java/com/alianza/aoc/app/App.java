package com.alianza.aoc.app;

import com.alianza.aoc.controller.FileProcessor;
import com.alianza.aoc.day1.Day1Part1Aggregate;
import com.alianza.aoc.day1.Day1Part1Transform;

public class App 
{
    public static void main( String[] args )
    {
        String day1FilePath = "./inputs/day1.txt";

        System.out.println( "--- Advent of Code! ---" );

        Day1Part1Transform day1Part1Transformer = new Day1Part1Transform();
        Day1Part1Aggregate day1Part1Aggregator = new Day1Part1Aggregate();
        FileProcessor stringFileProcessor = new FileProcessor(day1FilePath, day1Part1Transformer, day1Part1Aggregator);
        stringFileProcessor.run();
    }
}
