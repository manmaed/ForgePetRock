package net.manmaed.petrock.hats;

import net.manmaed.petrock.libs.LogHelper;

import java.net.URL;
import java.util.UUID;

/**
 * Created by manmaed on 28/11/2019.
 */
public class PRHats2 {

    private static String usernames = "";
    public static String uuid;


    public static void load() {
        HatData2 hatData = null;
        try {
            //hatData = HatData2.getHatData(new URL("https://raw.githubusercontent.com/manmaed/Pet-Rock/master/players.json"));
            hatData = HatData2.getHatData(new URL("file:///G:/Modding/Forge/1_16_1/PetRock/run/test/players.json"));
            usernames = hatData.getUsername();
            uuid = hatData.getUuid();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}