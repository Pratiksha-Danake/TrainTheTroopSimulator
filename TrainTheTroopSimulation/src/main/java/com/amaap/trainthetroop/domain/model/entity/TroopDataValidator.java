package com.amaap.trainthetroop.domain.model.entity;

public class TroopDataValidator {
    static boolean isInValidTime(int trainingTime) {
        return trainingTime <= 0;
    }

    static boolean isInvalidTrainingCost(int trainingCost) {
        return trainingCost <= 0;
    }

    static boolean isInValidWeapon(String weapon) {
        return weapon == null || weapon.isBlank();
    }
}
