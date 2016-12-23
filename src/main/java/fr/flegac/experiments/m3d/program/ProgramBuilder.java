package fr.flegac.experiments.m3d.program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProgramBuilder {

    String[] features = {
        "camera", "light", "shadow", "normalmap"
    };

    public static void main(String[] args) {
        ProgramBuilder builder = new ProgramBuilder();

        String root = "C:\\Users\\flegac\\git\\experiments\\src\\main\\java\\fr\\flegac\\experiments\\m3d\\program\\shader";
        System.out.println(builder.build(root, ProgramType.VERTEX));

    }

    public String build(String root, ProgramType type) {
        StringBuilder builder = new StringBuilder();

        // common for main
        load(root + "/main/main.glsl", builder);

        // common for feature
        for (String feature : features) {
            load(root + "/features/" + feature + "/" + feature + ".glsl", builder);
        }
        // vertex type specific feature
        for (String feature : features) {
            load(root + "/features/" + feature + "/" + type.name() + "/" + feature + ".glsl", builder);
        }
        // vertex type specific main
        load(root + "/main/" + type.name() + "/main.glsl", builder);

        return builder.toString();
    }

    private void load(String filename, StringBuilder builder) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename));) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.startsWith("//")) {
                    continue;
                }
                builder.append(line).append(System.lineSeparator());
            }
            builder.append(System.lineSeparator());
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
