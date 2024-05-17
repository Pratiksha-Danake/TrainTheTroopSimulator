package com.amaap.trainthetroop.repository.db;

import com.amaap.trainthetroop.domain.model.entity.Trooper;

public interface InMemoryDatabase {
    Trooper add(Trooper trooper);
}
