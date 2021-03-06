package fr.flegac.experiments.delaunay.triangulation;

import java.util.HashSet;
import java.util.Set;

import fr.flegac.experiments.delaunay.TriangleUtils;
import fr.flegac.experiments.delaunay.edge.Edge;
import fr.flegac.experiments.delaunay.edge.EdgeFactory;
import fr.flegac.experiments.delaunay.point.PointCloud;
import fr.flegac.experiments.delaunay.point.PointCloud.Vec;

public class Triangulation {

    public Set<Edge> edges = new HashSet<>();

    Edge bottom;

    public Triangulation(PointCloud points, int start, int end) {
        super();
        bottom = findBottom(EdgeFactory.triangle(points, start, end));
        edges.add(bottom);
        edges.add(bottom.inner);
        edges.add(bottom.inner.inner);
    }

    Edge findBottom(Edge edge) {
        Vec l = edge.left.origin;
        Vec r = edge.right.origin;
        int comparison = TriangleUtils.yxCompare(l, r);
        return comparison <= 0 ? _leftBottom(edge) : _rightBottom(edge);
    }

    Edge leftBottom() {
        return _leftBottom(bottom);
    }

    Edge rightBottom() {
        return _rightBottom(bottom);
    }

    Edge _leftBottom(Edge edge) {
        Edge left = edge.left;

        Vec a = edge.origin;
        Vec b = left.origin;

        if (TriangleUtils.yxCompare(a, b) < 0) {
            return edge;
        }

        return _leftBottom(left);

    }

    Edge _rightBottom(Edge edge) {
        Edge right = edge.right;

        Vec a = edge.origin;
        Vec b = right.origin;

        if (TriangleUtils.yxCompare(a, b) < 0) {
            return edge;
        }

        return _rightBottom(right);
    }
}
