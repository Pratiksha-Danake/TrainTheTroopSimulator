package com.amaap.trainthetroop.repository.db;

import com.amaap.trainthetroop.domain.model.entity.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;

import java.util.List;
import java.util.Queue;

public interface InMemoryDatabase {
    Trooper addTrooper(Trooper trooper);

    List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount);

    Queue<Trooper> addTroopersToBarrack(List<Trooper> troopers);

    Queue<Trooper> getTroopersFromBarracks();

    String addToCamp(Trooper trooper);

    List<Trooper> getTroopersFromCamp();

    int getCountOfTrooper(Troop troop);
}
