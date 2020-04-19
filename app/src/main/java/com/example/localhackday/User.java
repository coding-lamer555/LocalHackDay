package com.example.localhackday;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int stupidityPoints;
    private boolean didUserChooseToSleep = false;

    public User() {
        this.stupidityPoints = 0;
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

    public void incStupidityPoints(int inc) {
        this.stupidityPoints += inc;
    }

    public boolean isDidUserChooseToSleep() {
        return didUserChooseToSleep;
    }

    public void setDidUserChooseToSleep(boolean didUserChooseToSleep) {
        this.didUserChooseToSleep = didUserChooseToSleep;
    }
}
