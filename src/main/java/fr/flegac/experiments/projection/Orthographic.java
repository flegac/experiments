package fr.flegac.experiments.projection;

public class Orthographic {

    private float left;

    private float right;

    private float top;

    private float bottom;

    private float near;

    private float far;

    public Orthographic(float left, float right, float top, float bottom, float near, float far) {
        super();
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        this.near = near;
        this.far = far;
    }

    public float[] mat() {
        float A = 2 / (right - left);
        float B = -(right + left) / (right - left);
        float C = 2 / (top - bottom);
        float D = -(top + bottom) / (top - bottom);
        float E = -2 / (far - near);
        float F = -(far + near) / (far - near);
        return new float[] {
            A, 0, 0, B,
            0, C, 0, D,
            0, 0, E, F,
            0, 0, 0, 1
        };
    }

}
