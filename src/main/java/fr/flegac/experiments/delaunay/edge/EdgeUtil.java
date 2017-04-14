package fr.flegac.experiments.delaunay.edge;

import fr.flegac.experiments.delaunay.TriangleUtils;
import fr.flegac.experiments.delaunay.point.PointCloud.Vec;

public class EdgeUtil {

    public static boolean isLast(Edge e) {
        Vec x = e.origin;
        Vec left = e.left.origin;
        Vec right = e.right.origin;
        int lCompare = TriangleUtils.yCompare(x, left);
        int rCompare = TriangleUtils.yCompare(x, right);
        return lCompare > 0
            && rCompare > 0;
    }
}
