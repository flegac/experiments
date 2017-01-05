package fr.flegac.experiments.ray;

public class Sphere1 implements Sphere {

    private Vec center;

    private float radius;

    public Sphere1(Vec center, float radius) {
        super();
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Vec center() {
        return center;
    }

    @Override
    public float radius() {
        return radius;
    }

}
