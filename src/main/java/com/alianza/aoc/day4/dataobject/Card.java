package com.alianza.aoc.day4.dataobject;

import lombok.Getter;
import lombok.Setter;

public class Card {
    @Getter int id;

    @Getter @Setter CardNumbers winningNumbers;
    @Getter @Setter CardNumbers possibleNumbers;

    public Card(int id) {
        this.id = id;

        this.winningNumbers = new CardNumbers();
        this.possibleNumbers = new CardNumbers();
    }

    public void addWinningNumber(int num) {
        this.winningNumbers.addNumber(num);
    }

    public void addPossibleNumber(int num) {
        this.possibleNumbers.addNumber(num);
    }
}
