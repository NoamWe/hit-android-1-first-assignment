package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataSource {

    private static DataSource instance;
    private static List<Match> Matches;

    public List<Match> getMatches() {
        return new ArrayList<Match>(Matches);
    }

    private DataSource() {
        Matches = new ArrayList<Match>();
        try {
            getUpcomning();
            getFinished();
        } catch (Exception e) {
        }
    }


    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    private void getFinished() throws IOException, ParseException {
        String pathToCsv = "csv/finished.csv";
        boolean isHeaders = true;
        String row = new String();
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        while ((row = csvReader.readLine()) != null) {
            if (!isHeaders) {
                String[] data = row.split(",");
                Team teamA = new Team(data[0]);
                Team teamB = new Team(data[1]);
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data[2]);
                Score score = new Score(data[3]);
                Tournament tournament = new Tournament(data[4]);
                Match toAdd = new FinishedMatch(teamA, teamB, date, tournament, score);
                Matches.add(toAdd);
            }
            isHeaders = false;
        }
        csvReader.close();
    }

    private void getUpcomning() throws IOException, ParseException {
        String pathToCsv = "csv/upcoming.csv";
        boolean isHeaders = true;
        String row = new String();
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        while ((row = csvReader.readLine()) != null) {
            if (!isHeaders) {
                String[] data = row.split(",");
                Team teamA = new Team(data[0]);
                Team teamB = new Team(data[1]);
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data[2]);
                Tournament tournament = new Tournament(data[4]);
                Match toAdd = new UpcomingMatch(teamA, teamB, date, tournament);
                Matches.add(toAdd);
            }
            isHeaders = false;
        }
        csvReader.close();
    }
}
