package com.amaap.trainthetroop.domain.model.entity;

import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrooperTest {
    @Test
    void shouldBeAbleToCreateTheTrooperOfTypeArcher() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int trainingTime = 6;
        int trainingCost = 20;
        String weapon = "Bow and Arrow";
        Trooper expected = new Archer(trainingTime, trainingCost, weapon);

        // act
        Trooper actual = new Archer(trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCreateTheTrooperOfTypeBarbarian() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        int trainingTime = 6;
        int trainingCost = 20;
        String weapon = "Bow and Arrow";
        Trooper expected = new Barbarian(trainingTime, trainingCost, weapon);

        // act
        Trooper actual = new Barbarian(trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowInvalidTrainingTimeExceptionIfTrainingTimeIsNotValid() {
        // arrange
        int trainingTime = 0;
        int trainingCost = 20;
        String weapon = "Bow and Arrow";

        // act && assert
        assertThrows(InvalidTrainingTimeException.class, () -> {
            Trooper trooper = new Archer(trainingTime, trainingCost, weapon);
        });
    }

    @Test
    void shouldThrowInvalidTrainingCostExceptionIfTrainingCostIsNotValid() {
        // arrange
        int trainingTime = 6;
        int trainingCost = 0;
        String weapon = "Bow and Arrow";

        // act && assert
        assertThrows(InvalidTrainingCostException.class, () -> {
            Trooper trooper = new Archer(trainingTime, trainingCost, weapon);
        });
    }

    @Test
    void shouldThrowInvalidTrooperWeaponExceptionIfTrooperWeaponIsNull() {
        // arrange
        int trainingTime = 6;
        int trainingCost = 20;
        String weapon = null;

        // act && assert
        assertThrows(InvalidTrooperWeaponException.class, () -> {
            Trooper trooper = new Archer(trainingTime, trainingCost, weapon);
        });
    }

    @Test
    void shouldThrowInvalidTrooperWeaponExceptionIfTrooperWeaponIsEmpty() {
        // arrange
        int trainingTime = 6;
        int trainingCost = 20;
        String weapon = "";

        // act && assert
        assertThrows(InvalidTrooperWeaponException.class, () -> {
            Trooper trooper = new Archer(trainingTime, trainingCost, weapon);
        });
    }
}
