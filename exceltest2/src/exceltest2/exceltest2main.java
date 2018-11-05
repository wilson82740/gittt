package exceltest2;

import java.io.IOException;
import java.util.ArrayList;

import DBTable.ExcelFormParameter;
import BuildingTable.BDP;
import BuildingTable.BDPDR;
import BuildingTable.BDR;
import BuildingTable.BFV;
import BuildingTable.BForm;
import BuildingTable.BPRPA;
import BuildingTable.BPatient;
import BuildingTable.BVisit;

public class exceltest2main {

  public static void main(String[] args) throws IOException, Exception {
    // TODO Auto-generated method stub
    long time1, time2;
    time1 = System.currentTimeMillis();
    BDP bdp = new BDP();
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
        bdr.getBDRArrayList(), bform.getFormArrayList(), bfv.getBFVArrayList());
    Excelout EO = new Excelout(FR.getEFArrayList());
    
    time2 = System.currentTimeMillis();
    System.out.println("ªá¤F¡G" + (time2-time1)/1000 + "¬í");
    /*ArrayList<ExcelFormParameter> aaa = FR.getEFArrayList();
    for (int i = 0; i < aaa.size(); i++) {
      System.out.print(aaa.get(i).getPatient_Name() + " ");
      System.out.print(aaa.get(i).getMRN() + " ");
      System.out.print(aaa.get(i).getVisit_Date() + " ");
      System.out.print(aaa.get(i).getTestBattery() + " ");
      System.out.print(aaa.get(i).getOrder_Filled_Out()+" ");
      System.out.print(aaa.get(i).getVersion()+" ");
      System.out.print(aaa.get(i).getAE_Enroll()+" ");
      System.out.print(aaa.get(i).getMuscle_Pain_Enroll()+" ");
      System.out.print(aaa.get(i).getTC_Urine_Enroll()+" ");
      System.out.print(aaa.get(i).getOther_AE_Enroll_Done()+" ");
      System.out.print(aaa.get(i).getOther_AE_Enroll_specify()+" ");
      System.out.print(aaa.get(i).getDiet_Consult_Enroll()+" ");
      System.out.println(aaa.get(i).getOtherMeasur_Enroll_Complete());
    }*/

  }

}
