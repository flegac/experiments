package fr.flegac.experiments.delaunay.v2;

import fr.flegac.experiments.delaunay.v2.point.PointCloud.Vec;

public class TriangleUtils {

    public static int xyCompare(Vec a, Vec b) {
        int x = xCompare(a, b);
        return x != 0 ? x : yCompare(a, b);
    }

    public static int yxCompare(Vec a, Vec b) {
        int y = yCompare(a, b);
        return y != 0 ? y : xCompare(a, b);
    }

    public static int xCompare(Vec a, Vec b) {
        return (int) Math.signum(a.x() - b.x());
    }

    public static int yCompare(Vec a, Vec b) {
        return (int) Math.signum(a.y() - b.y());
    }

    public static boolean inTriangle(Vec x, Vec a, Vec b, Vec c) {
        boolean b1 = sign(x, a, b) < 0;
        boolean b2 = sign(x, b, c) < 0;
        boolean b3 = sign(x, c, a) < 0;
        return b1 == b2 && b2 == b3;
    }

    public static boolean inCircle(Vec D, Vec A, Vec B, Vec C) {
        float a = A.x() - D.x();
        float b = A.y() - D.y();
        float c = A.x() * A.x() - D.x() * D.x() + A.y() * A.y() - D.y() * D.y();

        float d = B.x() - D.x();
        float e = B.y() - D.y();
        float f = B.x() * B.x() - D.x() * D.x() + B.y() * B.y() - D.y() * D.y();

        float g = C.x() - D.x();
        float h = C.y() - D.y();
        float i = C.x() * C.x() - D.x() * D.x() + C.y() * C.y() - D.y() * D.y();

        return det3(a, b, c, d, e, f, g, h, i) > 0;
    }

    private static float det3(float a, float b, float c,
        float d, float e, float f,
        float g, float h, float i) {
        return a * det2(e, f, h, i) - b * det2(d, f, g, i) + c * det2(d, e, g, h);
    }

    private static float det2(float a, float b, float c, float d) {
        return a * d - b * c;
    }

    private static float sign(Vec a, Vec b, Vec c) {
        return (a.x() - c.x()) * (b.y() - c.y()) - (b.x() - c.x()) * (a.y() - c.y());
    }
}
