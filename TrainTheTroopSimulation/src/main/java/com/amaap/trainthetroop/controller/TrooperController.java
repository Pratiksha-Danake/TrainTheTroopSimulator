package com.amaap.trainthetroop.controller;

import com.amaap.trainthetroop.controller.dto.Response;
import com.amaap.trainthetroop.controller.valueobject.HttpStatus;
import com.amaap.trainthetroop.service.TrooperService;

public class TrooperController {
    private TrooperService trooperService;

    public Response createTrooper(int trainingTime, int trainingCost, String weapon) {
        return new Response(HttpStatus.OK, "CREATED");
    }
}
