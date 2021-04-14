package net.manmaed.petrock.hats;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PRPHats {
    public static List<String> playerhats = new ArrayList<>();
    private static String uuid = "";

    public static void addHatToPlayer(String player_uuid) {
        if (!playerhats.contains(player_uuid)) {
            //LogHelper.debug("Adding " + player_uuid + " to ArrayList");
            playerhats.add(player_uuid);
        }
        //LogHelper.debug("ArrayList: " + playerhats);
    }

    public static boolean playerHasHat(String playeruuid) {
        //LogHelper.debug("Given " + playeruuid);
        if (playerhats.contains(playeruuid)) {
            //LogHelper.debug("have hat");
            return true;
        } else {
            //LogHelper.debug("no hat");
            return false;
        }
    }

    public static void load() {
        PlayerHatData playerHatData = null;
        try {
            playerHatData = playerHatData.getHatData(new URL("https://raw.githubusercontent.com/manmaed/Pet-Rock/master/players.json"));
            //playerHatData = playerHatData.getHatData(new URL("file:///G:/Modding/Forge/1_16_1/PetRock/run/test/players.json"));
            String hashat = playerHatData.PlayerHasHat();
            uuid = playerHatData.getUuid();
            if(!uuid.isEmpty()) {
                addHatToPlayer(uuid);
            }
            /*addhattoplayer(uuid);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
