package net.manmaed.petrock.hats;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import net.manmaed.petrock.libs.LogHelper;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PRPHats {

    private static final Gson GSON = new Gson();
    private static final URL url = getURL("https://raw.githubusercontent.com/manmaed/Pet-Rock/master/players.json");
    //Below is Testing URL
    //private static final URL url = getURL("file:///G:/Modding/PetRockFIles/Pet-Rock/players.json");

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<PlayerHatData> playerHatData = Optional.empty();
    
    public void load() {
        try {
            String jsonString = IOUtils.toString(url, Charsets.UTF_8);
            playerHatData = Optional.ofNullable(GSON.fromJson(jsonString, PlayerHatData.class));
        } catch (IOException e) {
            LogHelper.warn("There was an error getting player hat data. " + e);
        }
    }

    public boolean doesPlayerHaveHat(UUID uuid) {
        return playerHatData.map(playerHatData1 -> playerHatData1.getPlayers().stream().findFirst()
                .filter(player -> player.getUser().getUuid().equals(uuid)).isPresent())
                .orElse(false);
    }

    public static URL getURL(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
