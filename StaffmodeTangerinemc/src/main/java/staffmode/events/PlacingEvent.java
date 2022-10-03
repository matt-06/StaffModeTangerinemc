package staffmode.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import staffmode.manager.StaffModeManager;

public class PlacingEvent implements Listener {
    @EventHandler
    public void onBlockPlacedEvent(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(StaffModeManager.stafferStateEnabled.contains(player)){
            event.setCancelled(true);
        }
    }
}
