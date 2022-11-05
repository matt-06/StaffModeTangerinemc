package staffmode.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import staffmode.utils.ListUtils;
import staffmode.main.Core;

public class GodCommand implements CommandExecutor {
    private final Core plugin;

    public GodCommand(Core plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage(plugin.getConfig().getString("ConsoleError"));
            return true;
        }
        Player player = (Player)sender;
        if(player.hasPermission("tangerine.staffmode.tools")){
            if(!ListUtils.getGods().contains(player)){
                ListUtils.getGods().add(player);
                String GodModeOn = plugin.getConfig().getString("GodModeOnMessage");
                GodModeOn = ChatColor.translateAlternateColorCodes('&', GodModeOn);
                player.sendMessage(GodModeOn);
            }else{
                ListUtils.getGods().remove(player);
                String GodModeOff = plugin.getConfig().getString("GodModeOffMessage");
                GodModeOff = ChatColor.translateAlternateColorCodes('&', GodModeOff);
                player.sendMessage(GodModeOff);
            }
        }
        return true;
    }
}
