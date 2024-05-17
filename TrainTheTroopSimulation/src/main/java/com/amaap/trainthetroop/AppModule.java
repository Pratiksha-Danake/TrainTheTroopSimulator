package com.amaap.trainthetroop;

import com.amaap.trainthetroop.repository.TrooperRepository;
import com.amaap.trainthetroop.repository.db.InMemoryDatabase;
import com.amaap.trainthetroop.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.trainthetroop.repository.impl.InMemoryTrooperRepository;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TrooperRepository.class).to(InMemoryTrooperRepository.class);
        bind(InMemoryDatabase.class).to(FakeInMemoryDatabase.class);
    }
}
