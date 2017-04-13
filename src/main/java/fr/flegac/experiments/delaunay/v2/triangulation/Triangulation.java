package fr.flegac.experiments.delaunay.v2.triangulation;

import java.util.HashSet;
import java.util.Set;

import fr.flegac.experiments.delaunay.v2.TriangleUtils;
import fr.flegac.experiments.delaunay.v2.edge.Edge;
import fr.flegac.experiments.delaunay.v2.edge.EdgeFactory;
import fr.flegac.experiments.delaunay.v2.point.PointCloud;
import fr.flegac.experiments.delaunay.v2.point.PointCloud.Vec;

public class Triangulation {
    private PointCloud points;

    public Set<Edge> edges = new HashSet<>();

    private Edge bottom;

    public Triangulation(PointCloud points, int start, int end) {
        super();
        this.points = points;
        bottom = leftBottom(EdgeFactory.triangle(start, end));
        edges.add(bottom);
        edges.add(bottom.inner);
        edges.add(bottom.inner.inner);
    }

    public static Triangulation merge(Triangulation left, Triangulation right) {
        // merge

        Edge l = left.bottom;
        Edge r = right.bottom;

        // update data
        left.edges.addAll(right.edges);
        left.bottom = left.leftBottom(left.bottom);
        return left;
    }

    private Edge rightBottom(Edge edge) {

        return null;
    }

    private Edge leftBottom(Edge edge) {
        return null;
    }

    private Edge min(Edge left, Edge right) {
        Vec a = points.get(left.origin);
        Vec b = points.get(right.origin);
        return TriangleUtils.yxCompare(a, b) <= 0 ? left : right;
    }
}
