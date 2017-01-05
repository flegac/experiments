package fr.flegac.experiments.ray;

public class Ray1 implements Ray {

    private Vec origin;

    private Vec target;

    @Override
    public Vec origin() {
        return origin;
    }

    public Ray1(Vec origin, Vec target) {
        super();
        this.origin = origin;
        this.target = target;
    }

    @Override
    public Vec target() {
        return target;
    }

}
