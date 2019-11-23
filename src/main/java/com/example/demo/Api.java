package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@RestController
public class Api {


    @RequestMapping(value = "matches/team", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Match> getMatchesByTeam(@RequestParam(value = "name") String name) {
        DataSource data = DataSource.getInstance();
        List<Match> matches = data.getMatches();
        matches.removeIf(match ->
                !match.TeamA.getName().equals(name)
                        && !match.TeamB.getName().equals(name));
        return matches;
        //        return new Team("A tem");
    }

    @RequestMapping(value = "matches/team/status", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Match> getMatchesByTeamStatus(@RequestParam(value = "name") String name,
                                              @RequestParam(value = "status") String status) {
        DataSource data = DataSource.getInstance();
        List<Match> matches = data.getMatches();
        MatchStatus requestedStatus = MatchStatus.valueOf(status);
        matches.removeIf(match ->
                !match.TeamA.getName().equals(name)
                        && !match.TeamB.getName().equals(name)
                        && !match.status.equals(status));
        return matches;
    }
}
//match -> {
//        String nameA = match.TeamA.getName();
//        String nameB = match.TeamB.getName();
//        !nameA.equals(name) && !nameB.equals(name);
//        }