package fr.flegac.experiments.delaunay.point;

import java.util.Random;

public class ArrayPointCloud extends PointCloud {
    private static Random rand = new Random(54);

    private Float[] x;

    private Float[] y;

    public ArrayPointCloud(int size) {
        this(new Float[size], new Float[size]);
        for (int i = 0; i < size; i++) {
            x[i] = rand.nextFloat();
            y[i] = rand.nextFloat();
        }
    }

    public ArrayPointCloud(Float[] x, Float[] y) {
        super();
        assert (x.length == y.length);
        this.x = x;
        this.y = y;
    }

    @Override
    protected float x(int index) {
        return x[index];
    }

    @Override
    protected float y(int index) {
        return y[index];
    }

    @Override
    public int size() {
        return x.length;
    }

}
