package staffmode.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import staffmode.main.Core;
import staffmode.utils.ListUtils;

public class MoveEvent implements Listener {

    private final Core plugin;

    public MoveEvent(Core plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMoveEvent(PlayerMoveEvent event){
        Player player = event.getPlayer();

        if(ListUtils.getFreezedPlayer().contains(player)){
            String youAreFreezedMessage = plugin.getConfig().getString("YouAreFreezedMessage");

            youAreFreezedMessage = ChatColor.translateAlternateColorCodes('&', youAreFreezedMessage);

            event.setCancelled(true);
            player.sendMessage(youAreFreezedMessage);
        }
    }
}
