package staffmode.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.Location;

import staffmode.tools.InvSeeTool;
import staffmode.main.Core;
import staffmode.manager.StaffModeManager;
import staffmode.utils.ListUtils;

public class InventoryEvent implements Listener {
    private final Core plugin;

    public InventoryEvent(Core plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        try{
            Player player = (Player) event.getWhoClicked();
            if(event.getView().getTitle().equals(plugin.getConfig().getString("StaffModeInventory.TPTool.inventory_name"))){
                Player playerToTP = Bukkit.getPlayer(event.getCurrentItem().getItemMeta().getDisplayName());
                Player staffer = (Player) event.getWhoClicked();

                Location locationToTp = playerToTP.getLocation();
                player.teleport(locationToTp);
                player.playSound(staffer.getLocation(), Sound.ENDERMAN_TELEPORT, 50f, 0f);

                event.setCancelled(true);
            }else if(event.getView().getTitle().equals(plugin.getConfig().getString("StaffModeInventory.FreezeTool.inventory_name"))){
                Player playerToFreeze = Bukkit.getPlayer(event.getCurrentItem().getItemMeta().getDisplayName());
                Player staffer = (Player) event.getWhoClicked();

                String PlayerFreezedMessage = plugin.getConfig().getString("PlayerFreezedMessage").replaceAll("%Player%", playerToFreeze.getDisplayName());
                String PlayerUnfreezedMessage = plugin.getConfig().getString("PlayerUnfreezedMessage").replaceAll("%Player%", playerToFreeze.getDisplayName());

                PlayerFreezedMessage = ChatColor.translateAlternateColorCodes('&', PlayerFreezedMessage);
                PlayerUnfreezedMessage = ChatColor.translateAlternateColorCodes('&', PlayerUnfreezedMessage);

                if(ListUtils.getFreezedPlayer().contains(playerToFreeze)){
                    ListUtils.getFreezedPlayer().remove(playerToFreeze);
                    staffer.sendMessage(PlayerUnfreezedMessage);
                }else{
                    ListUtils.getFreezedPlayer().add(playerToFreeze);
                    staffer.sendMessage(PlayerFreezedMessage);
                }event.setCancelled(true);
            }else if(event.getView().getTitle().equals(plugin.getConfig().getString("StaffModeInventory.InvSeeTool.inventory_name"))){
                event.setCancelled(true);

                InvSeeTool invSeeTool = new InvSeeTool(plugin);

                Player playerToInvSee = Bukkit.getPlayer(event.getCurrentItem().getItemMeta().getDisplayName());
                Player staffer = (Player) event.getWhoClicked();

                invSeeTool.getPlayerInventory(playerToInvSee, staffer);
            } else if (StaffModeManager.stafferStateEnabled.contains(player)) {
                event.setCancelled(true);
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}
