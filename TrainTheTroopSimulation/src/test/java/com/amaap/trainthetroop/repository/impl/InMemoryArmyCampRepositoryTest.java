package com.amaap.trainthetroop.repository.impl;

import com.amaap.trainthetroop.AppModule;
import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Barbarian;
import com.amaap.trainthetroop.domain.model.entity.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryArmyCampRepositoryTest {
    private InMemoryArmyCampRepository inMemoryArmyCampRepository;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryArmyCampRepository = injector.getInstance(InMemoryArmyCampRepository.class);
    }

    @Test
    void shouldBeAbleToAddTrooperToArmyCamp() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        Trooper trooper1 = new Archer(6, 20, "Bow And Arrow");
        Trooper trooper2 = new Barbarian(3, 10, "Sword");
        int expectedTrooperCountInCamp = 2;

        // act
        inMemoryArmyCampRepository.addToCamp(trooper1);
        inMemoryArmyCampRepository.addToCamp(trooper2);

        // assert
        assertEquals(expectedTrooperCountInCamp, inMemoryArmyCampRepository.getTroopers().size());
    }

    @Test
    void shouldBeAbleToGetCountOfSpecificTypeOfTrooperFromArmyCamp() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        Trooper trooper1 = new Archer(6, 20, "Bow And Arrow");
        Trooper trooper2 = new Barbarian(3, 10, "Sword");
        int expectedArcherCount = 1;
        int expectedBarbarianCount = 1;

        // act
        inMemoryArmyCampRepository.addToCamp(trooper1);
        inMemoryArmyCampRepository.addToCamp(trooper2);
        int actualArcherCount = inMemoryArmyCampRepository.getCountOfTrooper(Troop.ARCHER);
        int actualBarbarianCount = inMemoryArmyCampRepository.getCountOfTrooper(Troop.BARBARIAN);

        //assert
        assertEquals(expectedArcherCount, actualArcherCount);
        assertEquals(expectedBarbarianCount, actualBarbarianCount);
    }
}