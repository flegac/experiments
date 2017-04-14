package fr.flegac.experiments.delaunay.triangulation;

import fr.flegac.experiments.delaunay.TriangleUtils;
import fr.flegac.experiments.delaunay.edge.Edge;
import fr.flegac.experiments.delaunay.edge.EdgeUtil;

class MergeLink {
    Edge left, right;

    Edge lCandidate, rCandidate;

    MergeLink(Edge left, Edge right) {
        super();
        this.left = left;
        this.right = right;

        lCandidate = computeLeftCandidate();
        rCandidate = computeRightCandidate();

        if (lCandidate != null && rCandidate != null) {
            // if (TriangleUtils.inCircle(lCandidate.origin, left.origin, right.origin,
            // rCandidate.origin)) {
            // rCandidate = null;
            // }
            // else {
            // lCandidate = null;
            // }

            if (TriangleUtils.yCompare(lCandidate.origin, rCandidate.origin) <= 0) {
                rCandidate = null;
            }
            else {
                lCandidate = null;
            }
        }
    }

    Edge computeRightCandidate() {
        boolean checkLast = !EdgeUtil.isLast(right);
        boolean checkTriangle = TriangleUtils.goodTriangle(left.origin, right.origin, right.left.origin);
        boolean fullCheck = checkLast && checkTriangle;

        return fullCheck ? right.left : null;
    }

    Edge computeLeftCandidate() {
        boolean checkLast = !EdgeUtil.isLast(left);
        boolean checkTriangle = TriangleUtils.goodTriangle(left.origin, right.origin, left.right.origin);
        boolean fullCheck = checkLast && checkTriangle;

        return fullCheck ? left.right : null;
    }

    Edge nextLeft() {
        return lCandidate != null ? lCandidate : left;
    }

    Edge nextRight() {
        return rCandidate != null ? rCandidate : right;
    }

    @Override
    public String toString() {
        return String.format("link(%s %s)", left.origin, right.origin);
    }

}