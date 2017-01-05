package fr.flegac.experiments.engine.economy2;

import fr.flegac.experiments.engine.economy.model.production.Product;

public class Transaction1 implements Transaction {

    private Product product;

    private float price;

    private Actor vendor;

    private Actor buyer;

    public Transaction1(Product product, float price, Actor vendor, Actor buyer) {
        super();
        this.product = product;
        this.price = price;
        this.vendor = vendor;
        this.buyer = buyer;
    }

    @Override
    public Product product() {
        return product;
    }

    @Override
    public float price() {
        return price;
    }

    @Override
    public Actor vendor() {
        return vendor;
    }

    @Override
    public Actor buyer() {
        return buyer;
    }

}
