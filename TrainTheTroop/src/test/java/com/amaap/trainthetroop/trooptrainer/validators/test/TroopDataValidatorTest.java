package com.amaap.trainthetroop.trooptrainer.validators.test;

import com.amaap.trainthetroop.domain.TroopType;
import com.amaap.trainthetroop.exceptions.NullTroopTypeException;
import com.amaap.trainthetroop.exceptions.TroopNotAllowedException;
import com.amaap.trainthetroop.validators.TroopDataValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TroopDataValidatorTest {
    @Test
    void shouldAbleToThrowTroopNotAllowedExceptionWhenTrooptypeIsOtherThanArcherAndBarbarian() {
        //Arrange
        TroopType troopTypeToValidate = TroopType.GOBLINS;
        //Act and Assert
        Assertions.assertThrows(TroopNotAllowedException.class, () -> TroopDataValidator.isValidTroopType(troopTypeToValidate));
    }

    @Test
    void shouldAbleToThrowExceptionNullTroopTypeExceptionWhenTroopTypeIsNull() {
        //Arrange
        TroopType troopTypeToValidate = null;
        //Act and Assert
        Assertions.assertThrows(NullTroopTypeException.class, () ->TroopDataValidator.isValidTroopType(troopTypeToValidate));
    }
}
