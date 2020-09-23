package CookerCucumberMavenPlugin.ExceptionsFactory.Exceps;

import CookerCucumberMavenPlugin.ExceptionsFactory.CookerPluginException;

public class CookerFeatureFactoryException extends CookerPluginException {
    /**
     * Constructor to set the error message
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @param message Error Message to display
     */
    public CookerFeatureFactoryException(String message) {
        super(message);
    }
}
