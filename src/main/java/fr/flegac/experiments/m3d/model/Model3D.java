package fr.flegac.experiments.m3d.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Model3D {
    private Map<String, Group> groups = new HashMap<>();

    public Set<String> groups() {
        return groups.keySet();
    }

    public Group group(String groupId) {
        return groups.get(groupId);
    }

    public void create(String groupId, Face... faces) {
        if (groups.containsKey(groupId)) {
            groups.put(groupId, new Group());
        }
        for (Face face : faces) {
            group(groupId).faces().add(face);
        }
    }
}
