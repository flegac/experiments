package fr.flegac.experiments.engine.economy.engine.trade;

import fr.flegac.experiments.engine.economy.engine.city.CityContext;
import fr.flegac.experiments.engine.economy.model.production.Product;

public interface TradeCenter {

    void offer(CityContext city, Product product, float price);

    void buy(CityContext buyer, Product product, float maxPrice);

}
