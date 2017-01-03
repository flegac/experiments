package fr.flegac.experiments.economy;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import fr.flegac.experiments.economy.engine.Engine;
import fr.flegac.experiments.economy.engine.Engine1;
import fr.flegac.experiments.economy.engine.nation.NationContext;
import fr.flegac.experiments.economy.engine.nation.NationContext1;

public class EngineShould {

    @Test
    public void loadData() throws FileNotFoundException {
        File file = new File("C:\\Users\\flegac\\git\\experiments\\src\\main\\java\\fr\\flegac\\experiments\\economy\\_data");

        Engine engine = new Engine1();
        engine.load(file);

        System.out.println("done");

        NationContext context = new NationContext1();
        context.activate(engine.technology("tech0"));
        context.activate(engine.technology("tech1"));

        System.out.println("technologies : ");
        engine.technologies().stream().filter(item -> context.isAvailable(item.id)).forEach(item -> System.out.println("\t" + item));
        System.out.println("buildings : ");
        engine.buildings().stream().filter(item -> context.isAvailable(item.id)).forEach(item -> System.out.println("\t" + item));
        System.out.println("improvements : ");
        engine.improvements().stream().filter(item -> context.isAvailable(item.id)).forEach(item -> System.out.println("\t" + item));

    }

}
