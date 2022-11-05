package staffmode.manager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import staffmode.main.Core;
import staffmode.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;

public class StaffModeManager {

    private final Core plugin;

    public StaffModeManager(Core plugin) {
        this.plugin = plugin;
    }
    public static ArrayList<Player> stafferStateEnabled = new ArrayList<>();

    public void setStaffMode(Player staffer){
        stafferStateEnabled.add(staffer);

        FileUtils fileUtils = new FileUtils();

        try{
            fileUtils.createFile(staffer);
        }catch(IOException exception){
            exception.printStackTrace();
        }

        String vanishToolName = plugin.getConfig().getString("StaffModeInventory.VanishTool.name");
        String randomTPName = plugin.getConfig().getString("StaffModeInventory.RandomTPTool.name");
        String GodModeName = plugin.getConfig().getString("StaffModeInventory.GodModeTool.name");
        String TPToolName = plugin.getConfig().getString("StaffModeInventory.TPTool.name");
        String FreezeToolName = plugin.getConfig().getString("StaffModeInventory.FreezeTool.name");
        String InvSeeToolName = plugin.getConfig().getString("StaffModeInventory.InvSeeTool.name");

        vanishToolName = ChatColor.translateAlternateColorCodes('&', vanishToolName);
        randomTPName = ChatColor.translateAlternateColorCodes('&', randomTPName);
        GodModeName = ChatColor.translateAlternateColorCodes('&', GodModeName);
        TPToolName = ChatColor.translateAlternateColorCodes('&', TPToolName);
        FreezeToolName = ChatColor.translateAlternateColorCodes('&', FreezeToolName);
        InvSeeToolName = ChatColor.translateAlternateColorCodes('&', InvSeeToolName);

        ItemStack vanishToolMaterial = new ItemStack(Material.valueOf(plugin.getConfig().getString("StaffModeInventory.VanishTool.material")));
        ItemStack randomTPMaterial = new ItemStack(Material.valueOf(plugin.getConfig().getString("StaffModeInventory.RandomTPTool.material")));
        ItemStack GodModeMaterial = new ItemStack(Material.valueOf(plugin.getConfig().getString("StaffModeInventory.GodModeTool.material")));
        ItemStack TPToolMaterial = new ItemStack(Material.valueOf(plugin.getConfig().getString("StaffModeInventory.TPTool.material")));
        ItemStack FreezeToolMaterial = new ItemStack(Material.valueOf(plugin.getConfig().getString("StaffModeInventory.FreezeTool.material")));
        ItemStack InvSeeToolMaterial = new ItemStack(Material.valueOf(plugin.getConfig().getString("StaffModeInventory.InvSeeTool.material")));

        ItemMeta vanishToolMeta = vanishToolMaterial.getItemMeta();
        vanishToolMeta.setDisplayName(vanishToolName);
        vanishToolMaterial.setItemMeta(vanishToolMeta);

        ItemMeta randomTPMeta = randomTPMaterial.getItemMeta();
        randomTPMeta.setDisplayName(randomTPName);
        randomTPMaterial.setItemMeta(randomTPMeta);

        ItemMeta GodModeMeta = GodModeMaterial.getItemMeta();
        GodModeMeta.setDisplayName(GodModeName);
        GodModeMaterial.setItemMeta(GodModeMeta);

        ItemMeta TPToolMeta = TPToolMaterial.getItemMeta();
        TPToolMeta.setDisplayName(TPToolName);
        TPToolMaterial.setItemMeta(TPToolMeta);

        ItemMeta FreezeToolMeta = FreezeToolMaterial.getItemMeta();
        FreezeToolMeta.setDisplayName(FreezeToolName);
        FreezeToolMaterial.setItemMeta(FreezeToolMeta);

        ItemMeta InvSeeMeta = InvSeeToolMaterial.getItemMeta();
        InvSeeMeta.setDisplayName(InvSeeToolName);
        InvSeeToolMaterial.setItemMeta(InvSeeMeta);

        staffer.getInventory().clear();

        staffer.getInventory().setItem(plugin.getConfig().getInt("StaffModeInventory.VanishTool.inventory_index"), vanishToolMaterial);
        staffer.getInventory().setItem(plugin.getConfig().getInt("StaffModeInventory.RandomTPTool.inventory_index"), randomTPMaterial);
        staffer.getInventory().setItem(plugin.getConfig().getInt("StaffModeInventory.GodModeTool.inventory_index"), GodModeMaterial);
        staffer.getInventory().setItem(plugin.getConfig().getInt("StaffModeInventory.TPTool.inventory_index"), TPToolMaterial);
        staffer.getInventory().setItem(plugin.getConfig().getInt("StaffModeInventory.FreezeTool.inventory_index"), FreezeToolMaterial);
        staffer.getInventory().setItem(plugin.getConfig().getInt("StaffModeInventory.InvSeeTool.inventory_index"), InvSeeToolMaterial);

    }

    public void removeStaffMode(Player staffer){
        stafferStateEnabled.remove(staffer);
        staffer.getInventory().clear();
        FileConfiguration stafferInventoryFile = FileUtils.getConfig();
        staffer.getInventory().setContents((ItemStack[]) stafferInventoryFile.get("Inventory.items"));
    }
}
