package fr.flegac.experiments.delaunay.v2.edge;

public class Edge {
    public int origin;

    public Edge inner;

    public Edge outer;

    Edge(int origin) {
        this.origin = origin;
    }

    public void showOuterBox() {
        System.out.println(this);
        Edge x = outer;
        while (x != this) {
            System.out.println(x);
            x = x.outer;
        }

    }

    public void showInnerBox() {
        System.out.println(this);
        Edge x = inner;
        while (x != this) {
            System.out.println(x);
            x = x.inner;
        }
    }

    @Override
    public String toString() {
        return String.format("(%s : %s %s)", origin, inner.origin, outer.origin);
    }

}
