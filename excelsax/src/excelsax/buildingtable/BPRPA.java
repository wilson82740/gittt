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

import dbtable.PROTOCOL_PATIENT;

public class BPRPA {

  ArrayList<PROTOCOL_PATIENT> PRPAtable = new ArrayList<PROTOCOL_PATIENT>();

  public BPRPA() throws IOException, Exception {
    ArrayList<ArrayList> tempA = null;
    // read XLSX
    IExcelRowReader rowReader = new ExcelRowReader();
    try {
      // ExcelReaderUtil.readExcel(rowReader,
      // "E://2016-07-04-011940a.xls");
      //System.out.println("**********************************************");
      ExcelReaderUtil ERU = new ExcelReaderUtil();
      ERU.readExcel(rowReader,
          "C:\\Users\\wilson82740\\Desktop\\LIPID_DATA\\ORACLE\\PROTOCOL_PATIENT.xlsx");
      tempA = ERU.gettempArrayList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    // create BPatienttable
    for (int i = 1; i < tempA.size(); i++) {
      PROTOCOL_PATIENT BPRPAP = new PROTOCOL_PATIENT(tempA.get(i));
      PRPAtable.add(BPRPAP);
    }
    tempA.clear();
    /*for (int i = 0; i < PRPAtable.size(); i++) {
      System.out.print(PRPAtable.get(i).getPATIENTID() + " ");
      System.out.print(PRPAtable.get(i).getENROLL_DECISION_DATE() + " ");
      System.out.print(PRPAtable.get(i).getID() + " ");
      System.out.print(PRPAtable.get(i).getPROTOCOLID() + " ");
      System.out.println(PRPAtable.get(i).getENROLL_PERSONID() + "");
    }*/
  }

  public ArrayList<PROTOCOL_PATIENT> getBPRPAArrayList() {
    return PRPAtable;
  }

}
