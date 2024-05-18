package com.amaap.trainthetroop.controller;

import com.amaap.trainthetroop.controller.dto.Response;
import com.amaap.trainthetroop.controller.valueobject.HttpStatus;
import com.amaap.trainthetroop.domain.model.entity.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.amaap.trainthetroop.service.TrooperService;
import com.google.inject.Inject;

import java.util.List;

public class TrooperController {
    private final TrooperService trooperService;

    @Inject
    public TrooperController(TrooperService trooperService) {
        this.trooperService = trooperService;
    }

    public Response createTrooper(Troop type, int trainingTime, int trainingCost, String weapon) {
        try {
            trooperService.createTrooper(type, trainingTime, trainingCost, weapon);
            return new Response(HttpStatus.OK, "CREATED");
        } catch (InvalidTrainingTimeException | InvalidTrainingCostException |
                 InvalidTrooperWeaponException e) {
            return new Response(HttpStatus.BAD_REQUEST, "Invalid Data");
        }
    }

    public List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount) {
        return trooperService.getTroopersOfCount(archerCount, barbarianCount);
    }
}
