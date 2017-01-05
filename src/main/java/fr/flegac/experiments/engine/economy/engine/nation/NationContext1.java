package fr.flegac.experiments.engine.economy.engine.nation;

import java.util.HashSet;
import java.util.Set;

import fr.flegac.experiments.engine.economy.model.production.Technology;

public class NationContext1 implements NationContext {
    private Set<String> availables = new HashSet<>();

    @Override
    public boolean isAvailable(String id) {
        return availables.contains(id);
    }

    @Override
    public void activate(Technology technology) {
        availables.add(technology.id);
        availables.addAll(technology.allows);
    }

}
