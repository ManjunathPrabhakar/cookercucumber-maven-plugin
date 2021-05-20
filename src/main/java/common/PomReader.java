package common;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PomReader {

    Model pomModel = null;

    private void init() throws Exception {
        File pomFile = new File(System.getProperty("user.dir") + "\\pom.xml");

        Reader reader = null;
        try {
            reader = new FileReader(pomFile);
            MavenXpp3Reader xpp3Reader = new MavenXpp3Reader();
            Model model = xpp3Reader.read(reader);
            System.out.println("model.getVersion() = " + model.getVersion());
            System.out.println("model.getArtifactId() = " + model.getArtifactId());
            System.out.println("model.getName() = " + model.getName());

        } catch (Exception xppe) {
            System.err.println("Unable to parse " + pomFile.getAbsolutePath() + "\n" + xppe);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                // no-op
            }
        }
    }
}
