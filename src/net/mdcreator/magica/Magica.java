package net.mdcreator.magica;

import net.mdcreator.magica.evt.PlayerListener;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Magica extends JavaPlugin {

    public Server server;
    public ShapelessRecipe wandRecipe;
    public ItemStack wandItem;

    public PlayerListener playerListener;

    public void onEnable(){
        server = getServer();
        wandItem = new ItemStack(Material.BLAZE_ROD, 1);
        wandItem.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
        wandRecipe = new ShapelessRecipe(wandItem)
                .addIngredient(Material.DIRT);
        server.addRecipe(wandRecipe);

        playerListener = new PlayerListener(this);
    }
}
