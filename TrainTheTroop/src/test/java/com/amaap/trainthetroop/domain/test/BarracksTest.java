package com.amaap.trainthetroop.domain.test;

import com.amaap.trainthetroop.domain.Barracks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BarracksTest {
    @Test
    void shouldAbleToSetMaximumSeatCapacityOfBarracks() {
        //Arrange
        int maxSeatCapacity = 10;
        int expectedMaxCapacity = 10;
        Barracks barracks = new Barracks(maxSeatCapacity);
        //Act
        int actualMaxCapacity = barracks.getMaxCapacity();
        //Assert
        Assertions.assertEquals(expectedMaxCapacity, actualMaxCapacity);
    }
    
}
