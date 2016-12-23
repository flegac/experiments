package fr.flegac.experiments.m3d.model;

public class Face {
    private final int type;

    private final int[] vertexIds;

    public Face(int type, int... vertexIds) {
        super();
        this.type = type;
        this.vertexIds = vertexIds;
    }

    public int getType() {
        return type;
    }

    public int getVertexId(int index) {
        return vertexIds[index];
    }

}
