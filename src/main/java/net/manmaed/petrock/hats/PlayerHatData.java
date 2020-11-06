package net.manmaed.petrock.hats;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import net.manmaed.petrock.libs.LogHelper;
import net.minecraft.client.Minecraft;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.UUID;

public class PlayerHatData {

    private List<Players> players;

    public List<Players> getPlayers() {
        return players;
    }

    public static class Players {
        private User user;

        public User getUser() {
            return user;
        }
    }

    public static class User {
        private String username;
        private UUID uuid;

        public String getUsername() {
            return username;
        }

        public UUID getUuid() {
            return uuid;
        }
    }


}
