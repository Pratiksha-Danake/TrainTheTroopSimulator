package com.amaap.trainthetroop.validators.test;

import com.amaap.trainthetroop.domain.TroopType;
import com.amaap.trainthetroop.exceptions.InvalidTroopTypeException;
import com.amaap.trainthetroop.validators.TroopDataValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TroopDataValidatorTest {
    @Test
    void shouldAbleToThrowTroopNotAllowedExceptionWhenTroopTypeIsOtherThanArcherAndBarbarian() {
        //Arrange
        TroopType troopTypeToValidate = TroopType.GOBLINS;
        //Act and Assert
        Assertions.assertThrows(InvalidTroopTypeException.class, () -> TroopDataValidator.isValidTroopType(troopTypeToValidate));
    }

    @Test
    void shouldAbleToThrowExceptionNullTroopTypeExceptionWhenTroopTypeIsNull() {
        //Arrange
        TroopType troopTypeToValidate = null;
        //Act and Assert
        Assertions.assertThrows(InvalidTroopTypeException.class, () -> TroopDataValidator.isValidTroopType(troopTypeToValidate));
    }
}
