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

import dbtable.VISIT;

public class BVisit {
  ArrayList<VISIT> Visittable = new ArrayList<VISIT>();

  public BVisit() throws IOException, Exception {
    ArrayList<ArrayList> tempA = null;
    // read XLSX
    IExcelRowReader rowReader = new ExcelRowReader();
    try {
      // ExcelReaderUtil.readExcel(rowReader,
      // "E://2016-07-04-011940a.xls");
      //System.out.println("**********************************************");
      ExcelReaderUtil ERU = new ExcelReaderUtil();
      ERU.readExcel(rowReader,
          "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\VISIT.xlsx");
      tempA = ERU.gettempArrayList();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // create BPatienttable
    for (int i = 1; i < tempA.size(); i++) {
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
