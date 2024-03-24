package com.amaap.trainthetroop.domain;

import com.amaap.trainthetroop.domain.Troop;
import com.amaap.trainthetroop.domain.TroopType;
import com.amaap.trainthetroop.domain.exceptions.InvalidTroopTypeException;
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
}
