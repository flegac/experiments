package fr.flegac.experiments.economy.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import fr.flegac.experiments.economy.model.Data;
import fr.flegac.experiments.economy.model.production.Building;
import fr.flegac.experiments.economy.model.production.EconomicEntity;
import fr.flegac.experiments.economy.model.production.Improvement;
import fr.flegac.experiments.economy.model.production.Land;
import fr.flegac.experiments.economy.model.production.Product;
import fr.flegac.experiments.economy.model.production.Technology;

public class EngineImpl implements Engine {
    private static Gson gson = new Gson();

    private Map<String, EconomicEntity> entities = new HashMap<>();

    @Override
    public void load(File file) throws FileNotFoundException {
        if (file.isFile() && file.getName().endsWith(".json")) {
            System.out.println("load : " + file.getName());
            Data data = gson.fromJson(new FileReader(file), Data.class);

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

}
