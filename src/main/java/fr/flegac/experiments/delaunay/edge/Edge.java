package fr.flegac.experiments.delaunay.edge;

import fr.flegac.experiments.delaunay.point.PointCloud.Vec;

public class Edge {
    public Vec origin;

    public Edge inner;

    public Edge left;

    public Edge right;

    Edge(Vec origin) {
        this.origin = origin;
    }

    public String outerBox() {

        StringBuilder builder = new StringBuilder(origin.toString());

        Edge x = this;
        do {
            x = x.right;
            builder.append(" " + x.origin);
        }
        while (x != this);

        return builder.toString();
    }

    @Override
    public String toString() {
        return String.format("(%s : %s %s)", origin, left.origin, right.origin);
    }

}
