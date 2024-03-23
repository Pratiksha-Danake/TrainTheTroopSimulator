package com.amaap.trainthetroop.validators;

import com.amaap.trainthetroop.domain.TroopType;
import com.amaap.trainthetroop.exceptions.InvalidTroopTypeException;

public class TroopDataValidator {
    public static boolean isValidTroopType(TroopType troopType) throws InvalidTroopTypeException {
        if (troopType == null)
            throw new InvalidTroopTypeException("troop type cannot be null");
        else if (!(troopType.equals(TroopType.ARCHER) || troopType.equals(TroopType.BARBARIAN)))
            throw new InvalidTroopTypeException("troop is not allowed to train");
        return true;
    }
}
