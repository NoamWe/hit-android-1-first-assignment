package com.example.demo;

import javax.xml.crypto.Data;
import java.util.Date;

public abstract class Match {
    public MatchStatus status;
    public Team TeamA;
    public Team TeamB;
    public Date StartTime;
    public Tournament Tournament;

    public Match(MatchStatus status, Team a, Team b,Date startTime, Tournament tournament){
        this.TeamA = a;
        this.TeamB =b ;
        this.status = status;
        this.StartTime=startTime;
        this.Tournament=tournament;
    }
}

enum MatchStatus{
    upcoming , finished
}
