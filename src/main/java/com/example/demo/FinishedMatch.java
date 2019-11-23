package com.example.demo;

import java.util.Date;

public class FinishedMatch extends Match {

    private Score Score;
    public FinishedMatch(Team a, Team b, Date startTime, com.example.demo.Tournament tournament ,Score score) {
        super(MatchStatus.finished, a, b, startTime, tournament);
        this.Score = score;
    }
}

