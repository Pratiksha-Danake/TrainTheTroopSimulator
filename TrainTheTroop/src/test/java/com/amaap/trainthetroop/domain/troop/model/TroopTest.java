package com.amaap.trainthetroop.domain.troop.model;

import com.amaap.trainthetroop.domain.troop.exceptions.InvalidTroopTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TroopTest {
    @Test
    void shouldAbleToCreateTroopWithGivenDetails() throws InvalidTroopTypeException {
        //Arrange
        TroopType troopType = TroopType.ARCHER;
        String weapon = "Bow and Arrow";
        int trainingTime = 3;
        int trainingCost = 10;
        Troop expectedTroop = Troop.create(troopType, trainingTime, trainingCost, weapon);
        //Act
        Troop actualTroop = Troop.create(troopType, trainingTime, trainingCost, weapon);
        //Assert
        Assertions.assertEquals(expectedTroop, actualTroop);
    }

    @Test
    void shouldAbleToThrowInvalidTroopTypeExceptionWhenTroopTypeIsNull() throws InvalidTroopTypeException {
        //Arrange
        TroopType troopType = null;
        String weapon = "Bow and Arrow";
        int trainingTime = 3;
        int trainingCost = 10;
        //Act && Assert
        Assertions.assertThrows(InvalidTroopTypeException.class, () -> {
            Troop.create(troopType, trainingTime, trainingCost, weapon);
        });
    }

    @Test
    void shouldAbleToThrowInvalidTroopTypeExceptionWhenTroopTypeIsOtherThanArcherAndBarbarian() throws InvalidTroopTypeException {
        //Arrange
        TroopType troopType = TroopType.GOBLINS;
        String weapon = "Bow and Arrow";
        int trainingTime = 3;
        int trainingCost = 10;
        //Act && Assert
        Assertions.assertThrows(InvalidTroopTypeException.class, () -> {
            Troop.create(troopType, trainingTime, trainingCost, weapon);
        });
    }
}
