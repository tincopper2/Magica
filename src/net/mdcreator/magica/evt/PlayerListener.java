package net.mdcreator.magica.evt;

import net.mdcreator.magica.Magica;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

    private final Magica plugin;

    public PlayerListener(Magica plugin){
        this.plugin = plugin;
        plugin.server.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){

    }
}
