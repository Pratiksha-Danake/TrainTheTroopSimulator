package com.amaap.trooptrainer;

import com.amaap.trainthetroop.Troop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TroopTest {
    @Test
    void shouldAbleToCreateTroopWithGivenDetails() {
        //Arrange
        String troopType = "Archer";
        String weapon = "Bow and Arrow";
        int trainingTime = 3;
        int trainingCost = 10;
        Troop expectedTroop = Troop.create(troopType, trainingTime, trainingCost, weapon);
        //Act
        Troop actualTroop = Troop.create(troopType, trainingTime, trainingCost, weapon);
        Assertions.assertEquals(expectedTroop, actualTroop);
    }
}
