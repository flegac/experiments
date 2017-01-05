package fr.flegac.experiments.engine.handler;

import fr.flegac.experiments.engine.Engine;

public interface DirectiveHandler {

    void register(Directive directive);

    void execute(Engine engine);

}
