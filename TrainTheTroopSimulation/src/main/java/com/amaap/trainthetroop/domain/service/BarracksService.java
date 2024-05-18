package com.amaap.trainthetroop.domain.service;

import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.repository.BarracksRepository;
import com.amaap.trainthetroop.service.ArmyCampService;
import com.amaap.trainthetroop.service.TrooperService;
import com.google.inject.Inject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BarracksService {
    private final BarracksRepository barrackRepository;
    private final TrooperService trooperService;

    private final ArmyCampService armyCampService;

    Queue<Trooper> waitingTroopers = new LinkedList<>();

    @Inject
    public BarracksService(BarracksRepository barrackRepository, TrooperService trooperService, ArmyCampService armyCampService) {
        this.trooperService = trooperService;
        this.barrackRepository = barrackRepository;
        this.armyCampService = armyCampService;
    }

    public Queue<Trooper> addTroopersToBarrack(int archerCount, int barbarianCount) {
        List<Trooper> troopers = trooperService.getTroopersOfCount(archerCount, barbarianCount);
        waitingTroopers.addAll(troopers);
        return barrackRepository.addTroopersToBarracks(troopers);
    }

    public synchronized void trainTheTroop() throws InterruptedException {
        Queue<Trooper> troopers = barrackRepository.getTroopersInWaitingQueueToTrain();
        Iterator<Trooper> iterator = troopers.iterator();

        while (iterator.hasNext()) {
            Trooper trooper = iterator.next();
            Thread.sleep(trooper.getTrainingTime() * 1000L);
            System.out.println("Trained One " + (trooper instanceof Archer ? "Archer" : "Barbarian"));
            armyCampService.addTroopToCamp(trooper);
            iterator.remove();
        }
    }
}
