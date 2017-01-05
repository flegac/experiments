package fr.flegac.experiments.engine.economy2;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.flegac.experiments.engine.economy.model.production.Product;

public class TradeCenter1 implements TradeCenter {

    private Map<Product, List<Offer>> offers;

    private Map<Product, List<Demand>> demands;

    private void init(Product product) {
        if (!offers.containsKey(product)) {
            offers.put(product, new LinkedList<>());
        }
        if (!demands.containsKey(product)) {
            demands.put(product, new LinkedList<>());
        }
    }

    @Override
    public void register(Offer offer) {
        init(offer.product());
        offers.get(offer.product()).add(offer);
    }

    @Override
    public void register(Demand demand) {
        init(demand.product());
        demands.get(demand.product()).add(demand);
    }

    @Override
    public void resolve() {
        List<Transaction> transactions = new LinkedList<Transaction>();

        for (Product product : demands.keySet()) {
            List<Demand> sortedDemands = demands.get(product).stream()
                .sorted((a, b) -> (int) Math.signum(a.price() - b.price()))
                .collect(Collectors.toList());

            List<Offer> sortedOffers = offers.get(product).stream()
                .sorted((a, b) -> (int) Math.signum(a.price() - b.price()))
                .collect(Collectors.toList());

            for (Demand demand : sortedDemands) {

            }

        }

    }

}
