package net.mdcreator.magica.spell;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public abstract class Spell {

    public String name;
    public String castName;
    public String description;

    public String asFormattedString(){
        return ChatColor.LIGHT_PURPLE + "- " + ChatColor.DARK_PURPLE + asCapital() + ChatColor.DARK_GRAY + "\\" +
                ChatColor.GRAY  + name + ChatColor.DARK_GRAY + "\\" +
                ChatColor.BLUE + description;
    }

    public String asCapital(){
        return castName.substring(0,1).toUpperCase() + castName.substring(1);
    }

    public void execute(Player caster){
        cast(caster);
        effects(caster);
    }

    public abstract void effects(Player caster);

    public abstract void cast(Player caster);

}