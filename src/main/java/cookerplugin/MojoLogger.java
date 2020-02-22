package cookerplugin;


import org.apache.maven.plugin.logging.Log;

public class MojoLogger {
    private static Log logger;

    public static void setLogger(Log log) {
        logger = log;
    }

    public static Log getLogger() {
        return logger;
    }


}