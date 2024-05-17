package com.amaap.trainthetroop.repository.db;

import com.amaap.trainthetroop.domain.model.entity.Trooper;

import java.util.List;

public interface InMemoryDatabase {
    Trooper addTrooper(Trooper trooper);

    List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount);
}
