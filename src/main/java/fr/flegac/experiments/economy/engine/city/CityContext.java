package fr.flegac.experiments.economy.engine.city;

public interface CityContext {
    float money();

    void addMoney(float amount);

    CityBuildingContext buildings();

    CityProductContext products();
}
