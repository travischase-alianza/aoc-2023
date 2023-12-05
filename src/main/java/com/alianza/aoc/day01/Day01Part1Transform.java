package com.alianza.aoc.day01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alianza.aoc.common.ITransformString;

public class Day01Part1Transform implements ITransformString {
    public String transform(int id, String in) {
        Pattern patternTwoNumbers = this.getRegexTwoNumbers();
        Pattern patternOneNumber = this.getRegexOneNumber();
        Matcher matcherTwoNumbers = patternTwoNumbers.matcher(in);
        Matcher matcherOneNumber = patternOneNumber.matcher(in);

        String match = "";

        if (matcherTwoNumbers.matches()) {
            match = matcherTwoNumbers.group(1);

            System.out.println("[DEBUG Transform] Group 1: " + matcherTwoNumbers.group(1));

            match += matcherTwoNumbers.group(2);

            System.out.println("[DEBUG Transform] Group 2: " + matcherTwoNumbers.group(2));
        }
        else if (matcherOneNumber.matches()) {
            match = matcherOneNumber.group(1);

            System.out.println("[DEBUG Transform] Group 1: " + matcherOneNumber.group(1));

            match += matcherOneNumber.group(1);

        }

        System.out.println("[DEBUG Transform] Final Match: " + match);

        return match;
    }

    private Pattern getRegexOneNumber() {
        return Pattern.compile("^[^\\d]*(?<first>\\d)[^\\d]*$");
    }

    private Pattern getRegexTwoNumbers() {
        return Pattern.compile("^[^\\d]*(?<first>\\d).*(?<last>\\d)[^\\d]*$");
    }
    
}