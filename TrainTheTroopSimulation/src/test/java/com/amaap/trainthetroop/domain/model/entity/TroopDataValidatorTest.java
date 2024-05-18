package com.amaap.trainthetroop.domain.model.entity;

import com.amaap.trainthetroop.domain.model.entity.validator.TroopDataValidator;
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