package com.amaap.trainthetroop.repository.db.impl;

import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    private List<Trooper> troopers = new ArrayList<>();

    @Override
    public Trooper add(Trooper trooper) {
        troopers.add(trooper);
        return trooper;
    }
}
