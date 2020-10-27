package net.manmaed.petrock.hats;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import net.manmaed.petrock.libs.LogHelper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class PlayerHatData {
    private List<Players> players;
    private String uuid = "";

    public void loadPlayerHatData() {
        for(Players players : players) {
            uuid = players.user.uuid;
            //PRPHats.addhattoplayer(players.users.uuid);
        }
    }

    public String getUuid() {
        return uuid;
    }

    private class Players {
        private User user;
    }
    private class User {
        private String username;
        private String uuid;

    }

    public static PlayerHatData getHatData(URL url) {
        try {
            String jsonString = IOUtils.toString(url, Charsets.UTF_8);
            return new Gson().fromJson(jsonString, PlayerHatData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
