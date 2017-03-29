package fr.flegac.experiments.renderer.planet;

public class Quad {
    private float[] data;

    private int k;

    private float x;

    private float y;

    public float[] data() {
        return data;
    }

    public Quad(int k, float x, float y) {
        super();
        this.k = k;
        this.x = x;
        this.y = y;
    }

    public void load(float[] data) {
        this.data = data;
    }

    public void build(int size) {
        data = new float[3 * size * size];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
    }

}
