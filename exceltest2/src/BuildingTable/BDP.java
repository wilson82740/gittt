package BuildingTable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.eventusermodel.XLSX2CSV;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

import DBTable.DadaPoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BDP {
  ArrayList<DadaPoint> DPtable = new ArrayList<DadaPoint>();

  public BDP() throws IOException, InvalidOperationException, Exception {
    ArrayList<ArrayList> tempA;
    // read XLSX
    File xlsxFile = new File(
        "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\DATAPOINT.xlsx");
    ZipSecureFile.setMinInflateRatio(-1.0d);
    int minColumns = 12;
    try (OPCPackage p =
        OPCPackage.open(xlsxFile.getPath(), PackageAccess.READ)) {
      XLSX2CSV xlsx2csv = new XLSX2CSV(p, System.out, minColumns);
      xlsx2csv.process();
      tempA = xlsx2csv.getArrayList();
    }

    // create DPtable
    for (int i = 0; i < tempA.size(); i++) {
      DadaPoint DPP = new DadaPoint(tempA.get(i));
      DPtable.add(DPP);
    }
    tempA.clear();
    /*
     * for (int i = 0; i < DPtable.size(); i++) {
     * System.out.print(DPtable.get(i).getID() + " ");
     * System.out.print(DPtable.get(i).getMEASUNITID() + " ");
     * System.out.print(DPtable.get(i).getNAME() + " ");
     * System.out.print(DPtable.get(i).getDCPID() + " ");
     * System.out.println(DPtable.get(i).getINTERNAL_CODE()); }
     */
  }

  public ArrayList<DadaPoint> getBDPArrayList() {
    return DPtable;
  }

}
