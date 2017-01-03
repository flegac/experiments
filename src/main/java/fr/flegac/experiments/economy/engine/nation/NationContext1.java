package fr.flegac.experiments.economy.engine.nation;

import java.util.HashSet;
import java.util.Set;

import fr.flegac.experiments.economy.model.production.Technology;

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
