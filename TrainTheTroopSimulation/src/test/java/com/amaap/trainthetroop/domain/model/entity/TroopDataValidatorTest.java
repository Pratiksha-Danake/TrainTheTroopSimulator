package com.amaap.trainthetroop.domain.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TroopDataValidatorTest {
    @Test
    void shouldBeAbleToCreateInstanceOfTrooperDataValidator() {
        // arrange && act
        TroopDataValidator troopDataValidator = new TroopDataValidator();

        // assert
        assertNotNull(troopDataValidator);
    }
}