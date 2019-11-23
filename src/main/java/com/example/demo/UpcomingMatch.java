package com.example.demo;

import org.apache.tomcat.jni.Local;

import java.time.LocalTime;
import java.util.Date;

public class UpcomingMatch  extends Match{

    public LocalTime KickoffTime;

    public UpcomingMatch(Team a, Team b, Date startTime, com.example.demo.Tournament tournament) {
        super(MatchStatus.upcoming, a, b, startTime, tournament);
        KickoffTime = LocalTime.of(19 , 00);
    }
}
