package net.mdcreator.magica.spell;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpellRegen extends Spell{

    public SpellRegen(){
        name = "Regen";
        castName = "rero";
        description = "Regens your health for 20 secs";
    }

    public void effects(Player caster) {

    }

    public void cast(Player caster) {
        caster.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 20, 4));
    }
}
