package com.alianza.aoc.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.alianza.aoc.common.IAggregate;
import com.alianza.aoc.common.IReport;
import com.alianza.aoc.common.ITransform;

public class FileProcessor {
    String filePath;
    ITransform transformer;
    IAggregate aggregator;
    IReport reporter;

    public FileProcessor(String filePath, ITransform transformer, IAggregate aggregator, IReport reporter) {
        this.filePath = filePath;
        this.transformer = transformer;
        this.aggregator = aggregator;
        this.reporter = reporter;
    }

    public void run() {
        // Try block to check for exceptions
        try (BufferedReader br
             = new BufferedReader(new FileReader(this.filePath))) {
 
            // Declaring a new string
            String str;
 
            // It holds true till threre is content in file
            int id = 0;
            Object transformResult = new Object();
            Object aggregateResult = new Object();

            while ((str = br.readLine()) != null) {
                // Printing the file data
                System.out.println("[DEBUG Processor] Source Line " + id + ": " + str);

                transformResult = this.transformer.transform(id,str);
                
                // Printing the file data
                System.out.println("[DEBUG Processor] Transform Result: " + transformResult.toString());

                aggregateResult = this.aggregator.aggregate(id, transformResult);
                
                // Printing the file data
                System.out.println("[DEBUG Processor] Aggregate Result: " + aggregateResult.toString());

                id++;
            }

            this.reporter.report(id, transformResult, aggregateResult);
        }
 
        // Catch block to handle the exceptions
        catch (IOException e) {
 
            // Display pop up message if exceptionn occurs
            System.out.println(
                "Error while reading a file.");
        }
    }
}
