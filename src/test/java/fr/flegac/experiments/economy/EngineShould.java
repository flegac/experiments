package fr.flegac.experiments.economy;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import fr.flegac.experiments.economy.engine.EngineImpl;

public class EngineShould {

    @Test
    public void loadData() throws FileNotFoundException {
        File file = new File("C:\\Users\\flegac\\git\\experiments\\src\\main\\java\\fr\\flegac\\experiments\\economy\\data");

        EngineImpl engine = new EngineImpl();
        engine.load(file);

        System.out.println("done");
    }

}
