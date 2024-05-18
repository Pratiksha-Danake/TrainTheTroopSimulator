package com.amaap.trainthetroop.domain.model.entity;

import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;

import java.util.Objects;

import static com.amaap.trainthetroop.domain.model.entity.TroopDataValidator.*;

public class Trooper {
    int trainingTime;
    int trainingCost;
    String weapon;

    public Trooper(int trainingTime, int trainingCost, String weapon) throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        if (isInValidTime(trainingTime))
            throw new InvalidTrainingTimeException("Time Cannot Be Zero or Less" + trainingTime);
        if (isInvalidTrainingCost(trainingCost))
            throw new InvalidTrainingCostException("Cost Cannot Be Zero or Less" + trainingCost);
        if (isInValidWeapon(weapon))
            throw new InvalidTrooperWeaponException("Weapon Cannot Be Null or empty");
        this.trainingTime = trainingTime;
        this.trainingCost = trainingCost;
        this.weapon = weapon;
    }

    public int getTrainingTime() {
        return trainingTime;
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
