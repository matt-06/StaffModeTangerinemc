package staffmode.tools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import staffmode.main.Core;

public class FreezeTool {
    private final Core plugin;

    public FreezeTool(Core plugin) {
        this.plugin = plugin;
    }

    public void freezeTool(Player player){
        Inventory playerToFreeze = Bukkit.createInventory(player, 90, plugin.getConfig().getString("StaffModeInventory.FreezeTool.inventory_name"));

        for(Player users : Bukkit.getOnlinePlayers()){
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1,(short) SkullType.PLAYER.ordinal());

            SkullMeta skull = (SkullMeta) item.getItemMeta();
            skull.setOwner(users.getName());
            skull.setDisplayName(users.getDisplayName());
            item.setItemMeta(skull);

            playerToFreeze.addItem(item);
        }
        player.openInventory(playerToFreeze);
    }
}
