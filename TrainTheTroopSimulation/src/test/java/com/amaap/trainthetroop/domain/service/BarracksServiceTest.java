package com.amaap.trainthetroop.domain.service;

import com.amaap.trainthetroop.AppModule;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.amaap.trainthetroop.util.TrooperBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

class BarracksServiceTest {
    private BarracksService barracksService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        barracksService = injector.getInstance(BarracksService.class);
    }

    @Test
    void shouldBeAbleToGetTroopersIntoBarrackForTraining() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        List<Trooper> troopersToTrain = TrooperBuilder.getTroopersToTrain();
        int expectedBarracksSize = 10;
        int archerCount = 5;
        int barbarianCount = 5;

        // act
        Queue<Trooper> troopersToTrain1 = barracksService.getTroopersToTrain(archerCount, barbarianCount);
    }
}