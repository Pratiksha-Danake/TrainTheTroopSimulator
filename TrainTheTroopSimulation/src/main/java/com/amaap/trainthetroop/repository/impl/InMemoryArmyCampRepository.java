package com.amaap.trainthetroop.repository.impl;

import com.amaap.trainthetroop.domain.model.entity.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.repository.ArmyCampRepository;
import com.amaap.trainthetroop.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

import java.util.List;

public class InMemoryArmyCampRepository implements ArmyCampRepository {
    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryArmyCampRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public String addToCamp(Trooper trooper) {
        return inMemoryDatabase.addToCamp(trooper);
    }

    @Override
    public List<Trooper> getTroopers() {
        return inMemoryDatabase.getTroopersFromCamp();
    }

    @Override
    public int getCountOfTrooper(Troop troop) {
        return inMemoryDatabase.getCountOfTrooper(troop);
    }
}
