package net.mdcreator.magica.spell;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class SpellTime extends Spell{

    public SpellTime(){
        name = "Time";
        castName = "hora";
        description = "Toggles day and night";
    }

    public void effects(Player caster){

    }

    public void cast(Player caster){
        BukkitScheduler scheduler = caster.getServer().getScheduler();
        final World world = caster.getWorld();
        final long finalTime = world.getTime()-12000<0 ? world.getTime()+12000 : world.getTime()-12000;

        for(long i=0;i<64;i++){
            scheduler.scheduleSyncDelayedTask(caster.getServer().getPluginManager().getPlugin("Magica"), new Runnable() {
                public void run() {
                    if(world.getTime()!=finalTime) world.setTime((long) (world.getTime() + (finalTime-world.getTime())*0.1));
                }
            }, i);
        }
    }
}
