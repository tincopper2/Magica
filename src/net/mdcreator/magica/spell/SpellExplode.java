package net.mdcreator.magica.spell;

import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.metadata.FixedMetadataValue;

public class SpellExplode extends Spell{

    public SpellExplode(){
        name = "Explode";
        castName = "recio";
        description = "Explosion, and Lightning intertwined!";
    }

    public void effects(Player caster) {

    }


    public void cast(Player caster) {
        TNTPrimed tnt = caster.getWorld().spawn(caster.getTargetBlock(null, 512).getLocation(), TNTPrimed.class);
        tnt.setFuseTicks(0);
        tnt.setMetadata("playerSpawned", new FixedMetadataValue(caster.getServer().getPluginManager().getPlugin("Magica"), null));
    }
}
