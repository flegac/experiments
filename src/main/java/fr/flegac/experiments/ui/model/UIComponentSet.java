package fr.flegac.experiments.ui.model;

import java.util.ArrayList;
import java.util.List;

import fr.flegac.experiments.ui.model.components.box.UIBox;
import fr.flegac.experiments.ui.model.components.specific.UIRessource;
import fr.flegac.experiments.ui.model.components.specific.UILabel;

public class UIComponentSet {
    public List<UILabel> labels = new ArrayList<>();

    public List<UIRessource> resources = new ArrayList<>();

    public List<UIBox> boxes = new ArrayList<>();
}
