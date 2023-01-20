package id.ac.ui.cs.advancedprogramming.controlwand.repository;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EntityCollectionTest {
    private EntityCollection entityCollection;

    @BeforeEach
    public void setUp() {
        entityCollection = new EntityCollection();
    }

    @Test
    public void whenRegisterEntityItShouldAddToEntitiesList() {
        MagicalEntity familiar = new Familiar("Familiar Test");
        entityCollection.registerEntity(familiar);

        Iterable<MagicalEntity> entitiesRepository = entityCollection.getMagicalEntities();
        assertThat(entitiesRepository).hasSize(1);
        assertThat(entitiesRepository).contains(familiar);
    }
}
