package net.mdcreator.magica.evt;

import net.mdcreator.magica.spell.SpellType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerCastEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Player player;
    private SpellType spellType;
    private boolean isCancelled = true;

    public PlayerCastEvent(Player player, SpellType spellType){
        this.player = player;
        this.spellType = spellType;
    }

    public Player getPlayer(){
        return player;
    }

    public SpellType getSpellType(){
        return spellType;
    }

    public boolean isCancelled(){
        return isCancelled;
    }

    public void setCancelled(boolean state){
        isCancelled = state;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
