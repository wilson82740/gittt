package excelsax.buildingtable;

import java.io.File;
import java.io.FileInputStream;
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

import dbtable.FORM;

public class BForm {
  ArrayList<FORM> Formtable = new ArrayList<FORM>();

  public BForm() throws IOException, Exception {

    ArrayList<ArrayList> tempA = null;
    // read XLSX
    IExcelRowReader rowReader = new ExcelRowReader();
    try {
      // ExcelReaderUtil.readExcel(rowReader,
      // "E://2016-07-04-011940a.xls");
      //System.out.println("**********************************************");
      ExcelReaderUtil ERU = new ExcelReaderUtil();
      ERU.readExcel(rowReader,
          "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\FORM.xlsx");
      tempA = ERU.gettempArrayList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    // create BPatienttable
    for (int i = 1; i < tempA.size(); i++) {
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
