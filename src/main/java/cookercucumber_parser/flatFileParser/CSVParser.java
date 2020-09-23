package cookercucumber_parser.flatFileParser;


import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    /**
     * Read the CSV File and Convert that into Examples Format for Scenario Outline
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @param filePath  Folder Path Only
     * @param fileName  FileName with Extension (csv)
     * @param delimiter delimiter inside the csv
     * @return CSV Data in Examples Format
     * @throws IOException If Any
     */
    public static String readCSV(String filePath, String fileName, String delimiter) throws Exception {

        StringBuilder exampleFromCSV = new StringBuilder();
        exampleFromCSV.append("Examples:");
        exampleFromCSV.append(System.getProperty("line.separator"));

        //Create an object of File class to open csv file
        File file = new File(filePath + "\\" + fileName);

        List<String> acceptedDelimiters = new ArrayList<>();
        acceptedDelimiters.add(",");
        acceptedDelimiters.add(";");
        acceptedDelimiters.add("|");

        if (!FilenameUtils.getExtension(fileName).equalsIgnoreCase("csv")) {
            throw new Exception("Invalid Extension. Accepted(csv)");
        }

        if (!(acceptedDelimiters.contains(delimiter))) {
            throw new Exception("Invalid Delimiters. Accepted(,(comma) or ;(semi-colon) or |(pipe) )");
        }


        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        String[] tempArr;
        while ((line = bufferedReader.readLine()) != null) {
            tempArr = line.split(delimiter);
            exampleFromCSV.append("|");
            for (String tempStr : tempArr) {
                exampleFromCSV.append(tempStr);
                exampleFromCSV.append("|");
            }
            exampleFromCSV.append(System.getProperty("line.separator"));
        }
        bufferedReader.close();
        fileReader.close();


        return exampleFromCSV.toString();
    }

}