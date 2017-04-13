package fr.flegac.experiments.delaunay.edge;

import fr.flegac.experiments.delaunay.TriangleUtils;
import fr.flegac.experiments.delaunay.point.PointCloud;
import fr.flegac.experiments.delaunay.point.PointCloud.Vec;

public class EdgeUtil {
    public static boolean isLast(PointCloud points, Edge e) {
        Vec x = points.get(e.origin);
        Vec left = points.get(e.left.origin);
        Vec right = points.get(e.right.origin);
        return TriangleUtils.yCompare(x, left) >= 0
            && TriangleUtils.yCompare(x, right) >= 0;
    }
}
