package com.example.localhackday;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int stupidityPoints;

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStupidityPoints() {
        return stupidityPoints;
    }

    public void setStupidityPoints(int stupidityPoints) {
        this.stupidityPoints = stupidityPoints;
    }
}
