package net.mdcreator.magica;

import net.mdcreator.magica.evt.PlayerListener;
import net.mdcreator.magica.spell.Spells;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class Magica extends JavaPlugin {

    public Server server;
    public PlayerListener playerListener;
    public Spells spells;

    public void onEnable(){
        server = getServer();
        spells = new Spells();
        playerListener = new PlayerListener(this);
    }
}
