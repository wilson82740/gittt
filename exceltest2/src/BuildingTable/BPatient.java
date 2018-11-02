package BuildingTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.eventusermodel.XLSX2CSV;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DBTable.PATIENT;

public class BPatient {
	ArrayList<PATIENT> Patienttable = new ArrayList<PATIENT>();

	public BPatient() throws IOException, Exception {
	  ArrayList<ArrayList> tempA ;
    //read XLSX
    File xlsxFile = new File("C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\PATIENT.xlsx");
    ZipSecureFile.setMinInflateRatio(-1.0d);
    int minColumns = 22;
    try (OPCPackage p =
        OPCPackage.open(xlsxFile.getPath(), PackageAccess.READ)) {
      XLSX2CSV xlsx2csv = new XLSX2CSV(p, System.out, minColumns);
      xlsx2csv.process();
      tempA=xlsx2csv.getArrayList();
    }

		// create BPatienttable
		for (int i = 0; i < tempA.size(); i++) {
			PATIENT BPP = new PATIENT(tempA.get(i));
			Patienttable.add(BPP);
		}
		tempA.clear();
		/*for (int i = 0; i < Patienttable.size(); i++) {
			System.out.print(Patienttable.get(i).getPATIENTID() + " ");
			System.out.print(Patienttable.get(i).getMRN() + " ");
			System.out.print(Patienttable.get(i).getLAST_NAME() + " ");
			System.out.print(Patienttable.get(i).getFIRST_NAME() + " ");
			System.out.println(Patienttable.get(i).getSALUTATION());
		}*/

	}

	public ArrayList<PATIENT> getBPArrayList() {
		return Patienttable;
	}
}
