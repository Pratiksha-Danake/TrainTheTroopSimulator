package com.amaap.trainthetroop.domain.service;

import com.amaap.trainthetroop.AppModule;
import com.amaap.trainthetroop.domain.model.valueobject.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.amaap.trainthetroop.domain.service.exception.TrooperLimitExceededException;
import com.amaap.trainthetroop.service.ArmyCampService;
import com.amaap.trainthetroop.service.TrooperService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BarracksServiceTest {
    private BarracksService barracksService;
    private TrooperService trooperService;
    private ArmyCampService armyCampService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        barracksService = injector.getInstance(BarracksService.class);
        trooperService = injector.getInstance(TrooperService.class);
        armyCampService = injector.getInstance(ArmyCampService.class);
    }

    @Test
    void shouldBeAbleToAddTroopersIntoBarrackForTraining() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException, TrooperLimitExceededException {
        // arrange
        int expectedBarracksSize = 10;
        int archerCount = 5;
        int barbarianCount = 5;
        for (int i = 0; i < 5; i++) {
            trooperService.createTrooper(Troop.ARCHER, 6, 20, "Bow and Arrow");
            trooperService.createTrooper(Troop.BARBARIAN, 3, 10, "Sword");
        }

        // act
        Queue<Trooper> troopersInBarracks = barracksService.addTroopersToBarrack(archerCount, barbarianCount);

        // assert
        assertEquals(expectedBarracksSize, troopersInBarracks.size());
    }

    @Test
    void shouldThrowTrooperLimitExceededExceptionIfTroopersToAddBarracksAreMoreThanTen() {
        // arrange
        int archerCount = 5;
        int barbarianCount = 6;

        // act && assert
        assertThrows(TrooperLimitExceededException.class, () -> {
            barracksService.addTroopersToBarrack(archerCount, barbarianCount);
        });

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
        barracksService.addTroopersToBarrack(archerCount, barbarianCount);
        long startTime = Instant.now().getEpochSecond();
        barracksService.trainTheTroop();
        long endTime = Instant.now().getEpochSecond();

        // assert
        assertEquals(expectedTimeToTrainInMilliSeconds, (endTime - startTime));
    }

    @Test
    void shouldBeAbleToAddTheTrainedTroopersToArmyCamp() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException, InterruptedException, TrooperLimitExceededException {
        // arrange
        int archerCount = 1;
        int barbarianCount = 1;
        trooperService.createTrooper(Troop.ARCHER, 6, 20, "Bow and Arrow");
        trooperService.createTrooper(Troop.BARBARIAN, 3, 10, "Sword");

        // act
        barracksService.addTroopersToBarrack(archerCount, barbarianCount);
        barracksService.trainTheTroop();
        List<Trooper> troopers = armyCampService.getTroopers();

        // assert
        assertEquals(2, troopers.size());
    }
}