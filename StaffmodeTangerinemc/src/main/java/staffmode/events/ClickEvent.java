package staffmode.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import staffmode.tools.*;
import staffmode.main.Core;
import staffmode.manager.StaffModeManager;

public class ClickEvent implements Listener {

    private final Core plugin;

    public ClickEvent(Core plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(StaffModeManager.stafferStateEnabled.contains(player)){
            GodModeTool godModeTool = new GodModeTool(plugin);
            VanishTool vanishTool = new VanishTool(plugin);
            RandomTPTool randomTPTool = new RandomTPTool();
            TPTool tpTool = new TPTool(plugin);
            FreezeTool freezeTool = new FreezeTool(plugin);
            InvSeeTool invSeeTool = new InvSeeTool(plugin);

            String vanishToolName = plugin.getConfig().getString("StaffModeInventory.VanishTool.name");
            String randomTPName = plugin.getConfig().getString("StaffModeInventory.RandomTPTool.name");
            String GodModeName = plugin.getConfig().getString("StaffModeInventory.GodModeTool.name");
            String TPToolName = plugin.getConfig().getString("StaffModeInventory.TPTool.name");
            String FreezeToolName = plugin.getConfig().getString("StaffModeInventory.FreezeTool.name");
            String InvSeeToolName = plugin.getConfig().getString("StaffModeInventory.InvSeeTool.name");

            if(event.getAction() == Action.LEFT_CLICK_AIR){
                return;
            }else if(event.getAction() == Action.LEFT_CLICK_BLOCK){
                return;
            }

            if(event.getItem().getItemMeta().getDisplayName().equals(vanishToolName)){
                vanishTool.vanishTool(player);
            }else if (event.getItem().getItemMeta().getDisplayName().equals(randomTPName)){
                randomTPTool.randomTPTool(player);
            }else if (event.getItem().getItemMeta().getDisplayName().equals(GodModeName)){
                godModeTool.godMode(player);
            }else if(event.getItem().getItemMeta().getDisplayName().equals(TPToolName)){
                tpTool.tpTool(player);
            }else if(event.getItem().getItemMeta().getDisplayName().equals(FreezeToolName)){
                freezeTool.freezeTool(player);
            }else if(event.getItem().getItemMeta().getDisplayName().equals(InvSeeToolName)){
                invSeeTool.invSee(player);
            }
        }
    }
}
