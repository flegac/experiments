package fr.flegac.experiments.engine.economy.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

import fr.flegac.experiments.engine.economy.model.production.Building;
import fr.flegac.experiments.engine.economy.model.production.EconomicEntity;
import fr.flegac.experiments.engine.economy.model.production.Improvement;
import fr.flegac.experiments.engine.economy.model.production.Land;
import fr.flegac.experiments.engine.economy.model.production.Product;
import fr.flegac.experiments.engine.economy.model.production.Technology;

public interface Economy {

    Set<Building> buildings();

    Set<Technology> technologies();

    Set<Product> products();

    Set<Improvement> improvements();

    Set<Land> lands();

    Set<String> getAll();

    EconomicEntity get(String id);

    Land land(String id);

    Building building(String id);

    Improvement improvement(String id);

    Technology technology(String id);

    Product product(String id);

    void load(File root) throws FileNotFoundException;

    void register(EconomicEntity entity);

}
