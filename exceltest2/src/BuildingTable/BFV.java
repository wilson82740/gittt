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

import DBTable.FORMVERSION;

public class BFV {
  ArrayList<FORMVERSION> FVtable = new ArrayList<FORMVERSION>();

  public BFV() throws IOException, Exception {
    ArrayList<ArrayList> tempA;
    // read XLSX
    File xlsxFile = new File(
        "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\FORMVERSION.xlsx");
    ZipSecureFile.setMinInflateRatio(-1.0d);
    int minColumns = 5;
    try (OPCPackage p =
        OPCPackage.open(xlsxFile.getPath(), PackageAccess.READ)) {
      XLSX2CSV xlsx2csv = new XLSX2CSV(p, System.out, minColumns);
      xlsx2csv.process();
      tempA = xlsx2csv.getArrayList();
    }

    // create BPatienttable
    for (int i = 0; i < tempA.size(); i++) {
      FORMVERSION BFVP = new FORMVERSION(tempA.get(i));
      FVtable.add(BFVP);
    }
    tempA.clear();
    /*
     * for (int i = 0; i < FVtable.size(); i++) {
     * System.out.print(FVtable.get(i).getID() + " ");
     * System.out.print(FVtable.get(i).getCURRENT_FLG() + " ");
     * System.out.print(FVtable.get(i).getFORMID() + " ");
     * System.out.print(FVtable.get(i).getFORMVERSION() + " ");
     * System.out.println(FVtable.get(i).getVERSIONDATE()); }
     */
  }

  public ArrayList<FORMVERSION> getBFVArrayList() {
    return FVtable;
  }
}
