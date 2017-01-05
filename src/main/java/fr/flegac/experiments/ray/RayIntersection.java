package fr.flegac.experiments.ray;

public class RayIntersection {
    private Vec O, A, B;

    private float r;

    public RayIntersection(Sphere sphere, Ray ray) {
        O = sphere.center();
        A = ray.origin().copy().add(-1, O);
        B = ray.target().copy().add(-1, O);
        r = sphere.radius();
    }

    /**
     * Looking for intersection M:(x,y,z) between the sphere and the ray
     *
     * u = vector(AB)
     *
     * ray: M = A + k * AB
     *
     * sphere: x^2 + y^2 + z^2 = r^2
     *
     * (ax + k * ux)^2 + (ay + k * uy)^2 + (az + k * uz)^2 = r^2
     *
     * (U*U) * kk + (2*A*U) * k + (A*A - r^2) = 0
     *
     *
     */
    public Vec intersection() {
        Vec AB = VecAPI.vec(A, B);

        float a = VecAPI.dot(AB, AB);
        float b = 2 * VecAPI.dot(A, AB);
        float c = VecAPI.dot(A, A) - r * r;

        double[] k = solve(a, b, c);

        Vec[] M = {
            A.copy().add(k[0], AB).add(1, O),
            A.copy().add(k[1], AB).add(1, O)
        };
        // System.out.println("AB = " + AB);
        // System.out.println("r = " + r);
        // System.out.println(String.format("%05.5f %s", k[0], M[0]));
        // System.out.println(String.format("%05.5f %s", k[1], M[1]));
        return VecAPI.dist(A, M[0]) < VecAPI.dist(A, M[1]) ? M[0] : M[1];
    }

    private static double[] solve(double a, double b, double c) {

        // solve quadratic equation
        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            throw new RuntimeException("no intersection");
        }

        if (delta == 0) {
            return new double[] {
                -b / (2 * a),
                -b / (2 * a)
            };
        }

        double deltaRoot = Math.sqrt(delta);
        return new double[] {
            (-b + deltaRoot) / (2 * a),
            (-b - deltaRoot) / (2 * a)
        };
    }

}
