package BuildingTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.eventusermodel.XLSX2CSV;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DBTable.FORM;

public class BForm {
  ArrayList<FORM> Formtable = new ArrayList<FORM>();

  public BForm() throws IOException, Exception {
    ArrayList<ArrayList> tempA;
    // read XLSX
    File xlsxFile = new File(
        "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\FORM.xlsx");
    ZipSecureFile.setMinInflateRatio(-1.0d);
    int minColumns = 12;
    try (OPCPackage p =
        OPCPackage.open(xlsxFile.getPath(), PackageAccess.READ)) {
      XLSX2CSV xlsx2csv = new XLSX2CSV(p, System.out, minColumns);
      xlsx2csv.process();
      tempA = xlsx2csv.getArrayList();
    }

    // create BPatienttable
    for (int i = 0; i < tempA.size(); i++) {
      FORM BFP = new FORM(tempA.get(i));
      Formtable.add(BFP);
    }
    tempA.clear();
    /*
     * for (int i = 0; i < Formtable.size(); i++) {
     * System.out.print(Formtable.get(i).getTITLE() + " ");
     * System.out.print(Formtable.get(i).getID() + " ");
     * System.out.print(Formtable.get(i).getTYPE() + " ");
     * System.out.print(Formtable.get(i).getDCPID() + " ");
     * System.out.println(Formtable.get(i).getINTERNAL_CODE()); }
     */
  }

  public ArrayList<FORM> getFormArrayList() {
    return Formtable;
  }
}
