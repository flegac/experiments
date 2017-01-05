package fr.flegac.experiments.renderer.planet;

public interface VisibilityCheck {
    boolean isVisible(Camera camera, Quad quad);
}
