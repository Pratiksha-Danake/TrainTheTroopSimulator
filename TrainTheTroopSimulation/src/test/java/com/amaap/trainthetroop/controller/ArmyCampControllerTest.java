package com.amaap.trainthetroop.controller;

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

public class ArmyCampControllerTest {
    private ArmyCampController armycampController;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        armycampController = injector.getInstance(ArmyCampController.class);
    }

    @Test
    void shouldBeAbleToAddTrooperToArmyCamp() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        Trooper trooper1 = new Archer(6, 20, "Bow And Arrow");
        Trooper trooper2 = new Barbarian(3, 10, "Sword");
        int expectedTrooperCountInCamp = 2;

        // act
        armycampController.addTroopToCamp(trooper1);
        armycampController.addTroopToCamp(trooper2);

        // assert
        assertEquals(expectedTrooperCountInCamp, armycampController.getTroopers().size());
    }

    @Test
    void shouldBeAbleToGetCountOfSpecificTypeOfTrooperFromArmyCamp() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        Trooper trooper1 = new Archer(6, 20, "Bow And Arrow");
        Trooper trooper2 = new Barbarian(3, 10, "Sword");
        int expectedArcherCount = 1;
        int expectedBarbarianCount = 1;

        // act
        armycampController.addTroopToCamp(trooper1);
        armycampController.addTroopToCamp(trooper2);
        int actualArcherCount = armycampController.getCountOfTrooper(Troop.ARCHER);
        int actualBarbarianCount = armycampController.getCountOfTrooper(Troop.BARBARIAN);

        //assert
        assertEquals(expectedArcherCount, actualArcherCount);
        assertEquals(expectedBarbarianCount, actualBarbarianCount);
    }
}
