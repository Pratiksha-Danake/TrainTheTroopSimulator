package com.amaap.trainthetroop.domain.model.entity;

public class TroopDataValidator {
    static boolean isInValidTime(int trainingTime) {
        if (trainingTime <= 0)
            return true;
        return false;
    }

    static boolean isInvalidTrainingCost(int trainingCost) {
        if (trainingCost <= 0)
            return true;
        return false;
    }
}
