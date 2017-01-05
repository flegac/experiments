package fr.flegac.experiments.engine.economy.engine.nation;

import fr.flegac.experiments.engine.economy.model.production.Technology;

public interface NationContext {
    void activate(Technology technology);

    boolean isAvailable(String id);
}
