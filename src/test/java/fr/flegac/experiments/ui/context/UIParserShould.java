package fr.flegac.experiments.ui.context;

import java.io.FileNotFoundException;

import org.junit.Test;

public class UIParserShould {

    @Test
    public void generateJson() throws FileNotFoundException {
        String components = "C:\\Users\\flegac\\git\\experiments\\src\\test\\java\\fr\\flegac\\experiments\\ui\\context\\componentSet.model.json";
        String view = "C:\\Users\\flegac\\git\\experiments\\src\\test\\java\\fr\\flegac\\experiments\\ui\\context\\view.model.json";

        System.out.println(components);
        System.out.println(view);

        UIContext context = new UIContext();
        context.loadComponents(components);
        context.loadView(view);

        System.out.println(context.serializedComponents());

    }

}
