package fr.flegac.experiments.delaunay.triangulation;

import fr.flegac.experiments.delaunay.TriangleUtils;
import fr.flegac.experiments.delaunay.edge.Edge;
import fr.flegac.experiments.delaunay.edge.EdgeUtil;

class MergeLink {
    Edge left, right;

    Edge lCandidate, rCandidate;

    Edge selected;

    MergeLink(Edge left, Edge right) {
        super();
        this.left = left;
        this.right = right;
        computeSelected();
    }

    private void computeSelected() {
        lCandidate = computeLeftCandidate();
        rCandidate = computeRightCandidate();

        if (lCandidate != null && rCandidate != null) {
            // boolean circleCheck = TriangleUtils.inCircle(left.origin,
            // right.origin, rCandidate.origin, lCandidate.origin);
            boolean yCheck = TriangleUtils.yCompare(lCandidate.origin, rCandidate.origin) <= 0;

            selected = yCheck
                ? lCandidate
                : rCandidate;
        }
        else {
            selected = lCandidate != null ? lCandidate : rCandidate;
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
        return lCandidate == selected ? lCandidate : left;
    }

    Edge nextRight() {
        return rCandidate == selected ? rCandidate : right;
    }

    @Override
    public String toString() {
        return String.format("link(%s %s)", left.origin, right.origin);
    }

}