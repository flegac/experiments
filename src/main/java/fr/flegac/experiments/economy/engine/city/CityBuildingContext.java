package fr.flegac.experiments.economy.engine.city;

import java.util.List;

import fr.flegac.experiments.economy.model.production.Building;

public interface CityBuildingContext {
    void plan(Building building);

    void remove(Building building);

    int count(Building building);

    List<Building> constructionPlan();
}
