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
        Edge l = left.rightBottom(left.bottom);
        Edge r = right.leftBottom(right.bottom);
        Edge newEdge = EdgeFactory.biEdge(l.origin, r.origin);

        left.edges.add(newEdge);

        // update data
        left.edges.addAll(right.edges);
        left.bottom = left.leftBottom(left.bottom);
        return left;
    }

    private Edge leftBottom(Edge edge) {
        Edge left = edge.left;

        Vec a = points.get(edge.origin);
        Vec b = points.get(left.origin);

        if (TriangleUtils.yxCompare(a, b) < 0) {
            return edge;
        }

        return leftBottom(left);

    }

    private Edge rightBottom(Edge edge) {
        Edge right = edge.right;

        Vec a = points.get(edge.origin);
        Vec b = points.get(right.origin);

        if (TriangleUtils.yxCompare(a, b) < 0) {
            return edge;
        }

        return rightBottom(right);
    }

}
