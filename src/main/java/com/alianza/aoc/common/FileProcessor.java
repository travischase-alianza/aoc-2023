package com.alianza.aoc.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor<T> {
    String filePath;
    ITransform<T> transformer;

    public FileProcessor(String filePath, ITransform<T> transformer) {
        this.filePath = filePath;
        this.transformer = transformer;
    }

    public void run() {
        // Try block to check for exceptions
        try (BufferedReader br
             = new BufferedReader(new FileReader(this.filePath))) {
 
            // Declaring a new string
            String str;
 
            // It holds true till threre is content in file
            while ((str = br.readLine()) != null) {
 
                // Printing the file data
                System.out.println(str);
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
