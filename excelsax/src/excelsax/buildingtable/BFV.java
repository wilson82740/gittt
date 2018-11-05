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

import dbtable.FORMVERSION;

public class BFV {
  ArrayList<FORMVERSION> FVtable = new ArrayList<FORMVERSION>();

  public BFV() throws IOException, Exception {
    ArrayList<ArrayList> tempA = null;
    // read XLSX
    IExcelRowReader rowReader = new ExcelRowReader();
    try {
      // ExcelReaderUtil.readExcel(rowReader,
      // "E://2016-07-04-011940a.xls");
      //System.out.println("**********************************************");
      ExcelReaderUtil ERU = new ExcelReaderUtil();
      ERU.readExcel(rowReader,
          "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\FORMVERSION.xlsx");
      tempA = ERU.gettempArrayList();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // create BPatienttable
    for (int i = 1; i < tempA.size(); i++) {
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
