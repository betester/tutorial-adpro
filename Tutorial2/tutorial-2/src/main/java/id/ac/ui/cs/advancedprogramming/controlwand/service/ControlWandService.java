package id.ac.ui.cs.advancedprogramming.controlwand.service;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;

import java.util.EnumSet;

public interface ControlWandService {
    public void castSpell(String spellName);
    public void undoSpell();
    public Iterable<String> getSpellNames();
    public Iterable<MagicalEntity> getMagicalEntities();
    public void contractFamiliar(String name);
    public void buyMagicTool(String name, EnumSet<ManaIntensity> requiredSpells);
}
