package fr.flegac.experiments.delaunay;

import java.util.ArrayList;
import java.util.Random;

import fr.flegac.experiments.delaunay.point.ArrayPointCloud;

public class Grid {
    private static Random rand = new Random(1);

    private ArrayList<Float> _x = new ArrayList<>();

    private ArrayList<Float> _y = new ArrayList<>();

    public Grid() {
        super();
    }

    public void create(double x, double y) {
        _x.add((float) x);
        _y.add((float) y);
    }

    public void disc(float x, float y, float radius, int n) {
        for (int i = 0; i < n; i++) {
            double alpha = i * 2 * Math.PI / n;
            create(x + Math.cos(alpha) * radius, y + Math.sin(alpha) * radius);
        }
    }

    public void square(float x, float y, float radius, int n) {
        float ux = 1f;
        float uy = 1f;
        float vx = 1f;
        float vy = -1f;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                float di = (i + 1.0f) / n;
                float dj = (j + 1.0f) / n;
                float dx = di * ux + dj * vx;
                float dy = di * uy + dj * vy;
                boolean isBorder = ((i == 0 || i == n - 1) && j % 20 == 0)
                    || ((j == 0 || j == n - 1) && i % 20 == 0);
                if (isBorder) {
                    create(x + dx * radius, y + dy * radius);
                }
            }
        }
    }

    public ArrayPointCloud cloud() {
        return new ArrayPointCloud(_x.toArray(new Float[_x.size()]),
            _y.toArray(new Float[_y.size()]));
    }

}
