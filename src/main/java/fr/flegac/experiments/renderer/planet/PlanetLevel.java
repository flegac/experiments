package fr.flegac.experiments.renderer.planet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlanetLevel {
    public static void main(String[] args) {

        for (int i = 0; i <= 7; i++) {
            PlanetLevel planetLevel = new PlanetLevel(i);
            System.out.println(planetLevel.stats());
            planetLevel.test();
            System.out.println();
        }

    }

    private static Path database;
    static {
        try {
            database = Files.createTempDirectory("___DATABASE___");
            System.out.println(database);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final int QUAD_NUMBER = 10;

    private static final int QUAD_VERTEX_SIZE = 20;

    private static final int SPLIT_FACTOR = 2;

    private int level;

    private int N;

    private Quad[][] quads;

    public String stats() {
        return String.format("l:%d, quad number: %d, ", level, 10 * N * N);
    }

    public PlanetLevel(int level) {
        this.level = level;
        N = (int) Math.pow(SPLIT_FACTOR, level);
        quads = new Quad[QUAD_NUMBER][N * N];

        for (int k = 0; k < QUAD_NUMBER; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int index = index(i, j);
                    quads[k][index] = new Quad(k, i, j);
                    quads[k][index].build(QUAD_VERTEX_SIZE);
                }
            }
        }
    }

    private int index(int i, int j) {
        return i * N + j;
    }

    public void load() {
        long start = System.currentTimeMillis();

        for (int k = 0; k < QUAD_NUMBER; k++) {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(computeFilename(k)));) {
                for (Quad quad : quads[k]) {
                    float[] data = (float[]) stream.readObject();
                    quad.load(data);
                }
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("load:level " + level + " : time : " + time + " ms");
    }

    public void test() {
        save();
        load();
    }

    public void save() {
        long start = System.currentTimeMillis();

        for (int k = 0; k < QUAD_NUMBER; k++) {
            try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(computeFilename(k)));) {
                for (Quad quad : quads[k]) {
                    stream.writeObject(quad.data());
                }
                stream.flush();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("save:level " + level + " : time : " + time + " ms");
    }

    private String computeFilename(int k) {
        return new File(database.toFile(), "level" + level + k).getAbsolutePath();
    }

}
