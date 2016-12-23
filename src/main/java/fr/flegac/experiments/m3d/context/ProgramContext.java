package fr.flegac.experiments.m3d.context;

public interface ProgramContext {
    String normalTextureId();

    String colorTextureId();

    LightAlgorithm lightAlgorithm();

    ShadowAlgorithm shadeAlgorithm();

    BumpMappingAlgorithm bumpMappingAlgorithm();

    void setNormalTextureId(String textureId);

    void setColorTextureId(String textureId);

    void setLightAlgorithm(LightAlgorithm algorithm);

    void setShadeAlgorithm(ShadowAlgorithm algorithm);

    void bumpMappingAlgorithm(BumpMappingAlgorithm algorithm);
}
