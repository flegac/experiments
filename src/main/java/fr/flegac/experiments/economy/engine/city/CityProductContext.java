package fr.flegac.experiments.economy.engine.city;

import fr.flegac.experiments.economy.model.production.Product;

public interface CityProductContext {

    void add(Product product);

    void remove(Product product);

    int count(Product product);
}
