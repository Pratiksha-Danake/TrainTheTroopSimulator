package com.amaap.trainthetroop.service;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmyCampServiceTest {
    private ArmyCampService armyCampService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        armyCampService = injector.getInstance(ArmyCampService.class);
    }

    @Test
    void shouldBeAbleToAddTrooperToArmyCamp() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        Trooper trooper1 = new Archer(6, 20, "Bow And Arrow");
        Trooper trooper2 = new Barbarian(3, 10, "Sword");
        int expectedTrooperCountInCamp = 2;

        // act
        armyCampService.addTroopToCamp(trooper1);
        armyCampService.addTroopToCamp(trooper2);

        // assert
        assertEquals(expectedTrooperCountInCamp, armyCampService.getTroopers().size());
    }
}