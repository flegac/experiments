package fr.flegac.experiments.delaunay.edge;

import fr.flegac.experiments.delaunay.TriangleUtils;
import fr.flegac.experiments.delaunay.point.PointCloud.Vec;

public class EdgeUtil {

    public static boolean isLast(Edge e) {
        Vec x = e.origin;
        Vec left = e.left.origin;
        Vec right = e.right.origin;
        return TriangleUtils.yCompare(x, left) >= 0
            && TriangleUtils.yCompare(x, right) >= 0;
    }
}
