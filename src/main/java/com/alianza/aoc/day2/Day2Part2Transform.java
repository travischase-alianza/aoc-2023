package com.alianza.aoc.day2;

import java.util.HashMap;

import com.alianza.aoc.common.ITransform;
import com.alianza.aoc.day2.dataobject.Game;
import com.alianza.aoc.day2.dataobject.GameSet;

public class Day2Part2Transform implements ITransform {
    public String transform(String in) {
        // reset the limits each game for part 2
        int redLimit = 0;
        int greenLimit = 0;
        int blueLimit = 0;

        Game game = this.parseLine(in);

        System.out.println("[DEBUG Transform] Game Id: " + game.getId());

        String result = "0";

        for(int i = 0; game.numSets() > i; i++) {
            GameSet gameSet = game.getSet(i);
            
            System.out.println("[DEBUG Transform] Set: " + i);
            System.out.println("[DEBUG Transform] # Red: " + gameSet.getRed());
            System.out.println("[DEBUG Transform] # Green: " + gameSet.getGreen());
            System.out.println("[DEBUG Transform] # Blue: " + gameSet.getBlue());

            // set exceeds color limits... do not pass on game id for aggregation
            if(gameSet.getRed() > redLimit) {
                redLimit = gameSet.getRed();
            }

            if(gameSet.getGreen() > greenLimit) {
                greenLimit = gameSet.getGreen();
            }

            if(gameSet.getBlue() > blueLimit) {
                blueLimit = gameSet.getBlue();
            }
        }

        System.out.println("[DEBUG Transform] Red Limit: " + redLimit);
        System.out.println("[DEBUG Transform] Green Limit: " + greenLimit);
        System.out.println("[DEBUG Transform] Blue Limit: " + blueLimit);

        int colorLimitProduct = redLimit * greenLimit * blueLimit;

        System.out.println("[DEBUG Transform] Color Limit Product: " + colorLimitProduct);

        result = "" + colorLimitProduct;

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