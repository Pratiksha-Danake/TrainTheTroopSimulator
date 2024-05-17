package com.amaap.trainthetroop.util;

import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Barbarian;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;

import java.util.ArrayList;
import java.util.List;

public class TrooperBuilder {
    static List<Trooper> troopers = new ArrayList<>();

    public static List<Trooper> getTroopersToTrain() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException {
        troopers.add(new Archer(6, 20, "Bow and Arrow"));
        troopers.add(new Archer(6, 20, "Bow and Arrow"));
        troopers.add(new Archer(6, 20, "Bow and Arrow"));
        troopers.add(new Archer(6, 20, "Bow and Arrow"));
        troopers.add(new Archer(6, 20, "Bow and Arrow"));
        troopers.add(new Barbarian(3, 10, "Sword"));
        troopers.add(new Barbarian(3, 10, "Sword"));
        troopers.add(new Barbarian(3, 10, "Sword"));
        troopers.add(new Barbarian(3, 10, "Sword"));
        troopers.add(new Barbarian(3, 10, "Sword"));
        return troopers;
    }
}
