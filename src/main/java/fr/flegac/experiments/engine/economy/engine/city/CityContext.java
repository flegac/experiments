package fr.flegac.experiments.engine.economy.engine.city;

public interface CityContext {
    float money();

    void addMoney(float amount);

    CityBuildingContext buildings();

    CityProductContext products();
}
