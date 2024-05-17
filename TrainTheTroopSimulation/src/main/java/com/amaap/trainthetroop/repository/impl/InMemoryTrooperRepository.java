package com.amaap.trainthetroop.repository.impl;

import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.repository.TrooperRepository;
import com.amaap.trainthetroop.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

public class InMemoryTrooperRepository implements TrooperRepository {
    private InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryTrooperRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Trooper addTrooper(Trooper trooper) {
        return inMemoryDatabase.add(trooper);
    }
}
