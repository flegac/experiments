package fr.flegac.experiments.economy.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;

import fr.flegac.experiments.economy.model.DataModel;
import fr.flegac.experiments.economy.model.production.Building;
import fr.flegac.experiments.economy.model.production.EconomicEntity;
import fr.flegac.experiments.economy.model.production.Improvement;
import fr.flegac.experiments.economy.model.production.Land;
import fr.flegac.experiments.economy.model.production.Product;
import fr.flegac.experiments.economy.model.production.Technology;

public class Engine1 implements Engine {
    private static Gson gson = new Gson();

    private Map<String, EconomicEntity> entities = new HashMap<>();

    @Override
    public void load(File file) throws FileNotFoundException {
        if (file.isFile() && file.getName().endsWith(".json")) {
            System.out.println("load : " + file.getName());
            DataModel data = gson.fromJson(new FileReader(file), DataModel.class);

            data.lands.forEach(this::register);
            data.improvements.forEach(this::register);
            data.buildings.forEach(this::register);
            data.products.forEach(this::register);
            data.technologies.forEach(this::register);
            return;
        }

        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                load(child);
            }
        }

    }

    @Override
    public EconomicEntity get(String id) {
        return entities.get(id);
    }

    @Override
    public Land land(String id) {
        return (Land) get(id);
    }

    @Override
    public Building building(String id) {
        return (Building) get(id);
    }

    @Override
    public Improvement improvement(String id) {
        return (Improvement) get(id);
    }

    @Override
    public Product product(String id) {
        return (Product) get(id);
    }

    @Override
    public Technology technology(String id) {
        return (Technology) get(id);
    }

    @Override
    public void register(EconomicEntity entity) {
        System.out.println("\t" + entity.id);
        entities.put(entity.id, entity);

    }

    @Override
    public Set<String> getAll() {
        return entities.keySet();
    }

    @Override
    public Set<Building> buildings() {
        Set<Building> result = new HashSet<>();
        entities.values().stream().filter(item -> item instanceof Building).forEach(item -> result.add((Building) item));
        return result;
    }

    @Override
    public Set<Technology> technologies() {
        Set<Technology> result = new HashSet<>();
        entities.values().stream().filter(item -> item instanceof Technology).forEach(item -> result.add((Technology) item));
        return result;
    }

    @Override
    public Set<Product> products() {
        Set<Product> result = new HashSet<>();
        entities.values().stream().filter(item -> item instanceof Product).forEach(item -> result.add((Product) item));
        return result;
    }

    @Override
    public Set<Improvement> improvements() {
        Set<Improvement> result = new HashSet<>();
        entities.values().stream().filter(item -> item instanceof Improvement).forEach(item -> result.add((Improvement) item));
        return result;
    }

    @Override
    public Set<Land> lands() {
        Set<Land> result = new HashSet<>();
        entities.values().stream().filter(item -> item instanceof Land).forEach(item -> result.add((Land) item));
        return result;
    }

}
