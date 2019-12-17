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

/**
 * Created by unrealdinnerbone on 10/12/2018.
 * Not LatvianModder Approved!
 */
public class HatData
{
    private static final DateFormat fileDateFormat = new SimpleDateFormat("dd MM");
    private List<Events> events;
    private String username = "";

    public String isEventActive() {
        String hat = "";
        for (Events event : events) {
            String date = fileDateFormat.format(new Date());
            String[] dateSplit = date.split(" ");
            int month = Integer.parseInt(dateSplit[1]);
            int day = Integer.parseInt(dateSplit[0]);
            boolean monthCheck = event.condition.date.month == 0 || month == event.condition.date.month;
            boolean dayCheck = event.condition.date.day == 0 || day == event.condition.date.day;
            if(monthCheck && dayCheck) {
                hat = event.hat;
                username = event.condition.username;
            }
        }
        return hat;
    }

    public String getUsername() {
        return username;
    }

    private class Events {
        private String hat;
        private Condition condition;

        private class Condition {
            private Date date;
            private String username;

            private class Date {
                int month;
                int day;
            }

        }
    }

    public static HatData getHatData(URL url) {
        try {
            String jsonString = IOUtils.toString(url, Charsets.UTF_8);
            return new Gson().fromJson(jsonString, HatData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
