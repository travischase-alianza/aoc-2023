package com.alianza.aoc.day01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;

import com.alianza.aoc.common.ITransformString;

public class Day01Part2Transform implements ITransformString {
    Map<String, String> numbers;

    public Day01Part2Transform() {

        this.numbers = Map.ofEntries(
            // zero is a digit but not used in the day 1 part 2 problem
            // Map.entry("zero","0"),
            Map.entry("one","1"),
            Map.entry("two","2"),
            Map.entry("three","3"),
            Map.entry("four","4"),
            Map.entry("five","5"),
            Map.entry("six","6"),
            Map.entry("seven","7"),
            Map.entry("eight","8"),
            Map.entry("nine","9")
        );
    }

    public String transform(int id, String in) {
        Pattern patternTwoNumbers = this.getRegexTwoNumbers();
        Pattern patternOneNumber = this.getRegexOneNumber();
        Matcher matcherTwoNumbers = patternTwoNumbers.matcher(in);
        Matcher matcherOneNumber = patternOneNumber.matcher(in);

        String match = "";

        if (matcherTwoNumbers.matches()) {
            String first = this.convertWordToNumber(matcherTwoNumbers.group(1));
            String second = this.convertWordToNumber(matcherTwoNumbers.group(2));

            match = first;

            System.out.println("[DEBUG Transform] Group 1: " + first);

            match += second;

            System.out.println("[DEBUG Transform] Group 2: " + second);
        }
        else if (matcherOneNumber.matches()) {
            String first = this.convertWordToNumber(matcherOneNumber.group(1));

            match = first;

            System.out.println("[DEBUG Transform] Group 1: " + first);

            match += first;
        }

        System.out.println("[DEBUG Transform] Final Match: " + match);

        return match;
    }

    private String convertWordToNumber (String in) {
        String lower = in.toLowerCase();

        System.out.println("[DEBUG Transform] word to convert: " + lower);

        // if number word then  convert the number word into string digit or return what is already the string digit 
        return this.numbers.getOrDefault(lower, lower); 
    }

    private Pattern getRegexOneNumber() {
        return Pattern.compile("^"
            .concat(".*?")
            .concat("(\\d|(?:one)|(?:two)|(?:three)|(?:four)|(?:five)|(?:six)|(?:seven)|(?:eight)|(?:nine))")
            .concat(".*")
            .concat("(?!\\d|(?:one)|(?:two)|(?:three)|(?:four)|(?:five)|(?:six)|(?:seven)|(?:eight)|(?:nine))*")
            .concat("$")
        );
    }

    private Pattern getRegexTwoNumbers() {
        return Pattern.compile("^"
            .concat(".*?")
            .concat("(\\d|(?:one)|(?:two)|(?:three)|(?:four)|(?:five)|(?:six)|(?:seven)|(?:eight)|(?:nine))")
            .concat(".*")
            .concat("(\\d|(?:one)|(?:two)|(?:three)|(?:four)|(?:five)|(?:six)|(?:seven)|(?:eight)|(?:nine))")
            .concat(".*")
            .concat("(?!\\d|(?:one)|(?:two)|(?:three)|(?:four)|(?:five)|(?:six)|(?:seven)|(?:eight)|(?:nine))*")
            .concat("$")
        );
    }
    
}