package com.amaap.trainthetroop.repository.impl;

import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.repository.BarracksRepository;
import com.amaap.trainthetroop.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

import java.util.List;
import java.util.Queue;

public class InMemoryBarracksRepository implements BarracksRepository {
    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryBarracksRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Queue<Trooper> addTroopersToBarracks(List<Trooper> troopers) {
        return inMemoryDatabase.addTroopersToBarrack(troopers);
    }

    @Override
    public Queue<Trooper> getTroopersInWaitingQueueToTrain() {
        return inMemoryDatabase.getTroopersFromBarracks();
    }
}
