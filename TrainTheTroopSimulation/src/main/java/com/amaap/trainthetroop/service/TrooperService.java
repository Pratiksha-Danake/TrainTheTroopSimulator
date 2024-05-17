package com.amaap.trainthetroop.service;

import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Barbarian;
import com.amaap.trainthetroop.domain.model.entity.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.amaap.trainthetroop.service.exception.InvalidTroopTypeException;

public class TrooperService {

    public Trooper createTrooper(Troop type, int trainingTime, int trainingCost, String weapon) throws
            InvalidTroopTypeException, InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        if (Troop.notContains(type))
            throw new InvalidTroopTypeException("Invalid Troop " + type);
        if (type.equals(Troop.ARCHER))
            return new Archer(trainingTime, trainingCost, weapon);
        else if (type.equals(Troop.BARBARIAN)) {
            return new Barbarian(trainingTime, trainingCost, weapon);
        }
        return null;
    }
}
