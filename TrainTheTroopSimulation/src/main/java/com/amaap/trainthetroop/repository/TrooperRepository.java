package com.amaap.trainthetroop.repository;

import com.amaap.trainthetroop.domain.model.entity.Trooper;

import java.util.List;

public interface TrooperRepository {
    Trooper addTrooper(Trooper trooperToAdd);

    List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount);
}
