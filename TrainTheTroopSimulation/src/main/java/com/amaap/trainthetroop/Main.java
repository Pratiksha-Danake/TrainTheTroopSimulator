package com.amaap.trainthetroop;

import com.amaap.trainthetroop.controller.ArmyCampController;
import com.amaap.trainthetroop.controller.BarracksController;
import com.amaap.trainthetroop.controller.TrooperController;
import com.amaap.trainthetroop.domain.model.valueobject.Troop;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TrooperController trooperController;
        BarracksController barracksController;
        ArmyCampController armyCampController;

        Injector injector = Guice.createInjector(new AppModule());
        trooperController = injector.getInstance(TrooperController.class);
        barracksController = injector.getInstance(BarracksController.class);
        armyCampController = injector.getInstance(ArmyCampController.class);
        for (int i = 1; i < 5; i++) {
            trooperController.createTrooper(Troop.ARCHER, 6, 20, "Bow And Arrow");
            trooperController.createTrooper(Troop.BARBARIAN, 3, 10, "Sword");
        }
        barracksController.addTroopersToBarrack(5, 5);
        barracksController.trainTheTroop();
        int archerInArmyCamp = armyCampController.getCountOfTrooper(Troop.ARCHER);
        int barbarianInArmyCamp = armyCampController.getCountOfTrooper(Troop.ARCHER);
        System.out.println("No. of Archers Available In Army Camp = " + archerInArmyCamp + "\n" +
                "No. of Barbarian Available In Army Camp = " + barbarianInArmyCamp);

    }
}
