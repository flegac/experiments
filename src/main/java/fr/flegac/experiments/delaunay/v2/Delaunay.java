package fr.flegac.experiments.delaunay.v2;

public class Delaunay {
    private SortedPointCloud points;

    private Triangulation triangulation;

    public Delaunay(PointCloud points) {
        this.points = new SortedPointCloud(points);
        this.points.sort((a, b) -> {
            int x = (int) Math.signum(a.x() - b.x());
            if (x != 0) {
                return x;
            }
            return (int) Math.signum(a.y() - b.y());
        });
    }

    public Triangulation result() {
        return triangulation;
    }

    public void triangulate() {
        triangulation = triangulate(0, points.size());
    }

    private Triangulation triangulate(int indexStart, int indexEnd) {
        if (indexEnd - indexStart > 3) {
            int middle = indexStart + (indexEnd - indexStart) / 2;
            return Triangulation.merge(triangulate(indexStart, middle), triangulate(middle, indexEnd));
        }

        return new Triangulation(points, indexStart, indexEnd);
    }

}
