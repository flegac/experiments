package fr.flegac.experiments.m3d.context;

public class ProgramContext1 implements ProgramContext {
    private String normalTextureId;

    private String colorTextureId;

    private LightAlgorithm lightAlgorithm = LightAlgorithm.NONE;

    private ShadowAlgorithm shadeAlgorithm = ShadowAlgorithm.NONE;

    private BumpMappingAlgorithm bumpMappingAlgorithm = BumpMappingAlgorithm.NONE;

    @Override
    public String normalTextureId() {
        return normalTextureId;
    }

    @Override
    public String colorTextureId() {
        return colorTextureId;
    }

    @Override
    public LightAlgorithm lightAlgorithm() {
        return lightAlgorithm;
    }

    @Override
    public ShadowAlgorithm shadeAlgorithm() {
        return shadeAlgorithm;
    }

    @Override
    public BumpMappingAlgorithm bumpMappingAlgorithm() {
        return bumpMappingAlgorithm;
    }

    @Override
    public void setNormalTextureId(String textureId) {
        normalTextureId = textureId;
    }

    @Override
    public void setColorTextureId(String textureId) {
        colorTextureId = textureId;
    }

    @Override
    public void setLightAlgorithm(LightAlgorithm algorithm) {
        lightAlgorithm = algorithm;
    }

    @Override
    public void setShadeAlgorithm(ShadowAlgorithm algorithm) {
        shadeAlgorithm = algorithm;
    }

    @Override
    public void bumpMappingAlgorithm(BumpMappingAlgorithm algorithm) {
        bumpMappingAlgorithm = algorithm;
    }

}
