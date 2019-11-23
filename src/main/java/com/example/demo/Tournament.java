package com.example.demo;

import java.util.UUID;

public class Tournament {

    private String Id;
    private String Name;

    public Tournament(String name){
        this.Name = name;
        Id = UUID.randomUUID().toString();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}




