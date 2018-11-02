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

import DBTable.PROTOCOL_PATIENT;

public class BPRPA {

  ArrayList<PROTOCOL_PATIENT> PRPAtable = new ArrayList<PROTOCOL_PATIENT>();

  public BPRPA() throws IOException, Exception {
    ArrayList<ArrayList> tempA;
    // read XLSX
    File xlsxFile = new File(
        "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\PROTOCOL_PATIENT.xlsx");
    ZipSecureFile.setMinInflateRatio(-1.0d);
    int minColumns = 7;
    try (OPCPackage p =
        OPCPackage.open(xlsxFile.getPath(), PackageAccess.READ)) {
      XLSX2CSV xlsx2csv = new XLSX2CSV(p, System.out, minColumns);
      xlsx2csv.process();
      tempA = xlsx2csv.getArrayList();
    }

    // create BPatienttable
    for (int i = 0; i < tempA.size(); i++) {
      PROTOCOL_PATIENT BPRPAP = new PROTOCOL_PATIENT(tempA.get(i));
      PRPAtable.add(BPRPAP);
    }
    tempA.clear();
    /*for (int i = 0; i < PRPAtable.size(); i++) {
      System.out.print(PRPAtable.get(i).getPATIENTID() + " ");
      System.out.print(PRPAtable.get(i).getENROLL_DECISION_DATE() + " ");
      System.out.print(PRPAtable.get(i).getID() + " ");
      System.out.print(PRPAtable.get(i).getPROTOCOLID() + " ");
      System.out.println(PRPAtable.get(i).getENROLL_PERSONID() + "");
    }*/
  }

  public ArrayList<PROTOCOL_PATIENT> getBPRPAArrayList() {
    return PRPAtable;
  }

}
