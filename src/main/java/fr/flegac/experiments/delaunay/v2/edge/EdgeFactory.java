package fr.flegac.experiments.delaunay.v2.edge;

import fr.flegac.experiments.delaunay.v2.point.PointCloud.Vec;

public class EdgeFactory {

    public static Edge triangle(int start, int end) {
        assert (end - start <= 3);
        if (end - start == 2) {
            return biEdge(start, start + 1);
        }
        return triangle(start, start + 1, start + 2);
    }

    private static Edge biEdge(int p0, int p1) {
        Edge e0 = new Edge(p0);
        Edge e1 = new Edge(p1);

        e0.inner = e0.outer = e1;
        e1.inner = e1.outer = e0;
        return e0;
    }

    private static Edge triangle(int p0, int p1, int p2) {
        Edge e0 = new Edge(p0);
        Edge e1 = new Edge(p1);
        Edge e2 = new Edge(p2);

        e0.inner = e1;
        e1.inner = e2;
        e2.inner = e0;

        e2.outer = e1;
        e1.outer = e0;
        e0.outer = e2;

        return e0;
    }

    public static Edge merge(Edge left, Edge right) {
        assert (left.origin == right.origin);

        assert (left.inner.origin == right.outer.origin);
        assert (right.origin == left.inner.outer.origin);

        Edge tmp = left.inner.outer;
        left.inner.outer = right.outer;
        right.outer = tmp;

        return left.origin <= right.origin ? left : right;
    }

    public static boolean needInversion(Vec p0, Vec p1, Vec p2) {
        double x1 = p1.x() - p0.x();
        double y1 = p1.y() - p0.y();

        double x2 = p2.x() - p1.x();
        double y2 = p2.y() - p0.y();

        return x1 * y2 - x2 * y1 < 0;
    }

}
