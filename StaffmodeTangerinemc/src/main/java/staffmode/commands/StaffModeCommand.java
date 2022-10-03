package staffmode.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import staffmode.main.Core;
import staffmode.manager.StaffModeManager;

import static staffmode.manager.StaffModeManager.stafferStateEnabled;

public class StaffModeCommand implements CommandExecutor {

    public final Core plugin;

    public StaffModeCommand(Core plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(player.hasPermission("tangerine.staffmode")){
                StaffModeManager manager = new StaffModeManager(plugin);

                String insufficientPermission = plugin.getConfig().getString("InsufficentPermissionMessage");
                String staffModeOn = plugin.getConfig().getString("StaffModeOnMessage");
                String staffModeOff = plugin.getConfig().getString("StaffModeOffMessage");

                insufficientPermission = ChatColor.translateAlternateColorCodes('&', insufficientPermission);
                staffModeOn = ChatColor.translateAlternateColorCodes('&', staffModeOn);
                staffModeOff = ChatColor.translateAlternateColorCodes('&', staffModeOff);

                if(!player.hasPermission("tangerinemc.staffmode")) player.sendMessage(insufficientPermission);
                if(stafferStateEnabled.contains(player)){
                    player.sendMessage(staffModeOff);
                    manager.removeStaffMode(player);
                }else{
                    player.sendMessage(staffModeOn);
                    manager.setStaffMode(player);
                }
            }
        } return true;
    }
}
