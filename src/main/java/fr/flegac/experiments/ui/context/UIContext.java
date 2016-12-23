package fr.flegac.experiments.ui.context;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.flegac.experiments.ui.context.model.Viewport;
import fr.flegac.experiments.ui.model.UIComponentSet;
import fr.flegac.experiments.ui.model.UIView;
import fr.flegac.experiments.ui.model.components.UIComponent;
import fr.flegac.experiments.ui.model.components.box.UIBox;
import fr.flegac.experiments.ui.model.components.specific.UILabel;
import fr.flegac.experiments.ui.model.components.specific.UIRessource;

public class UIContext {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Map<String, UIView> views = new HashMap<>();

    private Map<String, UIComponent> components = new HashMap<>();

    private Map<String, Viewport> viewports = new HashMap<>();

    public UIComponent get(String id) {
        return components.get(id);
    }

    public void loadComponents(String filename) throws FileNotFoundException {
        UIComponentSet componentSet = parseComponents(new FileReader(filename));
        componentSet.labels.stream().forEach(item -> {
            components.put(item.id, item);
            viewports.put(item.id, new Viewport(item));
        });
        componentSet.resources.stream().forEach(item -> {
            components.put(item.id, item);
            viewports.put(item.id, new Viewport(item));
        });
        componentSet.boxes.stream().forEach(item -> {
            components.put(item.id, item);
            viewports.put(item.id, new Viewport(item));
        });
    }

    public void loadView(String filename) throws FileNotFoundException {
        UIView view = parseView(new FileReader(filename));
        views.put(view.id, view);
    }

    public Viewport getViewport(String id) {
        return viewports.get(id);
    }

    public String serializedComponents() {
        UIComponentSet componentSet = new UIComponentSet();
        components.values().forEach(item -> {
            if (item instanceof UILabel) {
                componentSet.labels.add((UILabel) item);
            }
            else if (item instanceof UIRessource) {
                componentSet.resources.add((UIRessource) item);
            }
            else if (item instanceof UIBox) {
                componentSet.boxes.add((UIBox) item);
            }
        });
        return gson.toJson(componentSet);
    }

    private UIComponentSet parseComponents(Reader reader) {
        return gson.fromJson(reader, UIComponentSet.class);
    }

    private UIView parseView(Reader reader) {
        return gson.fromJson(reader, UIView.class);
    }

}
