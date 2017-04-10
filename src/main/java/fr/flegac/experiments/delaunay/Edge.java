package fr.flegac.experiments.delaunay;

import fr.flegac.experiments.delaunay.VecArray.Vec;

public class Edge {
    private final Vec start, end;

    private Tri t1, t2;

    public Vec start() {
        return start;
    }

    public Vec end() {
        return end;
    }

    public Edge(Vec a, Vec b) {
        super();

        if (a.offset() > b.offset()) {
            this.start = b;
            this.end = a;
        }
        else {
            this.start = a;
            this.end = b;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((start == null) ? 0 : start.hashCode());
        result = prime * result + ((end == null) ? 0 : end.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Edge other = (Edge) obj;
        if (start == null) {
            if (other.start != null) {
                return false;
            }
        }
        else if (!start.equals(other.start)) {
            return false;
        }
        if (end == null) {
            if (other.end != null) {
                return false;
            }
        }
        else if (!end.equals(other.end)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", start, end);
    }

}
