package com.amaap.trainthetroop.repository.db.impl;

import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Barbarian;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    private final List<Trooper> troopers = new ArrayList<>();
    private final Queue<Trooper> barracks = new LinkedList<>();
    private final List<Trooper> armyCampTroopers = new ArrayList<>();

    @Override
    public Trooper addTrooper(Trooper trooper) {
        troopers.add(trooper);
        return trooper;
    }

    @Override
    public List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount) {
        int archer = 0;
        int barbarian = 0;
        List<Trooper> trooperToTrain = new ArrayList<>();

        for (Trooper trooper : troopers) {
            if (archer < archerCount && trooper instanceof Archer) {
                archer++;
                trooperToTrain.add(trooper);
            } else if (barbarian < barbarianCount && trooper instanceof Barbarian) {
                barbarian++;
                trooperToTrain.add(trooper);
            }

            if (archer >= archerCount && barbarian >= barbarianCount)
                break;
        }
        return trooperToTrain;
    }

    @Override
    public Queue<Trooper> addTroopersToBarrack(List<Trooper> troopers) {
        barracks.addAll(troopers);
        return barracks;
    }

    @Override
    public Queue<Trooper> getTroopersFromBarracks() {
        return barracks;
    }

    @Override
    public String addToCamp(Trooper trooper) {
        armyCampTroopers.add(trooper);
        return "Added Trooper To Army Camp";
    }

    @Override
    public List<Trooper> getTroopersFromCamp() {
        return armyCampTroopers;
    }
}
