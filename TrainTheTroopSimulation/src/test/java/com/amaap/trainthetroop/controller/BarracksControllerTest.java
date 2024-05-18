package com.amaap.trainthetroop.controller;

import com.amaap.trainthetroop.AppModule;
import com.amaap.trainthetroop.controller.dto.Response;
import com.amaap.trainthetroop.controller.valueobject.HttpStatus;
import com.amaap.trainthetroop.domain.model.valueobject.Troop;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.amaap.trainthetroop.domain.service.exception.TrooperLimitExceededException;
import com.amaap.trainthetroop.service.TrooperService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarracksControllerTest {
    private BarracksController barracksController;
    private TrooperService trooperService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        barracksController = injector.getInstance(BarracksController.class);
        trooperService = injector.getInstance(TrooperService.class);
    }

    @Test
    void shouldGetResponseAsOkIfAddsTrooperSuccessfullyToTheBarracks() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int archerCount = 5;
        int barbarianCount = 5;
        for (int i = 0; i < 5; i++) {
            trooperService.createTrooper(Troop.ARCHER, 6, 20, "Bow and Arrow");
            trooperService.createTrooper(Troop.BARBARIAN, 3, 10, "Sword");
        }
        Response expected = new Response(HttpStatus.OK, "Added");

        // act
        Response actual = barracksController.addTroopersToBarrack(archerCount, barbarianCount);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetResponseAsBadRequestIfFailsToAddTroopersToBarracks() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int archerCount = 5;
        int barbarianCount = 6;
        for (int i = 0; i < 5; i++) {
            trooperService.createTrooper(Troop.ARCHER, 6, 20, "Bow and Arrow");
            trooperService.createTrooper(Troop.BARBARIAN, 3, 10, "Sword");
        }
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Trooper Count");

        // act
        Response actual = barracksController.addTroopersToBarrack(archerCount, barbarianCount);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToTrainSingleTroopAtATime() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException, InterruptedException, TrooperLimitExceededException {
        // arrange
        int archerCount = 5;
        int barbarianCount = 5;
        int expectedTimeToTrainInMilliSeconds = 45;
        for (int i = 0; i < 5; i++) {
            trooperService.createTrooper(Troop.ARCHER, 6, 20, "Bow and Arrow");
            trooperService.createTrooper(Troop.BARBARIAN, 3, 10, "Sword");
        }

        // act
        barracksController.addTroopersToBarrack(archerCount, barbarianCount);
        long startTime = Instant.now().getEpochSecond();
        barracksController.trainTheTroop();
        long endTime = Instant.now().getEpochSecond();

        // assert
        assertEquals(expectedTimeToTrainInMilliSeconds, (endTime - startTime));
    }
}
