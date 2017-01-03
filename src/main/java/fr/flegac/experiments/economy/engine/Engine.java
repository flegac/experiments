package fr.flegac.experiments.economy.engine;

import java.io.File;
import java.io.FileNotFoundException;

import fr.flegac.experiments.economy.model.production.Building;
import fr.flegac.experiments.economy.model.production.EconomicEntity;
import fr.flegac.experiments.economy.model.production.Improvement;
import fr.flegac.experiments.economy.model.production.Land;
import fr.flegac.experiments.economy.model.production.Product;
import fr.flegac.experiments.economy.model.production.Technology;

public interface Engine {
    EconomicEntity get(String id);

    Land land(String id);

    Building building(String id);

    Improvement improvement(String id);

    Technology technology(String id);

    Product product(String id);

    void load(File root) throws FileNotFoundException;

    void register(EconomicEntity entity);

}
