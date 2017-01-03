package fr.flegac.experiments.economy.engine.nation;

import fr.flegac.experiments.economy.model.production.Technology;

public interface NationContext {
    void activate(Technology technology);

    boolean isAvailable(String id);
}
