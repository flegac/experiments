package fr.flegac.experiments.delaunay.triangulation;

import java.util.HashSet;
import java.util.Set;

import fr.flegac.experiments.delaunay.TriangleUtils;
import fr.flegac.experiments.delaunay.edge.Edge;
import fr.flegac.experiments.delaunay.edge.EdgeFactory;
import fr.flegac.experiments.delaunay.edge.EdgeUtil;
import fr.flegac.experiments.delaunay.point.PointCloud;
import fr.flegac.experiments.delaunay.point.PointCloud.Vec;

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
        PointCloud _points = left.points;

        // merge
        Set<Edge> edges = new HashSet<>();

        Edge l = left.rightBottom(left.bottom);
        Edge r = right.leftBottom(right.bottom);

        do {
            if (EdgeUtil.isLast(_points, l) && EdgeUtil.isLast(_points, r)) {
                break;
            }

            int a = l.origin;
            int b = r.origin;
            int c;

            if (EdgeUtil.isLast(_points, l)) {
                r = r.left;
                c = r.origin;
            }
            else if (EdgeUtil.isLast(_points, r)) {
                l = l.right;
                c = l.origin;
            }
            else {
                if (TriangleUtils.yCompare(_points.get(l.origin), _points.get(r.origin)) <= 0) {
                    l = l.right;
                    c = l.origin;
                }
                else {
                    r = r.left;
                    c = r.origin;
                }
            }

            Edge triangle = EdgeFactory.triangle(a, b, c);

            edges.add(triangle);
            edges.add(triangle.left);
            edges.add(triangle.right);
        }
        while (true);

        // update data
        left.edges.addAll(edges);
        left.edges.addAll(right.edges);
        left.bottom = TriangleUtils.yxCompare(
            _points.get(left.bottom.origin),
            _points.get(right.bottom.origin)) <= 0
                ? left.bottom
                : right.bottom;

        // left.leftBottom(left.bottom);

        return left;
    }

    private static Edge next(PointCloud _points, Edge l, Edge r) {
        int a = l.origin;
        int b = r.origin;
        int c;

        if (TriangleUtils.yCompare(_points.get(l.origin), _points.get(r.origin)) <= 0) {
            l = l.right;
            c = l.origin;
        }
        else {
            r = r.left;
            c = r.origin;
        }
        return EdgeFactory.triangle(a, b, c);
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
