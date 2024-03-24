package com.amaap.trainthetroop.domain;

import com.amaap.trainthetroop.domain.exceptions.BarracksFullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BarracksTest {
    @Test
    void shouldAbleToTrainWhenNumberOfTroopsLessThanBarracksMaxSize() throws BarracksFullException {
        //Arrange
        int noOfArchersToTrain = 5;
        int noOfBarbarianToTrain = 5;
        int maxSize = 10;
        Barracks barracks = new Barracks(maxSize, 0, 0);
        //Act
        barracks.trainTheTroop(noOfArchersToTrain, noOfBarbarianToTrain);
        //Assert
        Assertions.assertEquals(5, barracks.getNoOfArchers());
        Assertions.assertEquals(5, barracks.getNoOfBarbarians());
    }

    @Test
    void shouldAbleToThrowBarracksFullExceptionWhenTheNumberOfTroopsToTrainIsMoreThanBarracksMaxSize() {
        //Arrange
        int noOfArchersToTrain = 5;
        int noOfBarbarianToTrain = 6;
        int maxSize = 10;
        Barracks barracks = new Barracks(maxSize, 0, 0);
        //Act && Assert
        Assertions.assertThrows(BarracksFullException.class, () -> {
            barracks.trainTheTroop(noOfArchersToTrain, noOfBarbarianToTrain);
        });
    }
}
