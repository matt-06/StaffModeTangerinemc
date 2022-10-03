package staffmode.tools;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Random;

public class RandomTPTool {
    public void randomTPTool(Player player){
        ArrayList<Player> allPlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        int random = new Random().nextInt(Bukkit.getOnlinePlayers().size());
        Player randomPlayer = allPlayers.get(random);
        if(!randomPlayer.hasPermission("tangerine.staffmode.skipRandomTP")){
            Location randomPlayerLocation = randomPlayer.getLocation();
            player.teleport(randomPlayerLocation);
            player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 50.0f, 0.0f);
        }
    }
}
