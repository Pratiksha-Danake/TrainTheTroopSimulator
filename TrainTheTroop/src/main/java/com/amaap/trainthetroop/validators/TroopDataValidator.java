package com.amaap.trainthetroop.validators;

import com.amaap.trainthetroop.domain.TroopType;
import com.amaap.trainthetroop.exceptions.NullTroopTypeException;
import com.amaap.trainthetroop.exceptions.TroopNotAllowedException;

public class TroopDataValidator {
    public static boolean isValidTroopType(TroopType troopType) throws TroopNotAllowedException, NullTroopTypeException {
        if (troopType == null)
            throw new NullTroopTypeException("Empty troop type ");
        else if (!(troopType.equals(TroopType.ARCHER) || troopType.equals(TroopType.BARBARIAN)))
            throw new TroopNotAllowedException("troop is not allowed to train");
        return true;
    }
}
