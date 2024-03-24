package com.amaap.trainthetroop.domain.troop.validators;

import com.amaap.trainthetroop.domain.troop.model.TroopType;

public class TroopDataValidator {
    public static boolean isValidTroopType(TroopType troopType) {
        if (troopType == null || troopType.equals(""))
            return false;
        else if (!(troopType.equals(TroopType.ARCHER) || troopType.equals(TroopType.BARBARIAN)))
            return false;
        return true;
    }
}
