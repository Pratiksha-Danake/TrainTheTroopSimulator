package com.amaap.trainthetroop;

import com.amaap.trainthetroop.repository.ArmyCampRepository;
import com.amaap.trainthetroop.repository.BarracksRepository;
import com.amaap.trainthetroop.repository.TrooperRepository;
import com.amaap.trainthetroop.repository.db.InMemoryDatabase;
import com.amaap.trainthetroop.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.trainthetroop.repository.impl.InMemoryArmyCampRepository;
import com.amaap.trainthetroop.repository.impl.InMemoryBarracksRepository;
import com.amaap.trainthetroop.repository.impl.InMemoryTrooperRepository;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TrooperRepository.class).to(InMemoryTrooperRepository.class);
        bind(BarracksRepository.class).to(InMemoryBarracksRepository.class);
        bind(ArmyCampRepository.class).to(InMemoryArmyCampRepository.class);
        bind(InMemoryDatabase.class).to(FakeInMemoryDatabase.class).asEagerSingleton();
    }
}
