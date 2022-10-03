package staffmode.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import staffmode.utils.ListUtils;
import staffmode.main.Core;

public class PlayerDamagedEvent implements Listener {
    private final Core plugin;

    public PlayerDamagedEvent(Core plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerDamageEvent(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();

            if(ListUtils.gods.contains(player)) {
                event.setCancelled(true);
            }
        }
    }
}
