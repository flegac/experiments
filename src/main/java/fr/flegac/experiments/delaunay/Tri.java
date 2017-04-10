package fr.flegac.experiments.delaunay;

import java.util.HashSet;
import java.util.Set;

import fr.flegac.experiments.delaunay.VecArray.Vec;

public class Tri {
    public Tri parent;

    public Set<Tri> children = new HashSet<>();

    public final Vec a, b, c;

    public Tri ab, bc, ca;

    public static void main(String[] args) {
        VecArray array = new VecArray(10);

    }

    @Override
    public String toString() {
        return String.format("[%s %s %s]", a, b, c);
    }

    public Tri(Tri parent, Vec a, Vec b, Vec c) {
        super();
        this.parent = parent;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean contains(Vec x) {
        return TriangleUtils.inTriangle(x, a, b, c);
    }

    public void insert(Vec x) {
        for (Tri child : children) {
            if (child.contains(x)) {
                child.insert(x);
                return;
            }
        }

        Tri abx = new Tri(this, a, b, x);
        Tri bcx = new Tri(this, b, c, x);
        Tri cax = new Tri(this, c, a, x);

        abx.ab = ab;
        abx.bc = bcx;
        abx.ca = cax;

        bcx.ab = bc;
        bcx.bc = cax;
        bcx.ca = abx;

        cax.ab = ca;
        cax.bc = abx;
        cax.ca = bcx;
        if (ab != null) {
            ab.ab = abx;
        }
        if (bc != null) {
            bc.ab = bcx;
        }
        if (ca != null) {
            ca.ab = cax;
        }

        children.add(abx);
        children.add(bcx);
        children.add(cax);
    }

}
