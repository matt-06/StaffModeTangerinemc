package staffmode.utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    static List<Player> gods = new ArrayList<>();
    static List<Player> hiddenPlayers = new ArrayList<>();
    static List<Player> freezedPlayer = new ArrayList<>();

    public static List<Player> getGods(){
        return gods;
    }

    public static List<Player> getFreezedPlayer(){
        return freezedPlayer;
    }

    public static List<Player> getHiddenPlayers(){
        return hiddenPlayers;
    }
}
