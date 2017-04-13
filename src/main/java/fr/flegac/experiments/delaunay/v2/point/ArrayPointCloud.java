package fr.flegac.experiments.delaunay.v2.point;

import java.util.Random;

public class ArrayPointCloud extends PointCloud {
    private static Random rand = new Random(54);

    private float[] x;

    private float[] y;

    public ArrayPointCloud(int size) {
        this(new float[size], new float[size]);
        for (int i = 0; i < size; i++) {
            x[i] = rand.nextFloat();
            y[i] = rand.nextFloat();
        }
    }

    public ArrayPointCloud(float[] x, float[] y) {
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
