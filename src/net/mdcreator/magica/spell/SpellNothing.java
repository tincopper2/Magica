package net.mdcreator.magica.spell;

import org.bukkit.entity.Player;

public class SpellNothing extends Spell{

    public SpellNothing(){
        name = "Nothing";
        castName = "nil";
        description = "Does... well... nothing";
    }

    public void effects(Player caster){}

    public void cast(Player caster){}
}
