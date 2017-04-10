package fr.flegac.experiments.delaunay.v2;

public abstract class PointCloud {
    protected abstract float x(int index);

    protected abstract float y(int index);

    public abstract int size();

    public Vec get(int index) {
        return new Vec(index);
    }

    public class Vec {
        int index;

        public Vec(int index) {
            super();
            this.index = index;
        }

        public float x() {
            return PointCloud.this.x(index);
        }

        public float y() {
            return PointCloud.this.y(index);
        }

        public int index() {
            return index;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + index;
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
            Vec other = (Vec) obj;
            if (!getOuterType().equals(other.getOuterType())) {
                return false;
            }
            if (index != other.index) {
                return false;
            }
            return true;
        }

        private PointCloud getOuterType() {
            return PointCloud.this;
        }

        @Override
        public String toString() {
            return "" + index;
        }

    }
}
