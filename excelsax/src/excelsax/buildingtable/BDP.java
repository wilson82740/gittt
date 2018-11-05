package excelsax.buildingtable;

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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

import com.boguan.bte.service.common.IExcelRowReader;
import com.boguan.bte.service.common.impl.ExcelRowReader;
import com.boguan.bte.util.excel.ExcelReaderUtil;

import dbtable.DadaPoint;

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
    ArrayList<ArrayList> tempA = null;
    // read XLSX
    IExcelRowReader rowReader = new ExcelRowReader();
    try {
      // ExcelReaderUtil.readExcel(rowReader,
      // "E://2016-07-04-011940a.xls");
      //System.out.println("**********************************************");
      ExcelReaderUtil ERU = new ExcelReaderUtil();
      ERU.readExcel(rowReader,
          "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\DATAPOINT.xlsx");
      tempA = ERU.gettempArrayList();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // create DPtable
    for (int i = 1; i < tempA.size(); i++) {
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
