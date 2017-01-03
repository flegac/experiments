package fr.flegac.experiments.economy.engine.city;

public class CityContext1 implements CityContext {

    private float money;

    private CityProductContext products = new CityProductContext1();

    private CityBuildingContext buildings;

    @Override
    public float money() {
        return money;
    }

    @Override
    public void addMoney(float amount) {
        money += amount;
    }

    @Override
    public CityBuildingContext buildings() {
        return buildings;
    }

    @Override
    public CityProductContext products() {
        return products;
    }

}
