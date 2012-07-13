package net.mdcreator.magica.spell;

import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.metadata.FixedMetadataValue;

public class SpellOblivion extends Spell{

    public SpellOblivion(){
        name = "Oblivion";
        castName = "Fragrecio";
        description = "Explosion, and Lightning intertwined!";
    }

    public void effects(Player caster) {

    }


    public void cast(Player caster) {
        for (int j = 0; j < 3; j++)
    	{
    		caster.getWorld().strikeLightning(caster.getTargetBlock(null, 512).getLocation());
    	}
        TNTPrimed tnt = caster.getWorld().spawn(caster.getTargetBlock(null, 512).getLocation(), TNTPrimed.class);
        tnt.setFuseTicks(0);
        tnt.setMetadata("playerSpawned", new FixedMetadataValue(caster.getServer().getPluginManager().getPlugin("Magica"), null));
    }
}
