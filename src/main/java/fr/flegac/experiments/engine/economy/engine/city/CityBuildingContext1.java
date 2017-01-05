package fr.flegac.experiments.engine.economy.engine.city;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.flegac.experiments.engine.economy.model.production.Building;

public class CityBuildingContext1 implements CityBuildingContext {
    private Map<String, Integer> buildings = new HashMap<>();

    private List<Building> plan = new ArrayList<>();

    @Override
    public void plan(Building building) {
        plan.add(building);
    }

    @Override
    public void remove(Building building) {
        int value = count(building);
        buildings.put(building.id, value - 1);
    }

    @Override
    public int count(Building building) {
        if (buildings.containsKey(building.id)) {
            buildings.put(building.id, 0);
        }
        return buildings.get(building.id);
    }

    @Override
    public List<Building> constructionPlan() {
        return plan;
    }

}
