package net.mdcreator.magica;

import net.mdcreator.magica.evt.PlayerListener;
import net.mdcreator.magica.spell.Spells;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Magica extends JavaPlugin {

    public Server server;
    public Logger log;
    public PlayerListener playerListener;
    public Spells spells;

    public File dataFolder;
    public File configFile;
    public FileConfiguration config;

    public void onEnable(){
        server = getServer();
        log = getLogger();
        spells = new Spells();
        playerListener = new PlayerListener(this);

        dataFolder = getDataFolder();
        configFile = new File(getDataFolder(), "config.yml");

        checkFiles();
        config = getConfig();
    }

    public void checkFiles(){
        try{
            log.info("Creating folder and files");
            if(!dataFolder.exists()) dataFolder.mkdir();
            if(!configFile.exists()){
                configFile.createNewFile();
                util.copyFile("/ext/config.yml", configFile);
            }
        } catch(IOException e){
            //Abort startup so nothing weird happens
            log.severe("Error during startup, aborting:");
            e.printStackTrace();
            server.getPluginManager().disablePlugin(this);
        }
    }
}
