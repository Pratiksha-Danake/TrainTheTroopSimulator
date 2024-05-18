package com.amaap.trainthetroop.controller;

import com.amaap.trainthetroop.domain.model.valueobject.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.service.ArmyCampService;
import com.google.inject.Inject;

import java.util.List;

public class ArmyCampController {
    private final ArmyCampService armyCampService;

    @Inject
    public ArmyCampController(ArmyCampService armyCampService) {
        this.armyCampService = armyCampService;
    }

    public void addTroopToCamp(Trooper trooper) {
        armyCampService.addTroopToCamp(trooper);
    }

    public List<Trooper> getTroopers() {
        return armyCampService.getTroopers();
    }

    public int getCountOfTrooper(Troop troop) {
        return armyCampService.getCountOfTrooper(troop);
    }
}
