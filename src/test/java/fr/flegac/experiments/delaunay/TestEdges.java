package fr.flegac.experiments.delaunay;

import fr.flegac.experiments.delaunay.edge.Edge;
import fr.flegac.experiments.delaunay.edge.EdgeFactory;
import fr.flegac.experiments.delaunay.point.ArrayPointCloud;
import fr.flegac.experiments.delaunay.point.PointCloud;

public class TestEdges {
    public static void main(String[] args) {
        PointCloud points = new ArrayPointCloud(12);

        Edge t0 = EdgeFactory.triangle(points, 0, 3);
        Edge t1 = EdgeFactory.triangle(points, 3, 6);
        Edge t2 = EdgeFactory.triangle(points, 6, 9);
        Edge t3 = EdgeFactory.triangle(points, 9, 12);

        System.out.println(t0.outerBox());
        System.out.println("-----------");
        System.out.println(t1.outerBox());
        System.out.println("-----------");
        System.out.println(t2.outerBox());
        System.out.println("-----------");
        System.out.println(t3.outerBox());
        System.out.println("-----------");

    }
}
