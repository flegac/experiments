package fr.flegac.experiments.delaunay.v2;

import fr.flegac.experiments.delaunay.v2.PointCloud.Vec;

public class Triangle {
    Vec p[] = new Vec[3];

    Triangle[] tris = new Triangle[3];

    public Triangle(Vec... points) {
        super();
        for (int i = 0; i < points.length; i++) {
            p[i] = points[i];
        }
    }

    public Vec vec(int index) {
        return p[index];
    }

    public Triangle tri(int index) {
        return tris[index];
    }

    public void setTri(int index, Triangle tri) {
        tris[index] = tri;
    }

}
