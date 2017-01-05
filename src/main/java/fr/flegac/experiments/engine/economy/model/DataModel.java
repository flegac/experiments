package fr.flegac.experiments.engine.economy.model;

import java.util.ArrayList;
import java.util.List;

import fr.flegac.experiments.engine.economy.model.production.Building;
import fr.flegac.experiments.engine.economy.model.production.Improvement;
import fr.flegac.experiments.engine.economy.model.production.Land;
import fr.flegac.experiments.engine.economy.model.production.Product;
import fr.flegac.experiments.engine.economy.model.production.Technology;

public class DataModel {
    public List<Land> lands = new ArrayList<>();

    public List<Product> products = new ArrayList<>();

    public List<Building> buildings = new ArrayList<>();

    public List<Improvement> improvements = new ArrayList<>();

    public List<Technology> technologies = new ArrayList<>();
}
