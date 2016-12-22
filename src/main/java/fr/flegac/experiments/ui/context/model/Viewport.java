package fr.flegac.experiments.ui.context.model;

import fr.flegac.experiments.ui.model.components.UIComponent;

public class Viewport {
    private int[] values = new int[4];

    private int[] targetValues = new int[4];

    private boolean[] relative = new boolean[4];

    public Viewport(UIComponent component) {
        targetValues[0] = Integer.parseInt(component.viewport.x);
        targetValues[1] = Integer.parseInt(component.viewport.y);
        targetValues[2] = Integer.parseInt(component.viewport.w);
        targetValues[3] = Integer.parseInt(component.viewport.h);

        relative[0] = component.viewport.x.endsWith("%");
        relative[1] = component.viewport.y.endsWith("%");
        relative[2] = component.viewport.w.endsWith("%");
        relative[3] = component.viewport.h.endsWith("%");
    }

    public void computeFrom(Viewport parent) {
        for (int i = 0; i < values.length; i++) {
            values[i] = relative[i] ? parent.values[i] * targetValues[i] / 100 : targetValues[i];
        }
    }

    public void scale(float widthRatio, float heightRatio) {
        values[2] *= widthRatio;
        values[3] *= heightRatio;
    }

    public int x() {
        return values[0];
    }

    public int y() {
        return values[1];
    }

    public int w() {
        return values[2];
    }

    public int h() {
        return values[3];
    }

}
