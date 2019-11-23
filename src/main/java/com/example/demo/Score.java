package com.example.demo;

public class Score{
    private int A;
    private  int B;

    public Score(String score){

        String[] scores = score.split(" ");
        this.A =Integer.parseInt(scores[0]);
        this.B =Integer.parseInt(scores[1]);
    }

    @Override
    public String toString() {
        return "" + A +":" +B;
    }
}
