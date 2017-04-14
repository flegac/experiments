package fr.flegac.experiments.delaunay.edge;

import fr.flegac.experiments.delaunay.point.PointCloud;
import fr.flegac.experiments.delaunay.point.PointCloud.Vec;

public class EdgeFactory {

    public static Edge triangle(PointCloud points, int start, int end) {
        assert (end - start <= 3);
        if (end - start == 2) {
            return biEdge(points.get(start), points.get(start + 1));
        }
        return triangle(points.get(start), points.get(start + 1), points.get(start + 2));
    }

    public static Edge biEdge(Vec p0, Vec p1) {
        Edge e0 = new Edge(p0);
        Edge e1 = new Edge(p1);

        e0.inner = e0.left = e0.right = e1;
        e1.inner = e1.left = e1.right = e0;
        return e0;
    }

    public static Edge triangle(Vec p0, Vec p1, Vec p2) {
        if (needInversion(p0, p1, p2)) {
            Vec tmp = p1;
            p1 = p2;
            p2 = tmp;
        }

        Edge e0 = new Edge(p0);
        Edge e1 = new Edge(p1);
        Edge e2 = new Edge(p2);

        e0.inner = e1;
        e0.left = e2;
        e0.right = e1;

        e1.inner = e2;
        e1.left = e0;
        e1.right = e2;

        e2.inner = e0;
        e2.left = e1;
        e2.right = e0;

        return e0;
    }

    public static Edge merge(Edge left, Edge right) {
        assert (left.origin == right.origin);

        assert (left.inner.origin == right.left.origin);
        assert (right.origin == left.inner.left.origin);

        Edge tmp = left.inner.left;
        left.inner.left = right.left;
        right.left = tmp;

        return left.origin.index <= right.origin.index ? left : right;
    }

    public static boolean needInversion(Vec p0, Vec p1, Vec p2) {
        double x1 = p1.x() - p0.x();
        double y1 = p1.y() - p0.y();

        double x2 = p2.x() - p1.x();
        double y2 = p2.y() - p0.y();

        return x1 * y2 - x2 * y1 < 0;
    }

}
