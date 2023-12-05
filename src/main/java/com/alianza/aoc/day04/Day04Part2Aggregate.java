package com.alianza.aoc.day04;

import java.util.ArrayList;

import com.alianza.aoc.common.IAggregate;
import com.alianza.aoc.day04.dataobject.Card;

public class Day04Part2Aggregate implements IAggregate<Object> {
    ArrayList<Card> cards;

    public Day04Part2Aggregate() {
        this.cards = new ArrayList<>();
    }

    public Object aggregate(int id, Object in) {
        this.cards.add(((Card)in));

        return this.calcSum();
    } 

    private int calcSum() {
        ArrayList<Integer> copies = new ArrayList<>(this.cards.size());

        // we start with the original cards
        for(int c = 0; this.cards.size() > c; c++) {
            copies.add(1);
        }

        for(int c = 0; this.cards.size() > c; c++) {
            int matchCount = this.cards.get(c).getMatches().size();

            for (int n = 0; copies.get(c) > n; n++) {
                for(int i = 1; matchCount >= i; i++) {
                    int index = c + i;

                    if (index < this.cards.size()) {
                        copies.set(index, copies.get(index) + 1);
                    }
                }
            }
        }

        System.out.println("[DEBUG Aggregate] Copies: " + copies.toString());

        int sum = 0;
        for(int c = 0; this.cards.size() > c; c++) {
            sum += copies.get(c);
        }

        return sum;
    }
}
