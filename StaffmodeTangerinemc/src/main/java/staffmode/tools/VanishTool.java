package staffmode.tools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import staffmode.main.Core;
import staffmode.utils.ListUtils;

public class VanishTool {
    public final Core plugin;

    public VanishTool(Core plugin) {
        this.plugin = plugin;
    }

    public void vanishTool(Player player){
        if(ListUtils.hiddenPlayers.contains(player)){
            String noLongerVisibleMessage = plugin.getConfig().getString("NoLongerVisibleMessage");
            noLongerVisibleMessage = ChatColor.translateAlternateColorCodes('&', noLongerVisibleMessage);
            player.sendMessage(noLongerVisibleMessage);
            ListUtils.hiddenPlayers.remove(player);


            for(Player users : Bukkit.getOnlinePlayers()){
                users.showPlayer(player);
            }


        }else{
            ListUtils.hiddenPlayers.add(player);
            String VisibleMessage = plugin.getConfig().getString("VisibleMessage");
            VisibleMessage = ChatColor.translateAlternateColorCodes('&', VisibleMessage);
            player.sendMessage(VisibleMessage);

            for(Player users : Bukkit.getOnlinePlayers()){
                if(!users.hasPermission("tangerine.staffmode.skipVanish")){
                    users.hidePlayer(player);
                }
            }
        }
    }
}

