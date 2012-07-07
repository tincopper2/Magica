package net.mdcreator.magica.spell;

import org.bukkit.entity.Player;

public class SpellHeal extends Spell{

    public SpellHeal(){
        name = "Heal";
        castName = "sana";
        description = "Heals, feeds, and extinguishes you";
    }

    public void effects(Player caster) {

    }

    public void cast(Player caster) {
        caster.setHealth(20);
        caster.setFoodLevel(20);
        caster.setFireTicks(0);
    }
}
