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

import dbtable.DATARECORD;

public class BDR {
  ArrayList<DATARECORD> DRtable = new ArrayList<DATARECORD>();

  public BDR() throws IOException, Exception {

    ArrayList<ArrayList> tempA = null;
    // read XLSX
    IExcelRowReader rowReader = new ExcelRowReader();
    try {
      // ExcelReaderUtil.readExcel(rowReader,
      // "E://2016-07-04-011940a.xls");
      //System.out.println("**********************************************");
      ExcelReaderUtil ERU = new ExcelReaderUtil();
      ERU.readExcel(rowReader,
          "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\DATARECORD.xlsx");
      tempA = ERU.gettempArrayList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    // create BPatienttable
    for (int i = 1; i < tempA.size(); i++) {
      DATARECORD BDRP = new DATARECORD(tempA.get(i));
      DRtable.add(BDRP);
    }
    tempA.clear();

    /*
     * for (int i = 0; i < DRtable.size(); i++) {
     * System.out.print(DRtable.get(i).getID() + " ");
     * System.out.print(DRtable.get(i).getFORMVERSIONID() + " ");
     * System.out.print(DRtable.get(i).getEVENTID() + " ");
     * System.out.print(DRtable.get(i).getCREATEDDATE() + " ");
     * System.out.println(DRtable.get(i).getLASTUPDDATE()); }
     */
  }

  public ArrayList<DATARECORD> getBDRArrayList() {
    return DRtable;
  }
}
