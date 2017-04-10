package fr.flegac.experiments.delaunay;

import java.util.HashSet;
import java.util.Set;

import fr.flegac.experiments.delaunay.VecArray.Vec;

public class Delaunay {

    private static final int EXTRA_POINTS = 3;

    private VecArray data;

    private Tri root;

    private boolean isFinal(Tri tri) {
        boolean isBorder = tri.a.offset() >= EXTRA_POINTS
            && tri.b.offset() >= EXTRA_POINTS
            && tri.c.offset() >= EXTRA_POINTS;

        return tri.children.isEmpty();// && isBorder;
    }

    public Set<Edge> edges() {
        Set<Tri> triangles = triangles();

        Set<Edge> edges = new HashSet<>();
        triangles.forEach(tri -> {
            edges.add(new Edge(tri.a, tri.b));
            edges.add(new Edge(tri.b, tri.c));
            edges.add(new Edge(tri.c, tri.a));
        });

        return edges;
    }

    public Set<Tri> triangles() {
        Set<Tri> tris = new HashSet<>();
        updateTris(root, tris);
        return tris;
    }

    private void updateTris(Tri tri, Set<Tri> triangles) {
        if (isFinal(tri)) {
            triangles.add(tri);
        }

        tri.children.forEach(child -> updateTris(child, triangles));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        triangles().forEach(tri -> builder.append(tri));
        builder.append("\n");
        edges().forEach(edge -> builder.append(edge));
        return builder.toString();
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

        float xrange = 2 + xmax - xmin;
        float yrange = 2 + ymax - ymin;

        data.get(0).set(xmin - 2 * xrange, ymin - 1);
        data.get(1).set(xmax + 1, ymin - 1);
        data.get(2).set(xmax + 1, ymax + 2 * yrange);

        root = new Tri(null, data.get(0), data.get(1), data.get(2));

        for (int i = 0; i < x.length; i++) {
            root.insert(data.get(EXTRA_POINTS + i));
        }

    }

}
