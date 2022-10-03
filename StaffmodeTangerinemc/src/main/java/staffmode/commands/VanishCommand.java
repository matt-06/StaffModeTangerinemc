package staffmode.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import staffmode.tools.VanishTool;
import staffmode.main.Core;

public class VanishCommand implements CommandExecutor {
    private final Core plugin;

    public VanishCommand(Core plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        VanishTool vanishTool = new VanishTool(plugin);
        if(!(sender instanceof Player)){
            sender.sendMessage(plugin.getConfig().getString("ConsoleError"));
        }else{
            Player player = (Player) sender;

            if(player.hasPermission("tangerine.staffmode.tools")){
                vanishTool.vanishTool(player);
            }
        }

        return true;
    }
}
