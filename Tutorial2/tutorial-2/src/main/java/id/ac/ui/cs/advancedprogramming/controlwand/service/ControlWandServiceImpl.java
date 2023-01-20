package id.ac.ui.cs.advancedprogramming.controlwand.service;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;

import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.*;
import id.ac.ui.cs.advancedprogramming.controlwand.repository.ControlWand;
import id.ac.ui.cs.advancedprogramming.controlwand.repository.EntityCollection;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

@Service
public class ControlWandServiceImpl implements ControlWandService {
    private final ControlWand controlWand;
    private final EntityCollection entities;

    public ControlWandServiceImpl(ControlWand controlWand, EntityCollection entities) {
        this.controlWand = controlWand;
        this.entities = entities;
    }

    @Override
    public void castSpell(String spellName) {
        controlWand.cast(spellName);
    }

    @Override
    public void undoSpell() {
        controlWand.undo();
    }

    @Override
    public Iterable<String> getSpellNames() {
        return controlWand.getSpellNames();
    }

    @Override
    public Iterable<MagicalEntity> getMagicalEntities() {
        return entities.getMagicalEntities();
    }

    @Override
    public void contractFamiliar(String name) {
        Familiar familiar = new Familiar(name);
        SummonSpell summonFamiliar = new SummonSpell(familiar);
        SealSpell sealFamiliar = new SealSpell(familiar);

        controlWand.registerSpell(summonFamiliar);
        controlWand.registerSpell(sealFamiliar);
        entities.registerEntity(familiar);

    }

    @Override
    public void buyMagicTool(String name, EnumSet<ManaIntensity> requiredSpells) {
        MagicTool tool = new MagicTool(name);
        // TODO: Register spells
        NoneIntensitySpell noneIntensity = new NoneIntensitySpell(tool);
        LowIntensitySpell lowIntensity = new LowIntensitySpell(tool);
        MediumIntensitySpell mediumIntensity = new MediumIntensitySpell(tool);
        HighIntensitySpell highIntensity = new HighIntensitySpell(tool);

        controlWand.registerSpell(noneIntensity);
        if (requiredSpells.contains(ManaIntensity.LOW)) controlWand.registerSpell(lowIntensity);
        if (requiredSpells.contains(ManaIntensity.MEDIUM)) controlWand.registerSpell(mediumIntensity);
        if (requiredSpells.contains(ManaIntensity.HIGH)) controlWand.registerSpell(highIntensity);
        entities.registerEntity(tool);

    }
}
