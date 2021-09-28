package net.manmaed.petrock.hats;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.libs.LogHelper;

import java.net.URL;

/**
 * Created by manmaed on 28/11/2019.
 */
public class PRHats {

    public static boolean christmas = false;
    public static boolean birthday = false;
    public static boolean halloween = false;
    public static boolean loneztar = false;
    public static boolean slowpoke = false;
    private static boolean userslow = false;
    private static String usernames = "";


    public static void load() {
        HatData hatData = null;
        birthday = false;
        christmas = false;
        halloween = false;
        slowpoke = false;
        loneztar = false;
        try {
            if (!PetRock.getHatsLoaded()) {
                hatData = HatData.getHatData(new URL("https://raw.githubusercontent.com/manmaed/Pet-Rock/master/hats.json"));
                //hatData = HatData.getHatData(new URL("file:///G:/Modding/Forge/1_16_5/PetRock/run/hattesting.json"));
                String hat = hatData.isEventActive();
                usernames = hatData.getUsername();
                if (!userslow) {
                    if (hat.equalsIgnoreCase("christmas")) {
                        christmas = true;
                    }
                    if (hat.equalsIgnoreCase("halloween")) {
                        halloween = true;
                    } else if (hat.equalsIgnoreCase("birthday")) {
                        birthday = true;
                        if (hatData.getUsername().equalsIgnoreCase("manmaed")) {
                            LogHelper.fatal("Please inform manmaed of this error: Happy Birthday!");
                        }
                        if (hatData.getUsername().equalsIgnoreCase("Slowpoke101")) {
                            slowpoke = true;
                        }
                        if (hatData.getUsername().equalsIgnoreCase("Loneztar")) {
                            birthday = false;
                            loneztar = true;
                            LogHelper.info("Happy Birthday Loneztar");
                        } else {
                            LogHelper.info("Happy Birthday " + hatData.getUsername());
                        }
                    }
                }
                if (userslow) {
                    /*slowisplaying();*/
                    slowpoke = true;
                    if (hat.equalsIgnoreCase("birthday") & hatData.getUsername().equalsIgnoreCase("Slowpoke101")) {
                        birthday = true;
                        LogHelper.info("Happy Birthday Slowpoke101");
                    }
                    if (hat.equalsIgnoreCase("christmas")) {
                        christmas = true;
                        LogHelper.info("Happy Christmas Slowpoke101");
                /*} else {
                    christmas = false;
                    halloween = false;
                    birthday = false;*/
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void slowisplaying() {
        slowpoke = true;
        userslow = true;
        /*if (birthday & usernames.equalsIgnoreCase("Slowpoke101")) {
            //    bday = true;
            LogHelper.info("Happy Birthday Slowpoke101");
        }
        if (christmas) {
            //    christmas = true;
            LogHelper.info("Happy Christmas Slowpoke101");
        }*/
        LogHelper.info("Slowpoke101 Hat Enabled!");
    }

    public static void setHat(String hat) {
        birthday = false;
        christmas = false;
        halloween = false;
        loneztar = false;
        if (hat.equalsIgnoreCase("halloween")) {
            halloween = true;
        }
        if (hat.equalsIgnoreCase("christmas")) {
            christmas = true;
        }
        if (hat.equalsIgnoreCase("birthday")) {
            birthday = true;
        }
        if (hat.equalsIgnoreCase("loneztar")) {
            loneztar = true;
        }
        if (hat.equalsIgnoreCase("none")) {
            birthday = false;
            christmas = false;
            halloween = false;
            loneztar = false;
        }
    }
    public static void iamslowpoke101() {
        birthday = false;
        christmas = false;
        halloween = false;
        loneztar = false;
        slowpoke = false;
        userslow = false;
        slowisplaying();
    }

    /*  public static void reload() {
          load();
          PetRock.proxy.renderlayers();
          EntityRendererPetRock.reload();
          LogHelper.info("Hats Reloaded!");
      }

      public static void setHat(String hat) {
          bday = false;
          christmas = false;
          halloween = false;
          slowpoke = false;
          if (!isSlowpokeplaying) {
              if (hat.equalsIgnoreCase("halloween")) {
                  halloween = true;
                  PetRock.proxy.renderlayers();
              }
              if (hat.equalsIgnoreCase("christmas")) {
                  christmas = true;
                  PetRock.proxy.renderlayers();
              }
              if (hat.equalsIgnoreCase( "birthday")) {
                  bday = true;
                  PetRock.proxy.renderlayers();
              }
              if (hat.equalsIgnoreCase( "none")) {
                  bday = false;
                  christmas = false;
                  halloween = false;
                  PetRock.proxy.renderlayers();
              }
          }
          if(isSlowpokeplaying) {
              slowpoke = true;
          }
      }
      public static void slowhatslowhat() {
          slowpoke = true;
          bday = false;
          christmas = false;
          halloween = false;
          PetRock.proxy.renderlayers();
          LogHelper.info("Slowpoke101 Hat Enabled!");
      }*/
    //Old Unused Code
}