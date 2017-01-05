package fr.flegac.experiments.engine;

import fr.flegac.experiments.engine.handler.DirectiveHandler;
import fr.flegac.experiments.engine.updater.EconomySystem;
import fr.flegac.experiments.engine.updater.EngineConnection;
import fr.flegac.experiments.engine.updater.MilitarySystem;

public class Engine {
    EngineConnection master;

    DirectiveHandler eventHandler;

    EconomySystem economy;

    MilitarySystem military;

    public void update(double deltaTimeMs) {
        synchronize();
        eventHandler.execute(this);
        economy.update(deltaTimeMs);
        military.update(deltaTimeMs);
    }

    void synchronize() {
        if (master == null) {
            return;
        }
        master.request("/state/planet");
        master.request("/state/cache");
    }

}
