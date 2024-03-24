package com.amaap.trainthetroop.domain;

import com.amaap.trainthetroop.domain.exceptions.BarracksFullException;

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

    public void trainTheTroop(int noOfArchersToTrain, int noOfBarbarianToTrain) throws BarracksFullException {
        int troopsInTraining = this.noOfArchers + noOfArchersToTrain + this.noOfBarbarians + noOfBarbarianToTrain;
        if (troopsInTraining <= this.maxCapacity) {
            this.noOfArchers += noOfArchersToTrain;
            this.noOfBarbarians += noOfBarbarianToTrain;
        } else {
            throw new BarracksFullException("Barracks is full. Some troops have to wait for some time");
        }
    }
}

