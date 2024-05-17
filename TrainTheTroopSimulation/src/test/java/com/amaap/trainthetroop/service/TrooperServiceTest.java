package com.amaap.trainthetroop.service;

import com.amaap.trainthetroop.AppModule;
import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.amaap.trainthetroop.service.exception.InvalidTroopTypeException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrooperServiceTest {
    private TrooperService trooperService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        trooperService = injector.getInstance(TrooperService.class);
    }

    @Test
    void shouldBeAbleToCreateTheTrooper() throws
            InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException, InvalidTroopTypeException {
        // arrange
        int trainingTime = 6;
        int trainingCost = 20;
        String weapon = "Bow and Arrow";
        Troop type = Troop.ARCHER;
        Trooper expected = new Archer(trainingTime, trainingCost, weapon);

        // act
        Trooper actual = trooperService.createTrooper(type, trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetTroopersOfSpecifiedCount() throws InvalidTroopTypeException, InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int expectedArcherCount = 5;
        int expectedBarbarianCount = 5;
        for (int i = 0; i < 5; i++) {
            trooperService.createTrooper(Troop.ARCHER, 6, 20, "Bow and Arrow");
            trooperService.createTrooper(Troop.BARBARIAN, 3, 10, "Sword");
        }

        // act
        List<Trooper> troopers = trooperService.getTroopersOfCount(expectedArcherCount, expectedBarbarianCount);

        // assert
        assertEquals(10, troopers.size());
    }
}