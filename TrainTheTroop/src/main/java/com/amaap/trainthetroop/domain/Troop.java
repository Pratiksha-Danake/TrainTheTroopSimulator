package com.amaap.trainthetroop.domain;

import com.amaap.trainthetroop.domain.exceptions.InvalidTroopTypeException;
import com.amaap.trainthetroop.domain.validators.TroopDataValidator;

import java.util.Objects;

public class Troop {
    private TroopType troopType;
    private int trainingTime;
    private int trainingCost;
    private String weapon;

    private Troop(TroopType troopType, int trainingTime, int trainingCost, String weapon) {
        this.troopType = troopType;
        this.trainingTime = trainingTime;
        this.trainingCost = trainingCost;
        this.weapon = weapon;
    }

    public static Troop create(TroopType troopType, int trainingTime, int trainingCost, String weapon) throws InvalidTroopTypeException {
        if (!TroopDataValidator.isValidTroopType(troopType))
            throw new InvalidTroopTypeException("Invalid troop type");
        return new Troop(troopType, trainingTime, trainingCost, weapon);
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
