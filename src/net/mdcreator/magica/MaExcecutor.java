package net.mdcreator.magica;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

public class MaExcecutor implements CommandExecutor{

    private String title = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + "Magica" + ChatColor.DARK_GRAY + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
    private final Magica plugin;

    public MaExcecutor(Magica plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginCommand("magica").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0){
            sender.sendMessage(title + "info");
            PluginDescriptionFile pdFile = plugin.getDescription();
            sender.sendMessage(ChatColor.DARK_GRAY + "vers " + ChatColor.GRAY + pdFile.getVersion());
            for(String author: pdFile.getAuthors()){
                sender.sendMessage(ChatColor.DARK_GRAY + "by " + ChatColor.GRAY + author);
            }
            sender.sendMessage(ChatColor.DARK_GRAY + "desc " + ChatColor.GRAY + pdFile.getDescription());
            sender.sendMessage(ChatColor.DARK_GRAY + "site " + ChatColor.GRAY + pdFile.getWebsite());
        }
        return true;
    }
}
