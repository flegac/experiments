package fr.flegac.experiments.m3d.model;

import java.util.ArrayList;
import java.util.List;

import fr.flegac.experiments.m3d.context.ProgramContext;
import fr.flegac.experiments.m3d.context.ProgramContext1;

public class Group {
    private ProgramContext context = new ProgramContext1();

    private List<Face> faces = new ArrayList<>();

    public ProgramContext context() {
        return context;
    }

    public List<Face> faces() {
        return faces;
    }

}
