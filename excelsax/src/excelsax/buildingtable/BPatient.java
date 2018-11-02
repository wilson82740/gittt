package excelsax.buildingtable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.boguan.bte.service.common.IExcelRowReader;
import com.boguan.bte.service.common.impl.ExcelRowReader;
import com.boguan.bte.util.excel.ExcelReaderUtil;

import dbtable.PATIENT;

public class BPatient {
  ArrayList<PATIENT> Patienttable = new ArrayList<PATIENT>();

  public BPatient() throws IOException, Exception {
    ArrayList<ArrayList> tempA = null;
    // read XLSX
    IExcelRowReader rowReader = new ExcelRowReader();
    try {
      // ExcelReaderUtil.readExcel(rowReader,
      // "E://2016-07-04-011940a.xls");
      //System.out.println("**********************************************");
      ExcelReaderUtil ERU = new ExcelReaderUtil();
      ERU.readExcel(rowReader,
          "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\PATIENT.xlsx");
      tempA = ERU.gettempArrayList();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // create BPatienttable
    for (int i = 1; i < tempA.size(); i++) {
      PATIENT BPP = new PATIENT(tempA.get(i));
      Patienttable.add(BPP);
    }
    tempA.clear();
    /*
     * for (int i = 0; i < Patienttable.size(); i++) {
     * System.out.print(Patienttable.get(i).getPATIENTID() + " ");
     * System.out.print(Patienttable.get(i).getMRN() + " ");
     * System.out.print(Patienttable.get(i).getLAST_NAME() + " ");
     * System.out.print(Patienttable.get(i).getFIRST_NAME() + " ");
     * System.out.println(Patienttable.get(i).getSALUTATION()); }
     */

  }

  public ArrayList<PATIENT> getBPArrayList() {
    return Patienttable;
  }
}
