package staffmode.tools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import staffmode.main.Core;

public class InvSeeTool {
    private final Core plugin;

    public InvSeeTool(Core plugin) {
        this.plugin = plugin;
    }

    public void invSee(Player player){
        Inventory players = Bukkit.createInventory(player, 90, plugin.getConfig().getString("StaffModeInventory.InvSeeTool.inventory_name"));

        for(Player users : Bukkit.getOnlinePlayers()){
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1,(short) SkullType.PLAYER.ordinal());

            SkullMeta skull = (SkullMeta) item.getItemMeta();
            skull.setOwner(users.getName());
            skull.setDisplayName(users.getDisplayName());
            item.setItemMeta(skull);

            players.addItem(item);
        }
        player.openInventory(players);
    }

    public void getPlayerInventory(Player player, Player staffer){
        Inventory playerInventory = Bukkit.createInventory(player, 36, plugin.getConfig().getString("StaffModeInventory.InvSeeTool.player_inventory_name")
                .replaceAll("%Player%", player.getName()));

        playerInventory.setContents(player.getInventory().getContents());

        staffer.openInventory(playerInventory);
    }
}
