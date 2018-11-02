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

import DBTable.DATAPOINTDATARECORD;

public class BDPDR {
  ArrayList<DATAPOINTDATARECORD> DPDRtable =
      new ArrayList<DATAPOINTDATARECORD>();

  public BDPDR() throws IOException, Exception {
    ArrayList<ArrayList> tempA;
    // read XLSX
    File xlsxFile = new File(
        "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\DATAPOINTDATARECORD.xlsx");
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
      DATAPOINTDATARECORD BDPDRP = new DATAPOINTDATARECORD(tempA.get(i));
      DPDRtable.add(BDPDRP);
    }
    tempA.clear();

    /*
     * for (int i = 0; i < DPDRtable.size(); i++) {
     * System.out.print(DPDRtable.get(i).getID() + " ");
     * System.out.print(DPDRtable.get(i).getDATAPOINTID() + " ");
     * System.out.print(DPDRtable.get(i).getDATARECORDID() + " ");
     * System.out.print(DPDRtable.get(i).getVALUE() + " ");
     * System.out.println(DPDRtable.get(i).getCREATORID()); }
     */

  }

  public ArrayList<DATAPOINTDATARECORD> getBDPDRArrayList() {
    return DPDRtable;
  }

}
