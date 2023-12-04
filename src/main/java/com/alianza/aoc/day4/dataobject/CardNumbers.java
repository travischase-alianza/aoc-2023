package com.alianza.aoc.day4.dataobject;

import java.util.ArrayList;

public class CardNumbers {
    ArrayList<Integer> numbers;

    public CardNumbers() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(int num) {
        numbers.add(num);
    }

    public boolean hasNumber(int num) {
        return numbers.contains(num);
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }
}
