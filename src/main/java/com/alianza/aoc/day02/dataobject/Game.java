package com.alianza.aoc.day02.dataobject;

import java.util.ArrayList;

public class Game {
    int id;
    ArrayList<GameSet> sets;

    public Game(int id) {
        this.id = id;
        this.sets = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void putSet(int red, int green, int blue) {
        this.sets.add(new GameSet(red, green, blue));
    }

    public GameSet getSet(int id) {
        return this.sets.get(id);
    }

    public int numSets() {
        return this.sets.size();
    }
    
}
