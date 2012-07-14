package net.mdcreator.magica.spell;

public class Spells {

    public static Spell[] spells;

    public Spells() {
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
                new SpellHeal(),
                new SpellRegen(),
                new SpellExplode()
        };
    }
}
