package fr.flegac.experiments.ui.policies;

import fr.flegac.experiments.ui.context.UIContext;
import fr.flegac.experiments.ui.model.components.box.UIBox;

public interface BoxLayoutPolicy {
    public void update(UIContext context, UIBox box);
}
