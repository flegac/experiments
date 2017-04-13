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

    public Set<Edge> edges = new HashSet<>();

    private Edge bottom;

    public Triangulation(PointCloud points, int start, int end) {
        super();
        bottom = leftBottom(EdgeFactory.triangle(points, start, end));
        edges.add(bottom);
        edges.add(bottom.inner);
        edges.add(bottom.inner.inner);
    }

    public static Triangulation merge(Triangulation left, Triangulation right) {
        // merge
        Set<Edge> edges = new HashSet<>();

        Edge l = left.rightBottom(left.bottom);
        Edge r = right.leftBottom(right.bottom);

        while (!TriangleUtils.goodTriangle(l.origin, r.origin, l.right.origin)) {
            l = l.right;
        }
        while (!TriangleUtils.goodTriangle(l.origin, r.origin, r.left.origin)) {
            r = r.left;
        }

        do {
            boolean lastL = EdgeUtil.isLast(l);
            boolean lastR = EdgeUtil.isLast(r);
            if (lastL && lastR) {
                break;
            }

            Edge a = l;
            Edge b = r;
            Edge c;

            boolean leftSide = !lastL && (lastR || TriangleUtils.yCompare(l.origin, r.origin) <= 0);
            if (leftSide) {
                l = l.right;
                c = l;
            }
            else {
                r = r.left;
                c = r;
            }

            Edge triangle = EdgeFactory.triangle(a.origin, b.origin, c.origin);

            edges.add(triangle);
            edges.add(triangle.left);
            edges.add(triangle.right);

            // merge the triangle with existing edges
            if (leftSide) {
                triangle.left.right = c;
                c.left = triangle.left;
                b.left.right = triangle.right;
            }
            else {
                triangle.right.left = c;
                c.right = triangle.right;
                a.right.left = triangle;
            }
            triangle.left = a;
            a.right = triangle;

            triangle.right.right = b;
            b.left = triangle.right;

        }
        while (true);

        // update data
        left.edges.addAll(edges);
        left.edges.addAll(right.edges);
        left.bottom = TriangleUtils.yxCompare(left.bottom.origin, right.bottom.origin) <= 0
            ? left.bottom
            : right.bottom;

        // left.leftBottom(left.bottom);

        return left;
    }

    private Edge leftBottom(Edge edge) {
        Edge left = edge.left;

        Vec a = edge.origin;
        Vec b = left.origin;

        if (TriangleUtils.yxCompare(a, b) < 0) {
            return edge;
        }

        return leftBottom(left);

    }

    private Edge rightBottom(Edge edge) {
        Edge right = edge.right;

        Vec a = edge.origin;
        Vec b = right.origin;

        if (TriangleUtils.yxCompare(a, b) < 0) {
            return edge;
        }

        return rightBottom(right);
    }

}
