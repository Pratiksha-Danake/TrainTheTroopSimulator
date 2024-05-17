package com.amaap.trainthetroop.controller;

import com.amaap.trainthetroop.AppModule;
import com.amaap.trainthetroop.controller.dto.Response;
import com.amaap.trainthetroop.controller.valueobject.HttpStatus;
import com.amaap.trainthetroop.domain.model.entity.Troop;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrooperControllerTest {
    private TrooperController trooperController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        trooperController = injector.getInstance(TrooperController.class);
    }

    @Test
    void shouldBeAbleToReturnResponseAsOkIfCreatesTrooperSuccessfully() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int trainingTime = 6;
        int trainingCost = 20;
        String weapon = "Bow and Arrow";
        Troop type = Troop.ARCHER;
        Response expected = new Response(HttpStatus.OK, "CREATED");

        // act
        Response actual = trooperController.createTrooper(type,trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnResponseAsBadRequestIfFailToCreateTrooperSuccessfully() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int trainingTime = 6;
        int trainingCost = 0;
        String weapon = "Bow and Arrow";
        Troop type = Troop.ARCHER;
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Data");

        // act
        Response actual = trooperController.createTrooper(type,trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }
}