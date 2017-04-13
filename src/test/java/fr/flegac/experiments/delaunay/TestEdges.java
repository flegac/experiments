package fr.flegac.experiments.delaunay;

import fr.flegac.experiments.delaunay.v2.edge.Edge;
import fr.flegac.experiments.delaunay.v2.edge.EdgeFactory;
import fr.flegac.experiments.delaunay.v2.point.ArrayPointCloud;
import fr.flegac.experiments.delaunay.v2.point.PointCloud;

public class TestEdges {
    public static void main(String[] args) {
        PointCloud points = new ArrayPointCloud(12);

        Edge t0 = EdgeFactory.triangle(0, 3);
        Edge t1 = EdgeFactory.triangle(3, 6);
        Edge t2 = EdgeFactory.triangle(6, 9);
        Edge t3 = EdgeFactory.triangle(9, 12);

        t0.showOuterBox();
        System.out.println("-----------");
        t1.showOuterBox();
        System.out.println("-----------");
        t2.showOuterBox();
        System.out.println("-----------");
        t3.showOuterBox();
        System.out.println("-----------");

    }
}
