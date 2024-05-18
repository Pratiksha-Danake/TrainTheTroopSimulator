package com.amaap.trainthetroop.service;

import com.amaap.trainthetroop.domain.model.valueobject.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.repository.ArmyCampRepository;
import com.google.inject.Inject;

import java.util.List;

public class ArmyCampService {
    private final ArmyCampRepository armyCampRepository;

    @Inject
    public ArmyCampService(ArmyCampRepository armyCampRepository) {
        this.armyCampRepository = armyCampRepository;
    }


    public String addTroopToCamp(Trooper trooper) {
        return armyCampRepository.addToCamp(trooper);
    }


    public List<Trooper> getTroopers() {
        return armyCampRepository.getTroopers();
    }

    public int getCountOfTrooper(Troop troop) {
        return armyCampRepository.getCountOfTrooper(troop);
    }
}
