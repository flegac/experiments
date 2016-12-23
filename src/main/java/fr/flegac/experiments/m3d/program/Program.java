package fr.flegac.experiments.m3d.program;

import fr.flegac.experiments.m3d.context.ProgramContext;

public interface Program {
    ProgramContext context();

    void updateContext(ProgramContext context);

}
