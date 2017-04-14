package fr.flegac.experiments.delaunay.triangulation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import fr.flegac.experiments.delaunay.TriangleUtils;
import fr.flegac.experiments.delaunay.edge.Edge;
import fr.flegac.experiments.delaunay.edge.EdgeFactory;
import fr.flegac.experiments.delaunay.edge.EdgeUtil;

public class Merge {
    private Triangulation left;

    private Triangulation right;

    private Set<Edge> newEdges = new HashSet<>();

    private List<Link> links = new LinkedList<>();

    private Edge l;

    private Edge r;

    public Merge(Triangulation left, Triangulation right) {
        super();
        this.left = left;
        this.right = right;

        // init
        l = left.rightBottom(left.bottom);
        r = right.leftBottom(right.bottom);
        if (l.origin.y() < r.origin.y()) {
            while (!TriangleUtils.goodTriangle(l.origin, r.origin, l.right.origin)) {
                l = l.right;
            }
        }
        else {
            while (!TriangleUtils.goodTriangle(l.origin, r.origin, r.left.origin)) {
                r = r.left;
            }
        }
    }

    public Triangulation merge() {

        System.out.println(left.bottom.outerBox());
        System.out.println(right.bottom.outerBox());

        computeLinks();

        patchWithLinks();

        updateTriangulation();

        // System.out.println(left.bottom.outerBox());

        return left;
    }

    private void updateTriangulation() {
        left.edges.addAll(newEdges);
        left.edges.addAll(right.edges);
        left.bottom = TriangleUtils.yxCompare(left.bottom.origin, right.bottom.origin) <= 0
            ? left.bottom
            : right.bottom;
    }

    private void computeLinks() {
        do {
            boolean lastL = EdgeUtil.isLast(l);
            boolean lastR = EdgeUtil.isLast(r);
            if (lastL && lastR) {
                break;
            }

            Link link = new Link(l, r);
            links.add(link);
            l = link.nextLeft();
            r = link.nextRight();
        }
        while (true);
        links.add(new Link(l, r));
    }

    private void patchWithLinks() {
        int index = 0;
        for (Link link : links) {
            Edge edge = EdgeFactory.biEdge(link.left.origin, link.right.origin);
            newEdges.add(edge);
            if (index == 0) {
                edge.left = link.left;
                link.left.right = edge;
                edge.right.right = link.right;
                link.right.left = edge.right;
            }
            if (index == links.size() - 1) {
                edge.right = link.left;
                link.left.left = edge;
                edge.right.left = link.right;
                link.right.right = edge.right;
            }

            index++;
        }
    }

    static class Link {
        Edge left;

        Edge right;

        boolean leftSide;

        Link(Edge left, Edge right) {
            super();
            this.left = left;
            this.right = right;

            boolean lastL = EdgeUtil.isLast(left);
            boolean lastR = EdgeUtil.isLast(right);

            if (lastR) {
                leftSide = true;
            }
            else if (lastL) {
                leftSide = false;
            }
            else {
                leftSide = (TriangleUtils.yCompare(left.origin, right.origin) <= 0);
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

}
