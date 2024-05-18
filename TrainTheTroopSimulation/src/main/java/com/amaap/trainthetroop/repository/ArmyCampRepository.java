package com.amaap.trainthetroop.repository;

import com.amaap.trainthetroop.domain.model.entity.Troop;
import com.amaap.trainthetroop.domain.model.entity.Trooper;

import java.util.List;

public interface ArmyCampRepository {
    String addToCamp(Trooper trooper);

    List<Trooper> getTroopers();

    int getCountOfTrooper(Troop troop);
}
