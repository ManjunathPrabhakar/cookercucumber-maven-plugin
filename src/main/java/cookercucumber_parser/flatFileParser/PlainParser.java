package cookercucumber_parser.flatFileParser;

import common.fileFactory.FileUtility;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 23/09/2020
 * @project cookercucumber-maven-plugin
 */
public class PlainParser {

    /**
     * Read the Plain File and Convert that into Examples Format for Scenario Outline
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @param filePath Folder Path Only
     * @param fileName FileName with Extension (txt)
     * @return Txt Data in Examples Format
     * @throws IOException If Any
     */
    public static String readPlain(String filePath, String fileName) throws Exception {
        if (!FilenameUtils.getExtension(fileName).equalsIgnoreCase("txt")) {
            throw new Exception("Invalid Extension. Accepted(txt)");
        }

        return "Examples:\n" + FileUtility.readAndGetFileContent(filePath + "\\" + fileName);
    }
}
