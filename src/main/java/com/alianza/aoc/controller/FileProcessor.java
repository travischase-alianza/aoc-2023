package com.alianza.aoc.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.alianza.aoc.common.IAggregate;
import com.alianza.aoc.common.ITransform;

public class FileProcessor {
    String filePath;
    ITransform transformer;
    IAggregate aggregator;

    public FileProcessor(String filePath, ITransform transformer, IAggregate aggregator) {
        this.filePath = filePath;
        this.transformer = transformer;
        this.aggregator = aggregator;
    }

    public void run() {
        // Try block to check for exceptions
        try (BufferedReader br
             = new BufferedReader(new FileReader(this.filePath))) {
 
            // Declaring a new string
            String str;
 
            // It holds true till threre is content in file
            int id = 0;

            while ((str = br.readLine()) != null) {
                // Printing the file data
                System.out.println("[DEBUG Processor] Source Line " + id + ": " + str);

                Object transformResult = this.transformer.transform(id,str);
                
                // Printing the file data
                System.out.println("[DEBUG Processor] Transform Result: " + transformResult.toString());

                Object aggregateResult = this.aggregator.aggregate(id, transformResult);
                
                // Printing the file data
                System.out.println("[DEBUG Processor] Aggregate Result: " + aggregateResult.toString());

                id++;
            }
        }
 
        // Catch block to handle the exceptions
        catch (IOException e) {
 
            // Display pop up message if exceptionn occurs
            System.out.println(
                "Error while reading a file.");
        }
    }
}
