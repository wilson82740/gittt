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

import DBTable.DATARECORD;

public class BDR {
	ArrayList<DATARECORD> DRtable = new ArrayList<DATARECORD>();

	public BDR() throws IOException, Exception {
	  ArrayList<ArrayList> tempA;
    // read XLSX
    File xlsxFile = new File(
        "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\DATARECORD.xlsx");
    ZipSecureFile.setMinInflateRatio(-1.0d);
    int minColumns = 13;
    try (OPCPackage p =
        OPCPackage.open(xlsxFile.getPath(), PackageAccess.READ)) {
      XLSX2CSV xlsx2csv = new XLSX2CSV(p, System.out, minColumns);
      xlsx2csv.process();
      tempA = xlsx2csv.getArrayList();
    }

		// create BPatienttable
		for (int i = 0; i < tempA.size(); i++) {
			DATARECORD BDRP = new DATARECORD(tempA.get(i));
			DRtable.add(BDRP);
		}
		tempA.clear();

		/*for (int i = 0; i < DRtable.size(); i++) {
			System.out.print(DRtable.get(i).getID() + " ");
			System.out.print(DRtable.get(i).getFORMVERSIONID() + " ");
			System.out.print(DRtable.get(i).getEVENTID() + " ");
			System.out.print(DRtable.get(i).getCREATEDDATE() + " ");
			System.out.println(DRtable.get(i).getLASTUPDDATE());
		}*/
	}

	public ArrayList<DATARECORD> getBDRArrayList() {
		return DRtable;
	}
}
