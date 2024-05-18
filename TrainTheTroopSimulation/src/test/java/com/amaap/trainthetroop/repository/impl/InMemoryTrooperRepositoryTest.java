package com.amaap.trainthetroop.repository.impl;

import com.amaap.trainthetroop.AppModule;
import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Barbarian;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryTrooperRepositoryTest {
    private InMemoryTrooperRepository inMemoryTrooperRepository;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryTrooperRepository = injector.getInstance(InMemoryTrooperRepository.class);
    }

    @Test
    void shouldBeAbleToAddTrooperTODatabase() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int trainingTime = 6;
        int trainingCost = 20;
        String weapon = "Bow and Arrow";
        Trooper expected = new Archer(trainingTime, trainingCost, weapon);

        // act
        Trooper actual = inMemoryTrooperRepository.addTrooper(expected);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetTroopersOfSpecifiedCount() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int expectedArcherCount = 5;
        int expectedBarbarianCount = 5;
        for (int i = 0; i < 5; i++) {
            inMemoryTrooperRepository.addTrooper(new Archer(6, 20, "Bow and Arrow"));
            inMemoryTrooperRepository.addTrooper(new Barbarian(3, 10, "Sword"));
        }

        // act
        List<Trooper> troopers = inMemoryTrooperRepository.getTroopersOfCount(expectedArcherCount, expectedBarbarianCount);

        // assert
        assertEquals(10, troopers.size());
    }
}