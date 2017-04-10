package fr.flegac.experiments.delaunay.v2;

import java.util.Arrays;
import java.util.Comparator;

public class SortedPointCloud extends PointCloud {
    private PointCloud delegate;

    @Override
    protected float x(int index) {
        return delegate.x(permutation[index]);
    }

    @Override
    protected float y(int index) {
        return delegate.y(permutation[index]);
    }

    @Override
    public int size() {
        return delegate.size();
    }

    private Integer[] permutation;

    public SortedPointCloud(PointCloud delegate) {
        super();
        this.delegate = delegate;
        permutation = new Integer[delegate.size()];
        for (int i = 0; i < permutation.length; i++) {
            permutation[i] = i;
        }
    }

    public void sort(Comparator<Vec> comparator) {
        Arrays.sort(permutation, (Integer a, Integer b) -> comparator.compare(get(a), get(b)));
    }

}
