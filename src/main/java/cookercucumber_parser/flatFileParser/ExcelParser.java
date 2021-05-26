package cookercucumber_parser.flatFileParser;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelParser {

    /**
     * Read the Excel File and Convert that into Examples Format for Scenario Outline
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @param filePath  Folder Path Only
     * @param fileName  FileName with Extension (xlsx/xls)
     * @param sheetName Sheetname inside the excel
     * @return Excel Data in Examples Format
     * @throws IOException If Any
     */
    public static String readExcel(String filePath, String fileName, String sheetName) throws Exception {

        StringBuilder exampleFromExcel = new StringBuilder();
        exampleFromExcel.append("Examples:");
        exampleFromExcel.append(System.getProperty("line.separator"));

        //Create an object of File class to open xlsx files
        File file = new File(filePath + "\\" + fileName);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        Workbook excWorkbook = null;

        //Find the file extension by splitting file name in substring  and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));


        if (!(FilenameUtils.getExtension(fileName).equalsIgnoreCase("xlsx") ||
                FilenameUtils.getExtension(fileName).equalsIgnoreCase("xls"))) {
            throw new Exception("Invalid Extension. Accepted(xlsx or xls)");
        }


        //Check condition if the file is xlsx file
        if (fileExtensionName.equals(".xlsx")) {
            //If it is xlsx file then create object of XSSFWorkbook class
            excWorkbook = new XSSFWorkbook(inputStream);
        }
        //Check condition if the file is xls file
        else if (fileExtensionName.equals(".xls")) {
            //If it is xls file then create object of HSSFWorkbook class
            excWorkbook = new HSSFWorkbook(inputStream);
        }else{
            throw new Exception("Unsupported Excel Extension! (Supported .xlsx & .xls)");
        }

        //Read sheet inside the workbook by its name
        Sheet excSheet = excWorkbook.getSheet(sheetName);

        //Find number of rows in excel file
        int rowCount = excSheet.getLastRowNum() - excSheet.getFirstRowNum();

        //Create a loop over all the rows of excel file to read it
        for (int i = 0; i < rowCount + 1; i++) {
            Row row = excSheet.getRow(i);
            //Create a loop to print cell values in a row
            exampleFromExcel.append("|");
            for (int j = 0; j < row.getLastCellNum(); j++) {
                //Print Excel data in console
                Cell cell = row.getCell(j);
                DataFormatter dataFormatter = new DataFormatter();
                String value = dataFormatter.formatCellValue(cell);

                exampleFromExcel.append(value/*cell.getStringCellValue()*/);
                exampleFromExcel.append("|");
            }

            exampleFromExcel.append(System.getProperty("line.separator"));
        }

        inputStream.close();


        return exampleFromExcel.toString();

    }

}