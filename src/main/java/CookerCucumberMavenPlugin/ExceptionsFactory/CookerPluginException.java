package CookerCucumberMavenPlugin.ExceptionsFactory;

public class CookerPluginException extends Exception {
    /**
     * Constructor to set the error message
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @param message Error Message to display
     */
    public CookerPluginException(final String message) {
        super(message);
    }
}
