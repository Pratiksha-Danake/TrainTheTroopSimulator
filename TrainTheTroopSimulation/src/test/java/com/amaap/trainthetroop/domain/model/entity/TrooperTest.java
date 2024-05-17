package com.amaap.trainthetroop.domain.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrooperTest {
    @Test
    void shouldBeAbleToCreateTheTrooperOfTypeArcher() {
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
}
