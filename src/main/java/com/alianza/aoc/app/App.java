package com.alianza.aoc.app;

import com.alianza.aoc.day1.Day1Part1;
import com.alianza.aoc.common.FileProcessor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String day1FilePath = "./inputs/day1.txt";

        System.out.println( "--- Advent of Code! ---" );

        Day1Part1 day1part1 = new Day1Part1();
        FileProcessor stringFileProcessor = new FileProcessor(day1FilePath, day1part1);
        stringFileProcessor.run();
    }
}
