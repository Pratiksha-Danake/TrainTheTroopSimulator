package com.amaap.trainthetroop.domain.model.entity;

import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;

import java.util.Objects;

import static com.amaap.trainthetroop.domain.model.entity.TroopDataValidator.isInValidTime;
import static com.amaap.trainthetroop.domain.model.entity.TroopDataValidator.isInvalidTrainingCost;

public class Trooper {
    int trainingTime;
    int trainingCost;
    String weapon;

    public Trooper(int trainingTime, int trainingCost, String weapon) throws InvalidTrainingTimeException, InvalidTrainingCostException {
        if (isInValidTime(trainingTime))
            throw new InvalidTrainingTimeException("Time Cannot Be Zero Or Less" + trainingTime);
        if (isInvalidTrainingCost(trainingCost))
            throw new InvalidTrainingCostException("Cost Cannot Be Zero Or Less" + trainingCost);
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
