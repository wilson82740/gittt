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

import dbtable.DATAPOINTDATARECORD;

public class BDPDR {
  ArrayList<DATAPOINTDATARECORD> DPDRtable =
      new ArrayList<DATAPOINTDATARECORD>();

  public BDPDR() throws IOException, Exception {
    ArrayList<ArrayList> tempA = null;
    // read XLSX
    IExcelRowReader rowReader = new ExcelRowReader();
    try {
      // ExcelReaderUtil.readExcel(rowReader,
      // "E://2016-07-04-011940a.xls");
      //System.out.println("**********************************************");
      ExcelReaderUtil ERU = new ExcelReaderUtil();
      ERU.readExcel(rowReader,
          "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\DATAPOINTDATARECORD.xlsx");
      tempA = ERU.gettempArrayList();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // create BPatienttable
    for (int i = 1; i < tempA.size(); i++) {
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
