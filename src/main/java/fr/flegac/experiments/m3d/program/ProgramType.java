package fr.flegac.experiments.m3d.program;

public enum ProgramType {
    VERTEX, FRAGMENT;

    public String internalName() {
        return name().toLowerCase();
    }

}
