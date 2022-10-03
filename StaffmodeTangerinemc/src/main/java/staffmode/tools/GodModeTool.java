package staffmode.tools;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import staffmode.utils.ListUtils;
import staffmode.main.Core;
import staffmode.manager.StaffModeManager;

public class GodModeTool {

    public final Core plugin;

    public GodModeTool(Core plugin) {
        this.plugin = plugin;
    }

    public void godMode(Player player){
        if(!ListUtils.gods.contains(player)){
            String godModeOnMessage = plugin.getConfig().getString("GodModeOnMessage");
            godModeOnMessage = ChatColor.translateAlternateColorCodes('&', godModeOnMessage);
            if(!StaffModeManager.stafferStateEnabled.contains(player)) return;

            player.setFoodLevel(20);
            player.setHealth(20.0);
            player.sendMessage(godModeOnMessage);
            ListUtils.gods.add(player);
        }else if(!ListUtils.gods.contains(player)){
            String godModeOnMessage = plugin.getConfig().getString("GodModeOnMessage");
            godModeOnMessage = ChatColor.translateAlternateColorCodes('&', godModeOnMessage);
            if(!StaffModeManager.stafferStateEnabled.contains(player)) return;

            player.setFoodLevel(20);
            player.setHealth(20.0);
            player.sendMessage(godModeOnMessage);
            ListUtils.gods.add(player);
        }else if(ListUtils.gods.contains(player)){
            String godModeOffMessage = plugin.getConfig().getString("GodModeOffMessage");
            godModeOffMessage = ChatColor.translateAlternateColorCodes('&', godModeOffMessage);
            player.sendMessage(godModeOffMessage);
            ListUtils.gods.remove(player);
        }

    }
}
