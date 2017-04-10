package fr.flegac.experiments.delaunay.v2;

public class TestEdges {
    public static void main(String[] args) {
        PointCloud points = new PointCloud() {

            @Override
            protected float y(int index) {
                return index;
            }

            @Override
            protected float x(int index) {
                return index == 0 ? 0 : 1;
            }

            @Override
            public int size() {
                return 10;
            }
        };

        Edge t1 = Edge.triangle(points.get(0), points.get(1), points.get(2));
        Edge t2 = Edge.triangle(points.get(0), points.get(2), points.get(3));
        Edge t3 = Edge.triangle(points.get(0), points.get(3), points.get(4));

        t1.showOuterBox();
        System.out.println("-----------");

        t2.showOuterBox();
        System.out.println("-----------");

        Edge big = Edge.merge(t2, t1);

        big.showOuterBox();
        System.out.println("-----------");

        big = Edge.merge(t3, big);
        big.showOuterBox();
        System.out.println("-----------");

    }
}
