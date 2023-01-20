package id.ac.ui.cs.advancedprogramming.controlwand.repository;

import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.Spell;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Repository
public class ControlWand {
    //manggil command
    //cuman buat  nyimpan command
    final private Map<String, Spell> spells; //sbg button/remote control
    final private Stack<Spell> lastUsedSpell;

    public ControlWand() {
        this.spells = new HashMap<>();
        this.lastUsedSpell = new Stack<>();
    }

    public void registerSpell(Spell spell) {
        spells.put(spell.spellName(), spell);
    }

    public void cast(String spellName) {
        Spell use = spells.get(spellName);
        use.cast();
        lastUsedSpell.add(use);
    }

    public void undo() {
        if (!lastUsedSpell.empty())
            lastUsedSpell.pop().undo();
    }

    public Iterable<String> getSpellNames() {
        return spells.keySet();
    }
}
