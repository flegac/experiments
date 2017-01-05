package fr.flegac.experiments.engine.economy2;

public interface TradeCenter {

    void register(Offer offer);

    void register(Demand demand);

    void resolve();

}
