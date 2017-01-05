package fr.flegac.experiments.engine.economy.engine.city;

import java.util.HashMap;
import java.util.Map;

import fr.flegac.experiments.engine.economy.model.production.Product;

public class CityProductContext1 implements CityProductContext {
    private Map<String, Integer> products = new HashMap<>();

    @Override
    public void add(Product product) {
        int value = count(product);
        products.put(product.id, value + 1);
    }

    @Override
    public void remove(Product product) {
        int value = count(product);
        products.put(product.id, value - 1);
    }

    @Override
    public int count(Product product) {
        if (!products.containsKey(product.id)) {
            products.put(product.id, 0);
        }
        return products.get(product.id);
    }

}
