package com.amaap.trainthetroop.repository.impl;

import com.amaap.trainthetroop.AppModule;
import com.amaap.trainthetroop.domain.model.entity.Archer;
import com.amaap.trainthetroop.domain.model.entity.Barbarian;
import com.amaap.trainthetroop.domain.model.entity.Trooper;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingCostException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrainingTimeException;
import com.amaap.trainthetroop.domain.model.entity.exception.InvalidTrooperWeaponException;
import com.amaap.trainthetroop.domain.service.exception.TrooperLimitExceededException;
import com.amaap.trainthetroop.service.ArmyCampService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryBarracksRepositoryTest {
    private InMemoryBarracksRepository inMemoryBarracksRepository;
    private ArmyCampService armyCampService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryBarracksRepository = injector.getInstance(InMemoryBarracksRepository.class);
        armyCampService = injector.getInstance(ArmyCampService.class);
    }

    @Test
    void shouldBeAbleToAddTroopersIntoBarrackForTraining() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException, TrooperLimitExceededException {
        // arrange
        int expectedTrooperInBarracks = 2;
        Trooper trooper1 = new Archer(6, 20, "Bow and Arrow");
        Trooper trooper2 = new Barbarian(3, 10, "Sword");

        // act
        Queue<Trooper> actualTroopersInBarracks = inMemoryBarracksRepository.addTroopersToBarracks(List.of(trooper1, trooper2));

        // assert
        assertEquals(expectedTrooperInBarracks, actualTroopersInBarracks.size());
    }


    @Test
    void shouldBeAbleToGetTroopersWaitingInQueueToTrain() throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException, InterruptedException, TrooperLimitExceededException {
        // arrange
        int expectedTroopersWaitingInQueue = 2;
        Trooper trooper1 = new Archer(6, 20, "Bow and Arrow");
        Trooper trooper2 = new Barbarian(3, 10, "Sword");

        // act
        inMemoryBarracksRepository.addTroopersToBarracks(List.of(trooper1, trooper2));
        Queue<Trooper> actualTroopersInWaitingQueue = inMemoryBarracksRepository.getTroopersInWaitingQueueToTrain();

        // assert
        assertEquals(expectedTroopersWaitingInQueue, actualTroopersInWaitingQueue.size());
    }
}