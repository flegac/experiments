package fr.flegac.experiments.delaunay;

public class VecArray {
    private static final int DIMENSION = 2;

    private float[] data;

    public static class Vec {
        private float[] data;

        private int offset;

        public Vec(float[] data, int offset) {
            super();
            this.data = data;
            this.offset = offset;
        }

        public void set(float x, float y) {
            setX(x);
            setY(y);
        }

        public float x() {
            return data[DIMENSION * offset];
        }

        public float y() {
            return data[DIMENSION * offset + 1];
        }

        public void setX(float x) {
            data[DIMENSION * offset] = x;
        }

        public void setY(float y) {
            data[DIMENSION * offset + 1] = y;
        }

        @Override
        public String toString() {
            return String.format("(%.1f %.1f)", x(), y());
        }
    }

    public VecArray(int size) {
        data = new float[DIMENSION * size];
    }

    public Vec get(int index) {
        return new Vec(data, index);
    }

}
