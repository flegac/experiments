package fr.flegac.experiments.delaunay.v2;

import java.util.Set;

import fr.flegac.experiments.delaunay.v2.edge.Edge;
import fr.flegac.experiments.delaunay.v2.point.PointCloud;
import fr.flegac.experiments.delaunay.v2.point.PointCloud.Vec;
//github.com/flegac/experiments.git
import fr.flegac.experiments.delaunay.v2.point.SortedPointCloud;
import fr.flegac.experiments.delaunay.v2.triangulation.Triangulation;

public class Delaunay {
    private SortedPointCloud points;

    private Triangulation triangulation;

    public Set<Edge> edges() {
        return triangulation.edges;
    }

    public Vec get(int index) {
        return points.get(index);
    }

    public Delaunay(PointCloud points) {
        this.points = new SortedPointCloud(points);
        this.points.sort(TriangleUtils::xyCompare);
    }

    public Triangulation result() {
        return triangulation;
    }

    public void triangulate() {
        triangulation = triangulate(0, points.size());
    }

    private Triangulation triangulate(int start, int end) {
        if (end - start <= 3) {
            return new Triangulation(points, start, end);
        }

        int middle = start + (end - start) / 2;
        Triangulation left = triangulate(start, middle);
        Triangulation right = triangulate(middle, end);
        return Triangulation.merge(left, right);
    }

}
