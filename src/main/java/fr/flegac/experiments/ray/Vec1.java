package fr.flegac.experiments.ray;

public class Vec1 implements Vec {
    private float x, y, z;

    public Vec1(float x, float y, float z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(x);
        result = prime * result + Float.floatToIntBits(y);
        result = prime * result + Float.floatToIntBits(z);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vec1 other = (Vec1) obj;
        if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y)) {
            return false;
        }
        if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z)) {
            return false;
        }
        return true;
    }

    @Override
    public float x() {
        return x;
    }

    @Override
    public float y() {
        return y;
    }

    @Override
    public float z() {
        return z;
    }

    @Override
    public Vec copy() {
        return new Vec1(x, y, z);
    }

    @Override
    public float norm() {
        return (float) Math.sqrt(VecAPI.dot(this, this));
    }

    @Override
    public Vec add(double k, Vec u) {
        x += k * u.x();
        y += k * u.y();
        z += k * u.z();
        return this;
    }

    @Override
    public String toString() {
        return "Vec [" + x + ", " + y + ", " + z + "]";
    }

    @Override
    public Vec normalize() {
        double norm = norm();
        x /= norm;
        y /= norm;
        z /= norm;

        return this;
    }

}
