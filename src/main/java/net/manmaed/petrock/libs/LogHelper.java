package net.manmaed.petrock.libs;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by manmaed on 25/11/2019.
 */
public class LogHelper {

    private static final Logger LOGGER = LogManager.getLogger();

    private static void log(Level loglvl, Object object) {
        LOGGER.log(loglvl, "[" + loglvl + "]:" + "-" + Refs.LOG + " " + String.valueOf(object));
    }

    public static void info(Object object) {
        log(Level.INFO, object);
    }
    public static void warn(Object object) {
        log(Level.WARN, object);
    }
    public static void fatal(Object object) {
        log(Level.FATAL, object);
    }
    public static void debug(Object object) {
        log(Level.FATAL,object);
    }
}
