package net.mdcreator.magica.spell;

import net.mdcreator.magica.Magica;

public class Spells {

    private final Magica plugin;

    public static Spell[] spells;

    public Spells(Magica plugin) {
        this.plugin = plugin;
        addSpells();
    }

    public static Spell getSpellByName(String name){
        for(Spell s: spells){
            if(s.name.equals(name)) return s;
        }
        return null;
    }

    public static Spell getSpellByCastName(String castName){
        for(Spell s: spells){
            if(s.castName.equals(castName)) return s;
        }
        return null;
    }


    public static void add(Spell spell){
        if(spells.length==0){
            spells[0] = spell;
        }
        spells[spells.length] = spell;
    }

    private void addSpells(){
        spells = new Spell[]{
                new SpellNothing(),
                new SpellFireball(),
                new SpellFire(),
                new SpellTime(),
        };
    }
}
