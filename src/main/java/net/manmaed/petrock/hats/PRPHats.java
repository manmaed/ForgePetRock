package net.manmaed.petrock.hats;

import com.ibm.icu.impl.USerializedSet;
import net.manmaed.petrock.libs.LogHelper;
import sun.rmi.runtime.Log;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PRPHats {
    private static List<String> playerhats = new ArrayList<>();
    private static String uuid = "";

    public static void addhattoplayer(String player_uuid) {
        playerhats.add(player_uuid);
    }

    public static boolean playerhashat(String playeruuid) {
        if (playerhats.contains(playeruuid)) {
            return true;
        } else {
            return false;
        }
    }

    public static void load() {
        PlayerHatData playerHatData = null;
        try {
            //playerHatData = playerHatData.getHatData(new URL("https://raw.githubusercontent.com/manmaed/Pet-Rock/master/hats.json"));
            playerHatData = playerHatData.getHatData(new URL("file:///G:/Modding/Forge/1_16_1/PetRock/run/test/players.json"));
            uuid = playerHatData.getUuid();
            addhattoplayer(uuid);
            LogHelper.fatal("HD: " + uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
