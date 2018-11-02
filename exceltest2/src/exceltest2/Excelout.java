package exceltest2;

import java.awt.Color;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DBTable.ExcelFormParameter;

public class Excelout {

  public Excelout() {}

  public Excelout(ArrayList<ExcelFormParameter> ExcelFormtable) {
    Collections.sort(ExcelFormtable, new Comparator<ExcelFormParameter>() {
      public int compare(ExcelFormParameter o1, ExcelFormParameter o2) {
        return o1.getPatient_Name().compareTo(o2.getPatient_Name());
      }
    });
    out(ExcelFormtable);
  }

  private void out(ArrayList<ExcelFormParameter> ExcelFormtable) {

    try {
      XSSFWorkbook wb = new XSSFWorkbook();
      XSSFFont Font1 = wb.createFont();
      XSSFFont Font2 = wb.createFont();
      Font1.setFontName("Calibri");
      Font1.setColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
      Font1.setBold(true);
      Font2.setFontName("新細明體");
      XSSFCellStyle Style1 = wb.createCellStyle();
      XSSFCellStyle Style2 = wb.createCellStyle();
      Style1.setFont(Font1);
      Style1
          .setBottomBorderColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
      Style1.setTopBorderColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
      Style1.setBorderBottom(BorderStyle.MEDIUM);
      Style1.setBorderTop(BorderStyle.MEDIUM);
      Style2.setFont(Font2);
      XSSFSheet sheet = wb.createSheet("EXPORT");

      Row row = null;

      Cell cell = null;
      for (int rowIndex = 0; rowIndex < ExcelFormtable.size() + 4; rowIndex++) {// ExcelFormtable.size()

        row = sheet.createRow(rowIndex);
        if (rowIndex == 0) {
          cell = row.createCell(0);
          cell.setCellStyle(Style2);
          cell.setCellValue("Advanced Export");
          cell = row.createCell(6);
          cell.setCellStyle(Style2);
          cell.setCellValue("Stand-Alone Test");
          continue;
        }
        if (rowIndex == 1) {
          cell = row.createCell(6);
          cell.setCellStyle(Style2);
          cell.setCellValue("LR06_Other Measurements at Enrollment (CRF勿漏填)");
          continue;
        }
        if (rowIndex == 3) {
          continue;
        }
        if (rowIndex == 2) {

          for (int i = 0; i < 13; i++) {
            cell = row.createCell(i);
            switch (i) {
            case 0:
              cell.setCellValue("Patient Name");
              break;
            case 1:
              cell.setCellValue("MRN");
              break;
            case 2:
              cell.setCellValue("Visit Date");
              break;
            case 3:
              cell.setCellValue("Test/Battery");
              break;
            case 4:
              cell.setCellValue("Order Filled Out");
              break;
            case 5:
              cell.setCellValue("Version");
              break;
            case 6:
              cell.setCellValue("AE_Enroll");
              break;
            case 7:
              cell.setCellValue("Muscle_Pain_Enroll");
              break;
            case 8:
              cell.setCellValue("TC_Urine_Enroll");
              break;
            case 9:
              cell.setCellValue("Other_AE_Enroll_Done");
              break;
            case 10:
              cell.setCellValue("Other_AE_Enroll_specify");
              break;
            case 11:
              cell.setCellValue("Diet_Consult_Enroll");
              break;
            case 12:
              cell.setCellValue("OtherMeasur_Enroll_Complete");
              break;
            default:
              break;
            }
            cell.setCellStyle(Style1);
          }
        } else {
          for (int i = 0; i < 13; i++) {
            cell = row.createCell(i);
            switch (i) {
            case 0:
              cell.setCellValue(
                  ExcelFormtable.get(rowIndex - 4).getPatient_Name());
              break;
            case 1:
              cell.setCellValue(ExcelFormtable.get(rowIndex - 4).getMRN());
              break;
            case 2:
              if (ExcelFormtable.get(rowIndex - 4).getVisit_Date() != null) {
                if (!ExcelFormtable.get(rowIndex - 4).getVisit_Date()
                    .matches("\\d+/\\d+/\\d+")) {
                  cell.setCellValue(
                      ExcelFormtable.get(rowIndex - 4).getVisit_Date());
                } else {
                  XSSFFont Font3 = wb.createFont();
                  XSSFCellStyle Style3 = wb.createCellStyle();
                  Font3.setFontName("新細明體");
                  Style3.setFont(Font3);
                  XSSFCreationHelper createHelper = wb.getCreationHelper();
                  Style3.setDataFormat(
                      createHelper.createDataFormat().getFormat("YYYY/MM/DD"));
                  cell.setCellValue(java.util.Date.from(java.time.LocalDate
                      .parse(ExcelFormtable.get(rowIndex - 4).getVisit_Date(),
                          java.time.format.DateTimeFormatter
                              .ofPattern("yyyy/M/d"))
                      .atStartOfDay(java.time.ZoneId.systemDefault())
                      .toOffsetDateTime().toInstant()));
                  cell.setCellStyle(Style3);
                }
              } else {
                cell.setCellValue(
                    ExcelFormtable.get(rowIndex - 4).getVisit_Date());
              }
              break;
            case 3:
              cell.setCellValue(
                  ExcelFormtable.get(rowIndex - 4).getTestBattery());
              break;
            case 4:
              cell.setCellValue(
                  ExcelFormtable.get(rowIndex - 4).getOrder_Filled_Out());
              break;
            case 5:
              cell.setCellValue(ExcelFormtable.get(rowIndex - 4).getVersion());
              break;
            case 6:
              cell.setCellValue(
                  ExcelFormtable.get(rowIndex - 4).getAE_Enroll());
              break;
            case 7:
              cell.setCellValue(
                  ExcelFormtable.get(rowIndex - 4).getMuscle_Pain_Enroll());
              break;
            case 8:
              cell.setCellValue(
                  ExcelFormtable.get(rowIndex - 4).getTC_Urine_Enroll());
              break;
            case 9:
              cell.setCellValue(
                  ExcelFormtable.get(rowIndex - 4).getOther_AE_Enroll_Done());
              break;
            case 10:
              cell.setCellValue(ExcelFormtable.get(rowIndex - 4)
                  .getOther_AE_Enroll_specify());
              break;
            case 11:
              cell.setCellValue(
                  ExcelFormtable.get(rowIndex - 4).getDiet_Consult_Enroll());
              break;
            case 12:
              cell.setCellValue(ExcelFormtable.get(rowIndex - 4)
                  .getOtherMeasur_Enroll_Complete());
              break;
            default:
              break;
            }
            if (i != 2 )
              cell.setCellStyle(Style2);
          }
        }
      }
      sheet.autoSizeColumn(2);
      FileOutputStream fileOut =
          new FileOutputStream("C:\\Users\\wilson82740\\Desktop\\test2.xlsx");
      wb.write(fileOut);
      fileOut.close();
      System.out.println("匯出Excel End");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
