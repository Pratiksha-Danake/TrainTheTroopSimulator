package com.amaap.trainthetroop.controller;

import com.amaap.trainthetroop.controller.dto.Response;
import com.amaap.trainthetroop.controller.valueobject.HttpStatus;
import com.amaap.trainthetroop.domain.service.BarracksService;
import com.amaap.trainthetroop.domain.service.exception.TrooperLimitExceededException;
import com.google.inject.Inject;

public class BarracksController {
    private final BarracksService barracksService;

    @Inject
    public BarracksController(BarracksService barracksService) {
        this.barracksService = barracksService;
    }

    public Response addTroopersToBarrack(int archerCount, int barbarianCount) {
        try {
            barracksService.addTroopersToBarrack(archerCount, barbarianCount);
            return new Response(HttpStatus.OK, "Added");

        } catch (TrooperLimitExceededException e) {
            return new Response(HttpStatus.BAD_REQUEST, "Invalid Trooper Count");
        }
    }

    public void trainTheTroop() {
        try {
            barracksService.trainTheTroop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
