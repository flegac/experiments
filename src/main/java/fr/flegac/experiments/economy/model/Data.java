package fr.flegac.experiments.economy.model;

import java.util.ArrayList;
import java.util.List;

import fr.flegac.experiments.economy.model.production.Building;
import fr.flegac.experiments.economy.model.production.Improvement;
import fr.flegac.experiments.economy.model.production.Land;
import fr.flegac.experiments.economy.model.production.Product;
import fr.flegac.experiments.economy.model.production.Technology;

public class Data {
    public List<Land> lands = new ArrayList<>();

    public List<Product> products = new ArrayList<>();

    public List<Building> buildings = new ArrayList<>();

    public List<Improvement> improvements = new ArrayList<>();

    public List<Technology> technologies = new ArrayList<>();
}
