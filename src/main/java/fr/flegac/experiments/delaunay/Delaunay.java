package fr.flegac.experiments.delaunay;

import fr.flegac.experiments.delaunay.VecArray.Vec;

public class Delaunay {

    private static final int EXTRA_POINTS = 3;

    private VecArray data;

    private Tri root;

    public static void main(String[] args) {
        float[] x = {
            0, 1, 1, 2, 3, 3
        };
        float[] y = {
            0, 0, 1, .5f, 1, 0
        };
        Delaunay d = new Delaunay(x, y);

        System.out.println(d);

    }

    public Delaunay(float[] x, float[] y) {
        data = new VecArray(x.length + EXTRA_POINTS);

        float xmin = x[0];
        float xmax = x[0];
        float ymin = y[0];
        float ymax = y[0];

        for (int i = 0; i < x.length; i++) {
            Vec vec = data.get(EXTRA_POINTS + i);
            vec.setX(x[i]);
            vec.setY(y[i]);

            xmin = Math.min(xmin, x[i]);
            xmax = Math.max(xmax, x[i]);
            ymin = Math.min(ymin, y[i]);
            ymax = Math.max(ymax, y[i]);
        }

        float xrange = xmax - xmin;
        float yrange = ymax - ymin;

        data.get(0).set(xmin - 2 * xrange, ymin - 1);
        data.get(1).set(xmax + 1, ymin - 1);
        data.get(2).set(xmax + 1, ymax + 2 * yrange);

        root = new Tri(null, data.get(0), data.get(1), data.get(2));

        for (int i = 0; i < x.length; i++) {
            root.insert(data.get(EXTRA_POINTS + i));
        }

    }

}
