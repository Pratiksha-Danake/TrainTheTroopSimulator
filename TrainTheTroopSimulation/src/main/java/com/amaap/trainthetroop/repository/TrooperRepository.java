package com.amaap.trainthetroop.repository;

import com.amaap.trainthetroop.domain.model.entity.Trooper;

public interface TrooperRepository {
    Trooper addTrooper(Trooper trooperToAdd);
}
