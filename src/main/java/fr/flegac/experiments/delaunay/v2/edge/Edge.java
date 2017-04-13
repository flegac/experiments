package fr.flegac.experiments.delaunay.v2.edge;

public class Edge {
    public int origin;

    public Edge inner;

    public Edge left;

    public Edge right;

    Edge(int origin) {
        this.origin = origin;
    }

    public void showOuterBox() {
        System.out.println(this);
        Edge x = left;
        while (x != this) {
            System.out.println(x);
            x = x.left;
        }
    }

    @Override
    public String toString() {
        return String.format("(%s : %s %s)", origin, inner.origin, left.origin);
    }

}
