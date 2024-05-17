package com.amaap.trainthetroop.domain.service;

import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.repository.BarracksRepository;
import com.amaap.trainthetroop.service.TrooperService;
import com.google.inject.Inject;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BarracksService {
    Queue<Trooper> waitingTroopers = new LinkedList<>();
    private final BarracksRepository barrackRepository;
    private final TrooperService trooperService;

    @Inject
    public BarracksService(BarracksRepository barrackRepository, TrooperService trooperService) {
        this.trooperService = trooperService;
        this.barrackRepository = barrackRepository;
    }

    public Queue<Trooper> getTroopersToTrain(int archerCount, int barbarianCount) {
        List<Trooper> troopers = trooperService.getTroopersOfCount(archerCount, barbarianCount);
        waitingTroopers.addAll(troopers);
        return waitingTroopers;
    }
}
