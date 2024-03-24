package com.amaap.trainthetroop.domain.troop.validators;

import com.amaap.trainthetroop.domain.troop.exceptions.InvalidTroopTypeException;
import com.amaap.trainthetroop.domain.troop.model.TroopType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TroopDataValidatorTest {
    @Test
    void shouldAbleToReturnFalseWhenTroopTypeIsNull() throws InvalidTroopTypeException {
        //Arrange
        TroopType troopTypeToValidate = null;
        //Act and Assert
        Assertions.assertFalse(TroopDataValidator.isValidTroopType(troopTypeToValidate));
    }

    @Test
    void shouldAbleToReturnFalseWhenTroopTypeIsOtherThanArcherAndBarbarian() {
        //Arrange
        TroopType troopTypeToValidate = TroopType.GOBLINS;
        //Act and Assert
        Assertions.assertFalse(TroopDataValidator.isValidTroopType(troopTypeToValidate));
    }
}
