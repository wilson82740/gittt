package excelsax;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;

import com.boguan.bte.service.common.IExcelRowReader;
import com.boguan.bte.service.common.impl.ExcelRowReader;
import com.boguan.bte.util.excel.ExcelReaderUtil;
import com.boguan.bte.util.excel.ExcelWriter;

import dbtable.ExcelFormParameter;
import excelsax.buildingtable.BDP;
import excelsax.buildingtable.BDPDR;
import excelsax.buildingtable.BDR;
import excelsax.buildingtable.BFV;
import excelsax.buildingtable.BForm;
import excelsax.buildingtable.BPRPA;
import excelsax.buildingtable.BPatient;
import excelsax.buildingtable.BVisit;
import excelsax.Excelout;
import excelsax.FindRelationship;

public class excelsaxmain {

  private static ArrayList<ArrayList> tempA;

  public static void main(String[] args) throws IOException, Exception {
    // TODO Auto-generated method stub
    long time1, time2;
    time1 = System.currentTimeMillis();
    /*BDP bdp = new BDP();
    BPatient bpa = new BPatient();
    BDPDR bdpdr = new BDPDR();
    BPRPA bprap = new BPRPA();
    BVisit bvisit = new BVisit();
    BDR bdr = new BDR();
    BForm bform = new BForm();
    BFV bfv = new BFV();
    FindRelationship FR = new FindRelationship(bdp.getBDPArrayList(),
        bpa.getBPArrayList(), bdpdr.getBDPDRArrayList(),
        bprap.getBPRPAArrayList(), bvisit.getBVisitArrayList(),
        bdr.getBDRArrayList(), bform.getFormArrayList(), bfv.getBFVArrayList());*/
    //Excelout EO = new Excelout(FR.getEFArrayList());
    
    /*ArrayList<ExcelFormParameter> EFA=FR.getEFArrayList();
    Collections.sort(EFA, new Comparator<ExcelFormParameter>() {
      public int compare(ExcelFormParameter o1, ExcelFormParameter o2) {
        return o1.getPatient_Name().compareTo(o2.getPatient_Name());
      }
    });*/
    String file = "C:\\Users\\wilson82740\\Desktop\\test5.xlsx";  
    
    ExcelWriter writer = new ExcelWriter() {  
        public void generate(Map<String, XSSFCellStyle> styles,SharedStringsTable sst,PackagePart part) throws Exception {  
          CTRst st;
            this.beginSheet();  
              
            for (int rownum = 0; rownum < 4; rownum++) {  
               
                this.insertRow(rownum);  
                
                /*if(rownum>=4)
                {
                  for(int colnum=0;colnum<13;colnum++)
                    
                    switch (colnum) {
                    case 0:
                      if(EFA.get(rownum-4).getPatient_Name()!=null)
                      {
                      st = CTRst.Factory.newInstance();
                      st.setT(EFA.get(rownum-4).getPatient_Name());
                      this.createCell(colnum, sst.addEntry( st ),-1,"s");
                      }
                      break;
                    case 1:
                      if(EFA.get(rownum-4).getMRN()!=null)
                      {
                      st = CTRst.Factory.newInstance();
                      st.setT(EFA.get(rownum-4).getMRN());
                      this.createCell(colnum, sst.addEntry( st ),-1,"s");
                      }
                      break;
                    case 2:
                      if (EFA.get(rownum - 4).getVisit_Date() != null) {
                        if (!EFA.get(rownum - 4).getVisit_Date()
                            .matches("\\d+/\\d+/\\d+")) {
                          this.createCell(colnum, EFA.get(rownum-4).getVisit_Date());
                        } else {
                          Calendar c = Calendar.getInstance();
                          c.setTime(java.util.Date.from(
                              java.time.LocalDate.parse(
                                  EFA.get(13).getVisit_Date(), 
                               java.time.format.DateTimeFormatter.ofPattern("yyyy/M/d")
                              ).atStartOfDay(java.time.ZoneId.systemDefault()).toOffsetDateTime().toInstant()
                            ));
                          this.createCell(colnum, c,styles.get("date").getIndex());
                        }
                      }
                      break;
                    case 3:
                      if(EFA.get(rownum-4).getTestBattery()!=null) {
                      st = CTRst.Factory.newInstance();
                      st.setT(EFA.get(rownum-4).getTestBattery());
                      this.createCell(colnum, sst.addEntry( st ),-1,"s");
                      }
                      break;
                    case 4:
                      if(EFA.get(rownum-4).getOrder_Filled_Out()!=null) {
                        st = CTRst.Factory.newInstance();
                        st.setT(EFA.get(rownum-4).getOrder_Filled_Out());
                        this.createCell(colnum, sst.addEntry( st ),styles.get("RightAlignment").getIndex(),"s");
                      }
                      break;
                    case 5:
                      if(EFA.get(rownum-4).getVersion()!=null) {
                        st = CTRst.Factory.newInstance();
                        st.setT(EFA.get(rownum-4).getVersion());
                        this.createCell(colnum, sst.addEntry( st ),-1,"s");
                      }
                      break;
                    case 6:
                      if(EFA.get(rownum-4).getAE_Enroll()!=null) {
                        st = CTRst.Factory.newInstance();
                        st.setT(EFA.get(rownum-4).getAE_Enroll());
                        this.createCell(colnum, sst.addEntry( st ),styles.get("RightAlignment").getIndex(),"s");
                      }
                      break;
                    case 7:
                      if(EFA.get(rownum-4).getMuscle_Pain_Enroll()!=null) {
                        st = CTRst.Factory.newInstance();
                        st.setT(EFA.get(rownum-4).getMuscle_Pain_Enroll());
                        this.createCell(colnum, sst.addEntry( st ),styles.get("RightAlignment").getIndex(),"s");
                      }
                      break;
                    case 8:
                      if(EFA.get(rownum-4).getTC_Urine_Enroll()!=null) {
                        st = CTRst.Factory.newInstance();
                        st.setT(EFA.get(rownum-4).getTC_Urine_Enroll());
                        this.createCell(colnum, sst.addEntry( st ),styles.get("RightAlignment").getIndex(),"s");
                      }
                      break;
                    case 9:
                      if(EFA.get(rownum-4).getOther_AE_Enroll_Done()!=null) {
                        st = CTRst.Factory.newInstance();
                        st.setT(EFA.get(rownum-4).getOther_AE_Enroll_Done());
                        this.createCell(colnum, sst.addEntry( st ),styles.get("RightAlignment").getIndex(),"s");
                      }
                      break;
                    case 10:
                      if(EFA.get(rownum-4).getOther_AE_Enroll_specify()!=null) {
                        st = CTRst.Factory.newInstance();
                        st.setT(EFA.get(rownum-4).getOther_AE_Enroll_specify());
                        this.createCell(colnum, sst.addEntry( st ),-1,"s");
                      }
                      break;
                    case 11:
                      if(EFA.get(rownum-4).getDiet_Consult_Enroll()!=null) {
                        st = CTRst.Factory.newInstance();
                        st.setT(EFA.get(rownum-4).getDiet_Consult_Enroll());
                        this.createCell(colnum, sst.addEntry( st ),styles.get("RightAlignment").getIndex(),"s");
                      }
                      break;
                    case 12:
                      if(EFA.get(rownum-4).getOtherMeasur_Enroll_Complete()!=null) {
                      st = CTRst.Factory.newInstance();
                      st.setT(EFA.get(rownum-4).getOtherMeasur_Enroll_Complete());
                      this.createCell(colnum, sst.addEntry( st ),-1,"s");
                      }
                      break;
                    default:
                      break;
                    }
                }*/
                if(rownum==0)
                {
                  this.createCell(0, "Advanced Export");
                  this.createCell(1, null);
                  this.createCell(6, "Stand-Alone Test");
                  this.createCell(7, null);
                }
                else if(rownum==1)
                {
                  XSSFWorkbook wb = new XSSFWorkbook();
                  XSSFRichTextString s1 = new XSSFRichTextString("LR06_Other Measurements at Enrollment (CRF¤Åº|¶ñ)");
                  XSSFFont colorFont = wb.createFont();
                  colorFont.setColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
                  s1.applyFont(colorFont);
                  /*st = CTRst.Factory.newInstance();
                  st.setT("LR06_Other Measurements at Enrollment (CRF¤Åº|¶ñ)");*/
                  this.createCell(6, sst.addSharedStringItem(s1),-1,"s");
                  this.createCell(7, null);
                }
                else if(rownum==2)
                {
                  for (int i = 0; i < 13; i++) {
                    switch (i) {
                    case 0:
                      this.createCell(i, "Patient Name",styles.get("Border").getIndex());
                      break;
                    case 1:
                      this.createCell(i, "MRN",styles.get("Border").getIndex());
                      break;
                    case 2:
                      this.createCell(i, "Visit Date",styles.get("Border").getIndex());
                      break;
                    case 3:
                      this.createCell(i, "Test/Battery",styles.get("Border").getIndex());
                      break;
                    case 4:
                      this.createCell(i, "Order Filled Out",styles.get("Border").getIndex());
                      break;
                    case 5:
                      this.createCell(i, "Version",styles.get("Border").getIndex());
                      break;
                    case 6:
                      this.createCell(i, "AE_Enroll",styles.get("Border").getIndex());
                      break;
                    case 7:
                      this.createCell(i, "Muscle_Pain_Enroll",styles.get("Border").getIndex());
                      break;
                    case 8:
                      this.createCell(i, "TC_Urine_Enroll",styles.get("Border").getIndex());
                      break;
                    case 9:
                      this.createCell(i, "Other_AE_Enroll_Done",styles.get("Border").getIndex());
                      break;
                    case 10:
                      this.createCell(i, "Other_AE_Enroll_specify",styles.get("Border").getIndex());
                      break;
                    case 11:
                      this.createCell(i, "Diet_Consult_Enroll",styles.get("Border").getIndex());
                      break;
                    case 12:
                      this.createCell(i, "OtherMeasur_Enroll_Complete",styles.get("Border").getIndex());
                      break;
                    default:
                      break;
                    }
                  }
                }
                this.endRow();  
            }  
              
           
            this.endSheet();  
            OutputStream outsst = part.getOutputStream();
            sst.writeTo(outsst);
            outsst.close();
        }
    };  
    writer.process(file);  
    time2 = System.currentTimeMillis();
    System.out.println("ªá¤F¡G" + (time2-time1)/1000 + "¬í");
    /*
     * for (int i = 0; i < tempA.size(); i++) { ArrayList tempS = tempA.get(i);
     * for (int j = 0; j < tempS.size(); j++) { System.out.print(tempS.get(j) +
     * " "); } System.out.println(); }
     */

  }

}
