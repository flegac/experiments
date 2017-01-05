package fr.flegac.experiments.engine.economy.engine.city;

import fr.flegac.experiments.engine.economy.model.production.Product;

public interface CityProductContext {

    void add(Product product);

    void remove(Product product);

    int count(Product product);
}
