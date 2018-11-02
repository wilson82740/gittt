package com.boguan.bte.util.excel;

import java.util.ArrayList;

import org.apache.poi.openxml4j.util.ZipSecureFile;

import com.boguan.bte.service.common.IExcelRowReader;
import com.boguan.bte.service.common.impl.ExcelRowReader;

/**
 * ��妍: ExcelReaderUtil.java<br>
 * ��膩: <br>
 * 蝐餃��: JAVA<br>
 * ��餈耨���:2016撟�7���5� 銝��10:10:20<br>
 * 
 * @since 2016撟�7���5�
 * @author ���
 */
public class ExcelReaderUtil {
  // excel2003�撅��
  public static final String EXCEL03_EXTENSION = ".xls";
  // excel2007�撅��
  public static final String EXCEL07_EXTENSION = ".xlsx";

  private static ArrayList<ArrayList> tempA;
  /**
   * 霂餃�xcel��辣嚗��03銋��07��
   * 
   * @param excel03
   * @param excel07
   * @param fileName
   * @throws Exception
   */
  public static void readExcel(IExcelRowReader reader, String fileName)
      throws Exception {
    // 憭�xcel2003��辣
    if (fileName.endsWith(EXCEL03_EXTENSION)) {
      ZipSecureFile.setMinInflateRatio(-1.0d);
      ExcelXlsReader exceXls = new ExcelXlsReader();
      exceXls.setRowReader(reader);
      exceXls.process(fileName);
      // 憭�xcel2007��辣
    } else if (fileName.endsWith(EXCEL07_EXTENSION)) {
      ZipSecureFile.setMinInflateRatio(-1.0d);
      ExcelXlsxReader exceXlsx = new ExcelXlsxReader();
      exceXlsx.setRowReader(reader);
      exceXlsx.process(fileName);
      tempA=exceXlsx.gettempArrayList();
    } else {
      throw new Exception("��辣�撘�秤嚗ileName��撅���xls��lsx��");
    }
  }
  
  public ArrayList<ArrayList> gettempArrayList() {
    return tempA;
  }

  /**
   * 瘚��
   * 
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    IExcelRowReader rowReader = new ExcelRowReader();
    ExcelReaderUtil.readExcel(rowReader, "E://test.xls");
  }
}