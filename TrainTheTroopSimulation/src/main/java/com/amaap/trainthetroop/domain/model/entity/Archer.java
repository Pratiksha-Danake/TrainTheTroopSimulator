package com.amaap.trainthetroop.domain.model.entity;

import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;

public class Archer extends Trooper {
    public Archer(int trainingTime, int trainingCost, String weapon) throws InvalidTrainingTimeException, InvalidTrainingCostException {
        super(trainingTime, trainingCost, weapon);
    }
}
