package com.amaap.trainthetroop.repository.db.impl;

import com.amaap.trainthetroop.AppModule;
import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Barbarian;
import com.amaap.trainthetroop.domain.model.valueobject.Troop;
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

class FakeInMemoryDatabaseTest {
    private FakeInMemoryDatabase fakeInMemoryDatabase;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        fakeInMemoryDatabase = injector.getInstance(FakeInMemoryDatabase.class);
    }

    @Test
    void shouldBeAbleToAddTrooperToDatabase() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int trainingTime = 6;
        int trainingCost = 20;
        String weapon = "Bow and Arrow";
        Trooper expected = new Archer(trainingTime, trainingCost, weapon);

        // act
        Trooper actual = fakeInMemoryDatabase.addTrooper(expected);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetTroopersOfSpecifiedCount() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int expectedArcherCount = 5;
        int expectedBarbarianCount = 5;
        for (int i = 0; i < 5; i++) {
            fakeInMemoryDatabase.addTrooper(new Archer(6, 20, "Bow and Arrow"));
            fakeInMemoryDatabase.addTrooper(new Barbarian(3, 10, "Sword"));
        }

        // act
        List<Trooper> troopers = fakeInMemoryDatabase.getTroopersOfCount(expectedArcherCount, expectedBarbarianCount);

        // assert
        assertEquals(10, troopers.size());
    }

    @Test
    void shouldBeAbleToAddTroopersToBarracks() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        Trooper trooper1 = new Archer(6, 20, "Bow ANd Arrow");
        Trooper trooper2 = new Barbarian(3, 10, "Sword");

        // act
        fakeInMemoryDatabase.addTroopersToBarrack(List.of(trooper1, trooper2));

        // assert
        assertEquals(2, fakeInMemoryDatabase.getTroopersFromBarracks().size());
    }

    @Test
    void shouldBeAbleToAddTrooperToArmyCamp() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        Trooper trooper1 = new Archer(6, 20, "Bow ANd Arrow");
        Trooper trooper2 = new Barbarian(3, 10, "Sword");
        int expectedTrooperInArmyCamp = 2;

        // act
        fakeInMemoryDatabase.addToCamp(trooper1);
        fakeInMemoryDatabase.addToCamp(trooper2);

        // assert
        assertEquals(expectedTrooperInArmyCamp, fakeInMemoryDatabase.getTroopersFromCamp().size());
    }

    @Test
    void shouldBeAbleToGetCountOfSpecificTypeOfTrooper() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        Trooper trooper1 = new Archer(6, 20, "Bow ANd Arrow");
        Trooper trooper2 = new Barbarian(3, 10, "Sword");
        int expectedTrooperInArmyCamp = 2;

        // act
        fakeInMemoryDatabase.addToCamp(trooper1);
        fakeInMemoryDatabase.addToCamp(trooper2);

        // assert
        assertEquals(1, fakeInMemoryDatabase.getCountOfTrooper(Troop.ARCHER));
        assertEquals(1, fakeInMemoryDatabase.getCountOfTrooper(Troop.BARBARIAN));
    }
}