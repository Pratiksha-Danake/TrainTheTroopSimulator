package com.amaap.trainthetroop.domain.model.entity;

public class TroopDataValidator {
    static boolean isInValidTime(int trainingTime) {
        if (trainingTime <= 0)
            return true;
        return false;
    }
}
