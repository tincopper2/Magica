package net.mdcreator.magica.spell;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class SpellFireball extends Spell{

    public SpellFireball(){
        name = "Fireball";
        castName = "bynus";
        description = "Launches a ghast fireball at the pointer";
    }

    public void effects(Player caster){

    }

    public void cast(Player caster){
        Fireball fireball = caster.launchProjectile(Fireball.class);
        fireball.setShooter(caster);
        fireball.setYield(7.5f);
        fireball.setMetadata("playerSpawned", new FixedMetadataValue(caster.getServer().getPluginManager().getPlugin("Magica"), null));
    }
}
