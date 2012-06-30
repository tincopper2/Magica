package net.mdcreator.magica.evt;

import net.mdcreator.magica.spell.Spell;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerCastEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Player player;
    private Spell spell;
    private boolean isCancelled = true;

    public PlayerCastEvent(Player player, Spell Spell){
        this.player = player;
        this.spell = Spell;
    }

    public Player getPlayer(){
        return player;
    }

    public Spell getSpell(){
        return spell;
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
