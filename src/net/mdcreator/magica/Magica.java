package net.mdcreator.magica;

import net.mdcreator.magica.evt.PlayerListener;
import net.mdcreator.magica.spell.Spells;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Magica extends JavaPlugin {

    public Server server;
    public PlayerListener playerListener;
    public Spells spells;

    public void onEnable(){
        server = getServer();

        spells = new Spells(this);
        playerListener = new PlayerListener(this);
    }
}
