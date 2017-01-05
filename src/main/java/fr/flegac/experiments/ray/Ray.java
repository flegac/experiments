package fr.flegac.experiments.ray;

import fr.flegac.experiments.ray.vec.Vec;

public interface Ray {
    Vec origin();

    Vec target();
}
