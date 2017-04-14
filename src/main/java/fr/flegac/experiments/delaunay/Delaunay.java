package fr.flegac.experiments.delaunay;

import java.util.Set;

import fr.flegac.experiments.delaunay.edge.Edge;
import fr.flegac.experiments.delaunay.point.PointCloud;
import fr.flegac.experiments.delaunay.point.PointCloud.Vec;
import fr.flegac.experiments.delaunay.point.SortedPointCloud;
import fr.flegac.experiments.delaunay.triangulation.Merge;
import fr.flegac.experiments.delaunay.triangulation.Triangulation;

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
        return new Merge(left, right).merge();
    }

}
