package fr.flegac.experiments.delaunay.v2;

import fr.flegac.experiments.delaunay.v2.PointCloud.Vec;

public class Triangulation {
    PointCloud points;

    private Edge left;

    private Edge right;

    public Triangulation(PointCloud points, int start, int end) {
        super();
        this.points = points;

        Vec p0 = points.get(start);
        Vec p1 = points.get(start + 1);
        if (end - start == 2) {
            left = right = Edge.degenerate(p0, p1);
        }

        Vec p2 = points.get(start + 2);
        left = right = Edge.triangle(p0, p1, p2);
    }

    public static Triangulation merge(Triangulation t1, Triangulation t2) {
        return null;
    }

}
