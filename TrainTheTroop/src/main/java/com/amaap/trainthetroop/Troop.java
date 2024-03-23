package com.amaap.trainthetroop;

import java.util.Objects;

public class Troop {
    private String troopType;
    private int trainingTime;
    private int trainingCost;
    private String weapon;

    private Troop(String troopType, int trainingTime, int trainingCost, String weapon) {
        this.troopType = troopType;
        this.trainingTime = trainingTime;
        this.trainingCost = trainingCost;
        this.weapon = weapon;
    }

    public static Troop create(String troopType, int trainingTime, int trainingCost, String weapon) {
        return new Troop(troopType,trainingTime,trainingCost,weapon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Troop troop = (Troop) o;
        return trainingTime == troop.trainingTime && trainingCost == troop.trainingCost && Objects.equals(troopType, troop.troopType) && Objects.equals(weapon, troop.weapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(troopType, trainingTime, trainingCost, weapon);
    }
}
