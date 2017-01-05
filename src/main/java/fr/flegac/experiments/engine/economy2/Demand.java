package fr.flegac.experiments.engine.economy2;

import fr.flegac.experiments.engine.economy.model.production.Product;

public interface Demand {
    Product product();

    float price();

    Actor actor();
}
