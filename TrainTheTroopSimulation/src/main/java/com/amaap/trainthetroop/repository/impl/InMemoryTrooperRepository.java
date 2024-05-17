package com.amaap.trainthetroop.repository.impl;

import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.repository.TrooperRepository;
import com.amaap.trainthetroop.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

import java.util.List;

public class InMemoryTrooperRepository implements TrooperRepository {
    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryTrooperRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Trooper addTrooper(Trooper trooper) {
        return inMemoryDatabase.addTrooper(trooper);
    }

    @Override
    public List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount) {
        return inMemoryDatabase.getTroopersOfCount(archerCount, barbarianCount);
    }
}
