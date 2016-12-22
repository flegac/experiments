package fr.flegac.experiments.ui.policies;

import fr.flegac.experiments.ui.context.UIContext;
import fr.flegac.experiments.ui.context.model.Viewport;
import fr.flegac.experiments.ui.model.components.box.UIBox;

public class DefaultBoxLayoutPolicy implements BoxLayoutPolicy {

    @Override
    public void update(UIContext context, UIBox box) {
        Viewport parentVP = context.getViewport(box.id);
        for (String id : box.components) {
            context.getViewport(id).computeFrom(parentVP);
        }
    }

}
