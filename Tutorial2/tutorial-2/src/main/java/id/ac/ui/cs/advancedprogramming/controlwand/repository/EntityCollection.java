package id.ac.ui.cs.advancedprogramming.controlwand.repository;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntityCollection {
    final private List<MagicalEntity> entities;

    public EntityCollection() {
        entities = new ArrayList<>();
    }

    public void registerEntity(MagicalEntity entity) {
        entities.add(entity);
    }

    public Iterable<MagicalEntity> getMagicalEntities() {
        return entities;
    }
}
