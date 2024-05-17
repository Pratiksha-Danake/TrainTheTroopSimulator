package com.amaap.trainthetroop.domain.model.entity;

import java.util.Objects;

public class Trooper {
    int trainingTime;
    int trainingCost;
    String weapon;

    public Trooper(int trainingTime, int trainingCost, String weapon) {
        this.trainingTime = trainingTime;
        this.trainingCost = trainingCost;
        this.weapon = weapon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trooper trooper = (Trooper) o;
        return trainingTime == trooper.trainingTime && trainingCost == trooper.trainingCost && Objects.equals(weapon, trooper.weapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingTime, trainingCost, weapon);
    }
}
