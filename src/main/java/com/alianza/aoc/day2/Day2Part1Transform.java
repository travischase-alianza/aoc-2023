package com.alianza.aoc.day2;

import com.alianza.aoc.day2.part1.Game;
import com.alianza.aoc.day2.part1.GameSet;

import java.util.HashMap;

import com.alianza.aoc.common.ITransform;

public class Day2Part1Transform implements ITransform {
    int redLimit;
    int greenLimit;
    int blueLimit;

    public Day2Part1Transform () {
        this.redLimit = 12;
        this.greenLimit = 13;
        this.blueLimit = 14;
    }

    public String transform(String in) {
        Game game = this.parseLine(in);

        System.out.println("[DEBUG Transform] Game Id: " + game.getId());

        String result = "" + game.getId();

        for(int i = 0; game.numSets() > i; i++) {
            GameSet gameSet = game.getSet(i);
            
            System.out.println("[DEBUG Transform] Set: " + i);
            System.out.println("[DEBUG Transform] # Red: " + gameSet.getRed());
            System.out.println("[DEBUG Transform] # Green: " + gameSet.getGreen());
            System.out.println("[DEBUG Transform] # Blue: " + gameSet.getBlue());

            // set exceeds color limits... do not pass on game id for aggregation
            if(gameSet.getRed() > this.redLimit || gameSet.getGreen() > this.greenLimit || gameSet.getBlue() > this.blueLimit) {
                result = "0";
            }
        }

        return result;
    }

    private Game parseLine(String line) {
        // Split Game #: set; set; set;
        String[] gameParts = line.split("\\:\\s*");
        String gameHeader = gameParts[0];
        String gameSets = gameParts[1];

        // Split Game #
        String[] gameHeaderParts = gameHeader.split("\\s+");
        String gameHeaderId = gameHeaderParts[1];

        Game newGame = new Game(Integer.parseInt(gameHeaderId));

        // Split set; set; set;
        String[] eachGameSet = gameSets.split(";\\s*");

        for(int i = 0; eachGameSet.length > i; i++) {
            // Split # color, # color, # color
            String[] eachColor = eachGameSet[i].split(",\\s*");

            HashMap<String, Integer> colorValues = new HashMap<>();
            colorValues.put("red", 0);
            colorValues.put("green", 0);
            colorValues.put("blue", 0);

            // set the amounts of each color with values from the input
            for(int c = 0; eachColor.length > c; c++) {
                String[] colorParts = eachColor[c].split("\\s+");
                String colorAmount = colorParts[0];
                String colorName = colorParts[1];
                colorValues.put(colorName.toLowerCase(),Integer.parseInt(colorAmount));
            }

            newGame.putSet(
                colorValues.get("red"),
                colorValues.get("green"),
                colorValues.get("blue")
            );
        }

        return newGame;
    }
}