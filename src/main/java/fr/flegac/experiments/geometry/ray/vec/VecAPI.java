package fr.flegac.experiments.geometry.ray.vec;

public class VecAPI {

    public static Vec vec(Vec origin, Vec end) {
        return end.copy().add(-1, origin);
    }

    public static float dot(Vec u, Vec v) {
        float X = u.x() * v.x();
        float Y = u.y() * v.y();
        float Z = u.z() * v.z();
        return X + Y + Z;
    }

    public static float dist(Vec u, Vec v) {
        float dx = u.x() - v.x();
        float dy = u.y() - v.y();
        float dz = u.z() - v.z();
        return dx * dx + dy * dy + dz * dz;
    }
}
