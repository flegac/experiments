package fr.flegac.experiments.delaunay.triangulation;

import fr.flegac.experiments.delaunay.TriangleUtils;
import fr.flegac.experiments.delaunay.edge.Edge;
import fr.flegac.experiments.delaunay.edge.EdgeUtil;

class MergeLink {
    Edge left;

    Edge right;

    boolean leftSide;

    MergeLink(Edge left, Edge right) {
        super();
        this.left = left;
        this.right = right;

        boolean lastL = EdgeUtil.isLast(left);
        boolean lastR = EdgeUtil.isLast(right);

        boolean leftOk = !lastL && TriangleUtils.goodTriangle(left.origin, right.origin, left.right.origin);
        boolean rightOk = !lastR && TriangleUtils.goodTriangle(left.origin, right.origin, right.left.origin);
        if (leftOk && rightOk) {
            leftSide = (TriangleUtils.yCompare(left.right.origin, right.left.origin) <= 0);
        }
        else {
            leftSide = leftOk;
        }

    }

    Edge nextLeft() {
        return leftSide ? left.right : left;
    }

    Edge nextRight() {
        return leftSide ? right : right.left;
    }

    @Override
    public String toString() {
        return String.format("link(%s %s)", left.origin, right.origin);
    }

}