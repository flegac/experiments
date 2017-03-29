package fr.flegac.experiments.projection;

public class Perspective {

    private float near;

    private float far;

    private float fov; // degrees

    public Perspective(float fov, float near, float far) {
        super();
        this.fov = fov;
        this.near = near;
        this.far = far;
    }

    public float[] mat() {
        float S = (float) (1 / Math.tan(fov * Math.PI / 360));
        float A = -far / (far - near);
        float B = -far * near / (far - near);
        return new float[] {
            S, 0, 0, 0,
            0, S, 0, 0,
            0, 0, A, -1,
            0, 0, B, 0
        };
    }

}
