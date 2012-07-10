package net.mdcreator.magica;

import net.mdcreator.magica.evt.PlayerListener;
import net.mdcreator.magica.spell.Spells;
import net.mdcreator.magica.util.BaseUtil;
import net.mdcreator.magica.util.FetchUtil;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Logger;

public class Magica extends JavaPlugin {

    public Server server;
    public Logger log;
    public Spells spells;
    public PlayerListener playerListener;
    public MaExcecutor maExcecutor;

    public File dataFolder;
    public File configFile;
    public FileConfiguration config;
    public File tempMagica;

    private String permSetting;

    public void onEnable(){
        server = getServer();
        log = getLogger();
        spells = new Spells();
        playerListener = new PlayerListener(this);
        maExcecutor = new MaExcecutor(this);

        dataFolder = getDataFolder();
        configFile = new File(getDataFolder(), "config.yml");
        tempMagica = new File(getDataFolder(), "TempMagica.jar");

        checkFiles();
        config = getConfig();
        permSetting = config.getString("perms");
    }

    public void checkFiles(){
        try{
            if(!dataFolder.exists()){
                log.info("Creating folder and files");
                dataFolder.mkdir();
            }
            if(!configFile.exists()){
                configFile.createNewFile();
                BaseUtil.extractFile("/ext/config.yml", configFile);
            }
        } catch(Exception e){
            //Abort startup so nothing weird happens
            log.severe("Error during startup, aborting:");
            e.printStackTrace();
            server.getPluginManager().disablePlugin(this);
        }
    }

    public void updatePlugin(){
        try{
            String file = FetchUtil.getDownloadLink("http://dev.bukkit.org/server-mods/magica/files/" + getLatestFile() + "/");
            downloadFile(file, tempMagica);
            BaseUtil.copyFile(tempMagica, getFile());
            tempMagica.delete();
        } catch(Exception e){
            log.severe("Error while updating, aborting:");
            e.printStackTrace();
        }
    }

    public String getLatestFile() throws Exception{
        JSONObject latest = (JSONObject)JSONValue.parse(BaseUtil.getHTML("http://bukget.org/api/plugin/magica"));
        String name = String.valueOf(((JSONArray)latest.get("versions")).size()+1) + "-";
        name+=((String)((JSONObject)((JSONArray)latest.get("versions")).get(0)).get("name")).replaceAll(" ", "-").replaceAll("\\.", "-").toLowerCase();
        return name;
    }

    public void downloadFile(String url, File to) throws Exception{
        ReadableByteChannel rbc = Channels.newChannel(new URL(url).openStream());
        to.createNewFile();
        FileOutputStream fos = new FileOutputStream(to);
        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
        fos.close();
    }

    public boolean playerHas(Player player, String perm){
        return permSetting.equals("op") && player.isOp() || permSetting.equals("all") || permSetting.equals("perm") && player.hasPermission(perm) ;
    }

}
