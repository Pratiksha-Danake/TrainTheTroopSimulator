package com.amaap.trainthetroop.domain.model.entity;

public enum Troop {
    ARCHER, BARBARIAN;

    public static boolean notContains(Troop type) {
        for (Troop troop : Troop.values()) {
            if (troop.equals(type))
                return false;
        }
        return true;
    }
}
