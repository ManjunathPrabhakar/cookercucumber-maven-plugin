package CookerCucumberMavenPlugin.FeatureFactory;

import gherkin.ast.DataTable;
import gherkin.ast.Location;
import gherkin.ast.TableCell;
import gherkin.ast.TableRow;

import java.util.List;

public class DataTableUtils implements DatatableI {

    private DataTable dataTable = null;
    private StringBuilder dtResult = new StringBuilder();

    /**
     * Constructor to initilize Datatable Object
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     * @param pdataTable Object of Datatable
     */
    public DataTableUtils(DataTable pdataTable) {
        this.dataTable = pdataTable;
    }

    /**
     * Read the Datatable Object and Parse it and get it's Content in as String
     *  <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @return String Content of Datatable Object
     */
    public String getDataTableData() {

        try {
            Location location = dataTable.getLocation();
            int dLineNum = location.getLine();
            int dColNum = location.getColumn();


            List<TableRow> listrows = this.dataTable.getRows();

            for (TableRow row : listrows) {
                List<TableCell> cells = row.getCells();
                this.dtResult.append("|");
                for (TableCell cell : cells) {
                    String sCellVal = cell.getValue();
                    this.dtResult.append(sCellVal).append("|");

                }
                this.dtResult.append(System.getProperty("line.separator"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(this.dtResult);
    }


}
