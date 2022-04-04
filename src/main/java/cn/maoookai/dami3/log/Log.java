package cn.maoookai.dami3.log;

import cn.maoookai.dami3.DamiApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    private static final Logger logger = LoggerFactory.getLogger(DamiApplication.class);

    public static void debug(String log) {
        logger.debug(log);
    }

    public static void info(String log) {
        logger.info(log);
    }

    public static void warn(String log) {
        logger.warn(log);
    }

    public static void error(String log) {
        logger.error(log);
    }

}
