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

import DBTable.VISIT;

public class BVisit {
  ArrayList<VISIT> Visittable = new ArrayList<VISIT>();

  public BVisit() throws IOException, Exception {
    ArrayList<ArrayList> tempA;
    // read XLSX
    File xlsxFile = new File(
        "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\VISIT.xlsx");
    ZipSecureFile.setMinInflateRatio(-1.0d);
    int minColumns = 6;
    try (OPCPackage p =
        OPCPackage.open(xlsxFile.getPath(), PackageAccess.READ)) {
      XLSX2CSV xlsx2csv = new XLSX2CSV(p, System.out, minColumns);
      xlsx2csv.process();
      tempA = xlsx2csv.getArrayList();
    }

    // create BPatienttable
    for (int i = 0; i < tempA.size(); i++) {
      VISIT BVP = new VISIT(tempA.get(i));
      Visittable.add(BVP);
    }
    tempA.clear();
    /*
     * for (int i = 0; i < Visittable.size(); i++) {
     * System.out.print(Visittable.get(i).getVISITDATE() + " ");
     * System.out.print(Visittable.get(i).getFUTUREVISIT_FLG() + " ");
     * System.out.print(Visittable.get(i).getID() + " ");
     * System.out.print(Visittable.get(i).getPCLPATIENTID() + " ");
     * System.out.println(Visittable.get(i).getEVENTID() + ""); }
     */

  }

  public ArrayList<VISIT> getBVisitArrayList() {
    return Visittable;
  }
}
