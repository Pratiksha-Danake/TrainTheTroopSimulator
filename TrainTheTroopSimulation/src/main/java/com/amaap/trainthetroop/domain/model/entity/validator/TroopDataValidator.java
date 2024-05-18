package com.amaap.trainthetroop.domain.model.entity.validator;

public class TroopDataValidator {
    public static boolean isInValidTime(int trainingTime) {
        return trainingTime <= 0;
    }

    public static boolean isInvalidTrainingCost(int trainingCost) {
        return trainingCost <= 0;
    }

    public static boolean isInValidWeapon(String weapon) {
        return weapon == null || weapon.isBlank();
    }
}
