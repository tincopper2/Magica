package net.mdcreator.magica.spell;

import org.bukkit.entity.Player;

public class SpellFire extends Spell{

    public SpellFire(){
        name = "Fire";
        castName = "ignis";
        description = "Strikes lightning at the pointer";
    }

    public void effects(Player caster) {
    }

    public void cast(Player caster) {
        caster.getWorld().strikeLightning(caster.getTargetBlock(null, 512).getLocation());
    }
}
