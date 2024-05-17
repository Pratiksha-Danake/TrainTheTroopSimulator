package com.amaap.trainthetroop.domain.model.entity;

import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;

public class Archer extends Trooper {
    public Archer(int trainingTime, int trainingCost, String weapon) throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        super(trainingTime, trainingCost, weapon);
    }
}
