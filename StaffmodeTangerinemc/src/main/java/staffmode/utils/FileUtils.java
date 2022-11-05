package staffmode.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    private static FileConfiguration configuration;

    public void createFile(Player player) throws IOException {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("Staffmode").getDataFolder(), player.getDisplayName() + ".yml");

        if(!file.exists()){
            file.createNewFile();
        }

        configuration = YamlConfiguration.loadConfiguration(file);
        configuration.set("Inventory.items",  player.getInventory().getContents());

        configuration.save(file);
    }

    public static FileConfiguration getConfig(){
        return configuration;
    }

}
