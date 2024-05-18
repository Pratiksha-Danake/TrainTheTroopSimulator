package com.amaap.trainthetroop.repository;

import com.amaap.trainthetroop.domain.model.entity.Trooper;

import java.util.List;
import java.util.Queue;

public interface BarracksRepository {
    Queue<Trooper> addTroopersToBarracks(List<Trooper> troopers);

    Queue<Trooper> getTroopersInWaitingQueueToTrain();

}
