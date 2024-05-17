package com.amaap.trainthetroop.service;

import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Barbarian;
import com.amaap.trainthetroop.domain.model.entity.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.amaap.trainthetroop.repository.TrooperRepository;
import com.amaap.trainthetroop.service.exception.InvalidTroopTypeException;
import com.google.inject.Inject;

import java.util.List;

public class TrooperService {
    private final TrooperRepository trooperRepository;

    @Inject
    public TrooperService(TrooperRepository trooperRepository) {
        this.trooperRepository = trooperRepository;
    }

    public Trooper createTrooper(Troop type, int trainingTime, int trainingCost, String weapon) throws
            InvalidTroopTypeException, InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        Trooper trooperToAdd = null;

        if (Troop.notContains(type))
            throw new InvalidTroopTypeException("Invalid Troop " + type);
        if (type.equals(Troop.ARCHER))
            trooperToAdd = new Archer(trainingTime, trainingCost, weapon);
        else if (type.equals(Troop.BARBARIAN)) {
            trooperToAdd = new Barbarian(trainingTime, trainingCost, weapon);
        }
        return trooperRepository.addTrooper(trooperToAdd);
    }

    public List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount) {
        return trooperRepository.getTroopersOfCount(archerCount, barbarianCount);
    }
}
