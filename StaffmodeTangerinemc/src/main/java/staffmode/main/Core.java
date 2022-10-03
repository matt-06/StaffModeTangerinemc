package staffmode.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import staffmode.commands.StaffModeCommand;
import staffmode.commands.GodCommand;
import staffmode.commands.VanishCommand;
import staffmode.events.*;

public final class Core extends JavaPlugin {

    @Override
    public void onEnable() {
       getLogger().info("Plugin enabled");

       registerCommands();
       registerEvents();

       createConfig();
    }

    void registerCommands() {
        getCommand("staffmode").setExecutor(new StaffModeCommand(this));
        getCommand("god").setExecutor(new GodCommand(this));
        getCommand("vanish").setExecutor(new VanishCommand(this));
    }

    void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new ClickEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDamagedEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new PlacingEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new MoveEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new DropEvent(), this);
    }

    void createConfig(){
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }
}
