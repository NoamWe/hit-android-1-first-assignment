package com.example.demo;

import java.util.UUID;

public class Team {
    private String Id;
    private String Name;

    public Team(String name){
        this.Name = name;
        Id = UUID.randomUUID().toString();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
