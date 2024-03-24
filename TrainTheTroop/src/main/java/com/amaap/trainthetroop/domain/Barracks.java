package com.amaap.trainthetroop.domain;

public class Barracks {
    private final int maxCapacity;
    private int noOfArchers;
    private int noOfBarbarians;

    public Barracks(int maxCapacity, int noOfArchers, int noOfBarbarians) {
        this.maxCapacity = maxCapacity;
        this.noOfArchers = 0;
        this.noOfBarbarians = 0;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getNoOfArchers() {
        return noOfArchers;
    }

    public int getNoOfBarbarians() {
        return noOfBarbarians;
    }

    public void trainTheTroop(int noOfArchersToTrain, int noOfBarbarianToTrain) {
        if (this.noOfArchers + noOfArchersToTrain +
                this.noOfBarbarians + noOfArchersToTrain <= this.maxCapacity) {
            this.noOfArchers += noOfArchersToTrain;
            this.noOfBarbarians += noOfBarbarianToTrain;
        }
    }
}

