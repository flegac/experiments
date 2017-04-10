package fr.flegac.experiments.delaunay;

import fr.flegac.experiments.delaunay.VecArray.Vec;

public class TriangleUtils {

    private static float sign(Vec a, Vec b, Vec c) {
        return (a.x() - c.x()) * (b.y() - c.y()) - (b.x() - c.x()) * (a.y() - c.y());
    }

    public static boolean inTriangle(Vec x, Vec a, Vec b, Vec c) {
        boolean b1 = sign(x, a, b) < 0;
        boolean b2 = sign(x, b, c) < 0;
        boolean b3 = sign(x, c, a) < 0;
        return b1 == b2 && b2 == b3;
    }

}
