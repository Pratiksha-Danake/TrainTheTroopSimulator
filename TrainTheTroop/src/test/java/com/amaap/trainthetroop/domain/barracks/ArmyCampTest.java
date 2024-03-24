package com.amaap.trainthetroop.domain.barracks;

import com.amaap.trainthetroop.domain.barracks.model.ArmyCamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArmyCampTest {
    @Test
    void shouldAbleToAddTrainedArchersToArmyCamp() {
        //Arrange
        int trainedArchersCount = 5;
        int trainedArcherCount = 5;
        ArmyCamp armyCamp = new ArmyCamp();
        //Act
        armyCamp.addArchers(trainedArchersCount);
        //Assert
        Assertions.assertEquals(trainedArcherCount, armyCamp.getTotalArchers());
    }

    @Test
    void shouldAbleToAddTrainedBarbarianToArmyCamp() {
        //Arrange
        int trainedBarbarianCount = 10;
        int expectedBarbarianInCamp = 10;
        ArmyCamp armyCamp = new ArmyCamp();
        //Act
        armyCamp.addArchers(trainedBarbarianCount);
        //Assert
        Assertions.assertEquals(expectedBarbarianInCamp, armyCamp.getTotalArchers());
    }
}
