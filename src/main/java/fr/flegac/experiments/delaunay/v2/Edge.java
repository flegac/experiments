package fr.flegac.experiments.delaunay.v2;

import fr.flegac.experiments.delaunay.v2.PointCloud.Vec;

public class Edge {
    public Vec origin;

    public Edge inner;

    public Edge outer;

    private Edge(Vec origin) {
        this.origin = origin;
    }

    public static Edge degenerate(Vec p0, Vec p1) {
        Edge e0 = new Edge(p0);
        Edge e1 = new Edge(p1);

        e0.inner = e0.outer = e1;
        e1.inner = e1.outer = e0;
        return e0;
    }

    public void showOuterBox() {
        System.out.println(this);
        Edge x = outer;
        while (x != this) {
            System.out.println(x);
            x = x.outer;
        }

    }

    public void showInnerBox() {
        System.out.println(this);
        Edge x = inner;
        while (x != this) {
            System.out.println(x);
            x = x.inner;
        }
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
        e1.inner = e2;
        e2.inner = e0;

        e2.outer = e1;
        e1.outer = e0;
        e0.outer = e2;

        return e0;
    }

    public static Edge merge(Edge left, Edge right) {
        assert (left.inner.origin.equals(right.outer.origin));
        assert (right.origin.equals(left.inner.outer.origin));

        Edge tmp = left.inner.outer;
        left.inner.outer = right.outer;
        right.outer = tmp;

        return left.origin.index < right.origin.index ? left : right;
    }

    private static boolean needInversion(Vec p0, Vec p1, Vec p2) {
        double x1 = p1.x() - p0.x();
        double y1 = p1.y() - p0.y();

        double x2 = p2.x() - p1.x();
        double y2 = p2.y() - p0.y();

        return x1 * y2 - x2 * y1 < 0;
    }

    @Override
    public String toString() {
        return String.format("(%s : %s %s)", origin, inner.origin, outer.origin);
    }

}
