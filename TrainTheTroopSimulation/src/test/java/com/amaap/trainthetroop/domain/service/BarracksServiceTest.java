package com.amaap.trainthetroop.domain.service;

import com.amaap.trainthetroop.AppModule;
import com.amaap.trainthetroop.domain.model.entity.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.amaap.trainthetroop.service.TrooperService;
import com.amaap.trainthetroop.service.exception.InvalidTroopTypeException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BarracksServiceTest {
    private BarracksService barracksService;
    private TrooperService trooperService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        barracksService = injector.getInstance(BarracksService.class);
        trooperService = injector.getInstance(TrooperService.class);
    }

    @Test
    void shouldBeAbleToAddTroopersIntoBarrackForTraining() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException, InvalidTroopTypeException {
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
}