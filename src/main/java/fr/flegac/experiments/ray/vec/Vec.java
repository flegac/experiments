package fr.flegac.experiments.ray.vec;

public interface Vec {
    float x();

    float y();

    float z();

    Vec copy();

    float norm();

    Vec add(double k, Vec u);

    Vec normalize();
}
