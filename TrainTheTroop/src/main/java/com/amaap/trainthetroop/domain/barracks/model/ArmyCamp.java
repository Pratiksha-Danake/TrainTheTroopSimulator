package com.amaap.trainthetroop.domain.barracks.model;

public class ArmyCamp {
    private int totalArchers;
    private int totalBarbarians;

    public int getTotalArchers() {
        return totalArchers;
    }

    public int getTotalBarbarians() {
        return totalBarbarians;
    }

    public void addArchers(int count) {
        totalArchers += count;
    }

    public void addBarbarians(int count) {
        totalBarbarians += count;
    }
}
