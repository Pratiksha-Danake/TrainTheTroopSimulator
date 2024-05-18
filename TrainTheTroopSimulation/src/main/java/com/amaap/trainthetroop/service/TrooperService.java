package com.amaap.trainthetroop.service;

import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Barbarian;
import com.amaap.trainthetroop.domain.model.valueobject.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.amaap.trainthetroop.repository.TrooperRepository;
import com.google.inject.Inject;

import java.util.List;

public class TrooperService {
    private final TrooperRepository trooperRepository;

    @Inject
    public TrooperService(TrooperRepository trooperRepository) {
        this.trooperRepository = trooperRepository;
    }

    public Trooper createTrooper(Troop type, int trainingTime, int trainingCost, String weapon) throws
            InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        Trooper trooperToAdd = null;

        if (type.equals(Troop.ARCHER))
            trooperToAdd = new Archer(trainingTime, trainingCost, weapon);
        if (type.equals(Troop.BARBARIAN))
            trooperToAdd = new Barbarian(trainingTime, trainingCost, weapon);
        return trooperRepository.addTrooper(trooperToAdd);
    }

    public List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount) {
        return trooperRepository.getTroopersOfCount(archerCount, barbarianCount);
    }
}
