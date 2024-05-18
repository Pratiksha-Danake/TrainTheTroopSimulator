package com.amaap.trainthetroop.domain.model.entity;

import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void shouldBeAbleToTestEqualityOfSameObject() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange && act
        Trooper trooper = new Trooper(10, 100, "Rifle");
        String notATrooper = "Not a Trooper";

        // assert
        assertNotEquals(null, trooper);
        assertNotEquals(trooper, notATrooper);
        assertEquals(trooper, trooper);
    }

    @Test
    public void shouldBeAbleToTestEqualObjects() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange && act
        Trooper trooper1 = new Trooper(10, 100, "Rifle");
        Trooper trooper2 = new Trooper(10, 100, "Rifle");

        // assert
        assertEquals(trooper1, trooper2);
    }

    @Test
    public void shouldBeAbleToTestEqualityWhenTrooperHasDifferentTrainingTime() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange && act
        Trooper trooper1 = new Trooper(10, 100, "Rifle");
        Trooper trooper2 = new Trooper(20, 100, "Rifle");

        // assert
        assertNotEquals(trooper1, trooper2);
    }

    @Test
    public void shouldBeAbleToTestEqualityWhenTrooperHasDifferentTrainingCost() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange && act
        Trooper trooper1 = new Trooper(10, 100, "Rifle");
        Trooper trooper2 = new Trooper(10, 200, "Rifle");

        // assert
        assertNotEquals(trooper1, trooper2);
    }

    @Test
    public void shouldBeAbleToTestEqualityWhenTrooperHasDifferentWeapon() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange && act
        Trooper trooper1 = new Trooper(10, 100, "Rifle");
        Trooper trooper2 = new Trooper(10, 100, "Pistol");

        // assert
        assertNotEquals(trooper1, trooper2);
    }

    @Test
    public void shouldBeAbleToTestEqualityWhenTrooperHasAllDifferentData() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange && act
        Trooper trooper1 = new Trooper(10, 100, "Rifle");
        Trooper trooper2 = new Trooper(20, 200, "Pistol");

        // assert
        assertNotEquals(trooper1, trooper2);
    }

    @Test
    public void shouldBeAbleToTestEqualityWhenTrooperHasWeaponNull() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange && act
        Trooper trooper1 = new Trooper(10, 100, "null");
        Trooper trooper2 = new Trooper(10, 100, "Rifle");

        // assert
        assertNotEquals(trooper1, trooper2);
    }

    @Test
    public void shouldBeAbleToTestEqualityWhenTrooperHasBothWeaponsNull() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange && act
        Trooper trooper1 = new Trooper(10, 100, "null");
        Trooper trooper2 = new Trooper(10, 100, "null");

        // assert
        assertEquals(trooper1, trooper2);
    }

    @Test
    public void shouldBeAbleToTestEqualityWhenTrooperHasWeaponAndOtherFieldsDifferent() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange && act
        Trooper trooper1 = new Trooper(10, 100, "null");
        Trooper trooper2 = new Trooper(20, 200, "Rifle");

        // assert
        assertNotEquals(trooper1, trooper2);
    }

    @Test
    void shouldBeAbleToReturnHashCode() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        // arrange
        Trooper trooper1 = new Trooper(10, 100, "null");
        Trooper trooper2 = new Trooper(20, 200, "Rifle");

        // act && assert
        assertNotEquals(trooper1.hashCode(), trooper2.hashCode());
    }
}
