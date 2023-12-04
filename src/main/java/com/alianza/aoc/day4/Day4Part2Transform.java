package com.alianza.aoc.day4;

import java.util.ArrayList;

import com.alianza.aoc.common.ITransform;
import com.alianza.aoc.day4.dataobject.Card;
import com.alianza.aoc.day4.dataobject.CardNumbers;

public class Day4Part2Transform implements ITransform<Card> {
    public Card transform(int id, String in) {
        Card card = this.parseLine(in);

        ArrayList<Integer> matches = this.findMatches(card);

        System.out.println("[DEBUG Transform] Matches Found: " + matches.size());

        card.setMatches(matches);

        return card;
    }

    private ArrayList<Integer> findMatches(Card card) {
        ArrayList<Integer> matches = new ArrayList<>();

        CardNumbers possibleNumbers = card.getPossibleNumbers();
        ArrayList<Integer> possibleNumberList = possibleNumbers.getNumbers();
        CardNumbers winningNumbers = card.getWinningNumbers();

        for(int i = 0; possibleNumberList.size() > i; i++) {
            int number = possibleNumberList.get(i);
            if (winningNumbers.hasNumber(number)) {
                matches.add(number);
            }
        }

        return matches;
    }

    private Card parseLine(String line) {
        // Split Card #: # # | # #
        String[] cardParts = line.split("\\:\\s+");
        String cardHeader = cardParts[0];
        String cardNumbers = cardParts[1];

        // Split Card #
        String[] cardHeaderParts = cardHeader.split("\\s+");
        String cardHeaderId = cardHeaderParts[1];

        Card newCard = new Card(Integer.parseInt(cardHeaderId));

        // Split winning numbers | possible numbers
        String[] eachCardNumberSet = cardNumbers.split("\\s+\\|\\s+");

        // Setup winning numbers
        String winningNumbersString = eachCardNumberSet[0];
        System.out.println("[DEBUG Transform] winning numbers string: " + winningNumbersString);
        String[] eachWinningNumber = winningNumbersString.split("\\s+");

        for(int i = 0; eachWinningNumber.length > i; i++) {
            newCard.addWinningNumber(Integer.parseInt(eachWinningNumber[i]));
        }

        // Setup Possible numbers
        String possibleNumbersString = eachCardNumberSet[1];
        System.out.println("[DEBUG Transform] possible numbers string: " + possibleNumbersString);
        String[] eachPossibleNumber = possibleNumbersString.split("\\s+");

        for(int i = 0; eachPossibleNumber.length > i; i++) {
            newCard.addPossibleNumber(Integer.parseInt(eachPossibleNumber[i]));
        }

        System.out.println("[DEBUG Transform] New Card " + newCard.getId() + ": " + newCard.getWinningNumbers().getNumbers().toString() + " | " + newCard.getPossibleNumbers().getNumbers().toString());

        return newCard;
    }
}