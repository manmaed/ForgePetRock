package net.manmaed.petrock.hats;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by unrealdinnerbone on 10/12/2018.
 * Not LatvianModder Approved!
 */
public class HatData2
{
    private List<Events> events;
    private String username = "";
    private String uuid;

    public String getUsername() {
        return username;
    }

    public String getUuid() { return uuid; }

    private class Events {
        private String username;
        private String uuid;
    }

    public static HatData2 getHatData(URL url) {
        try {
            String jsonString = IOUtils.toString(url, Charsets.UTF_8);
            return new Gson().fromJson(jsonString, HatData2.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
