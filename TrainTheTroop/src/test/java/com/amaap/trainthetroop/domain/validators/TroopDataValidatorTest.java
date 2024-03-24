package com.amaap.trainthetroop.domain.validators;

import com.amaap.trainthetroop.domain.TroopType;
import com.amaap.trainthetroop.domain.exceptions.InvalidTroopTypeException;
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
    void shouldAbleToThrowInvalidTroopTypeExceptionWhenTroopTypeIsNull() {
        //Arrange
        TroopType troopTypeToValidate = null;
        //Act and Assert
        Assertions.assertThrows(InvalidTroopTypeException.class, () -> TroopDataValidator.isValidTroopType(troopTypeToValidate));
    }
}
