package net.mdcreator.magica.spell;

import java.util.ArrayList;

public abstract class Spell {

    public static ArrayList<Spell> spells;

    public Spell(){
        spells.add(this);
    }


    public abstract void effects();

    public abstract void cast();

    public void excecute(){

    }

}
