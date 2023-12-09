package com.alianza.aoc.day06;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alianza.aoc.common.ITransform;
import com.alianza.aoc.day06.dataobject.RaceStat;
import com.alianza.aoc.day06.dataobject.RaceStatList;

public class Day06Part2Transform implements ITransform<HashMap> {
    RaceStatList raceStatList;
    HashMap<Integer,RaceStatList> possibleWins;

    public Day06Part2Transform() {
        raceStatList = new RaceStatList();
        possibleWins = new HashMap<>();
    }

    public HashMap transform(int id, String in) {
        Pattern patternTime = this.getRegexTime();
        Matcher matcherTime = patternTime.matcher(in);

        if(matcherTime.matches()) {
            int matchCount = matcherTime.groupCount();
            String match = matcherTime.group(1);
            match = match.trim();

            System.out.println("[DEBUG Transform] Time match count: " + matchCount);
            System.out.println("[DEBUG Transform] Time match: " + match);
            String matches[] = match.split("\\s+");

            String number = "";
            for(int i = 0; matches.length > i; i++) {
                number +=  matches[i];
            }

            long time = Long.parseLong(number);
            this.raceStatList.getRaceStats().add(new RaceStat());
            this.raceStatList.getRaceStats().get(0).setTime(time);

        } else {
            Pattern patternDistance = this.getRegexDistance();
            Matcher matcherDistance = patternDistance.matcher(in);

            if(matcherDistance.matches()) {
                int matchCount = matcherDistance.groupCount();
                String match = matcherDistance.group(1);
                match = match.trim();

                System.out.println("[DEBUG Transform] Distance match count: " + matchCount);
                System.out.println("[DEBUG Transform] Distance match: " + match);
                String matches[] = match.split("\\s+"); 

                String number = "";
                for(int i = 0; matches.length > i; i++) {
                    number +=  matches[i];
                }

                long distance = Long.parseLong(number);
                RaceStat race = this.raceStatList.getRaceStats().get(0);
                race.setDistance(distance); 
                this.possibleWins.put(0, this.calculateWins(race));
            }
        }

        return this.possibleWins;
    }

    private Pattern getRegexTime() {
        return Pattern.compile("^Time:((?:\\s+\\d+)+)\\s*$");
    }

    private Pattern getRegexDistance() {
        return Pattern.compile("^Distance:((?:\\s+\\d+)+)\\s*$");
    }

    private RaceStatList calculateWins (RaceStat race) {
        RaceStatList racePossibleWins = new RaceStatList();

        for(int t = 1; race.getTime() > t; t++) {
            long speed = t;
            long remainingTime = race.getTime() - t;
            long distanceTraveled = remainingTime * speed;

            if(distanceTraveled > race.getDistance()) {
                racePossibleWins.getRaceStats().add(new RaceStat(t, distanceTraveled));
            }
        }

        return racePossibleWins;
    }
}