package fr.flegac.experiments.economy.engine.trade;

import fr.flegac.experiments.economy.engine.city.CityContext;
import fr.flegac.experiments.economy.model.production.Product;

public interface TradeCenter {

    void offer(CityContext city, Product product, float price);

    void buy(CityContext buyer, Product product, float maxPrice);

}
