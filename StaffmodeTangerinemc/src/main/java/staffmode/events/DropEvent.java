package staffmode.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import staffmode.manager.StaffModeManager;

public class DropEvent implements Listener{

    @EventHandler
    public void onDropEvent(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        if(StaffModeManager.stafferStateEnabled.contains(player)){
            event.setCancelled(true);
        }
    }
}
