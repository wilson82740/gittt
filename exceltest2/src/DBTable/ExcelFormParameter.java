package DBTable;

import java.util.ArrayList;

public class ExcelFormParameter {
  private String Patient_Name;
  private String MRN;
  private String Visit_Date;
  private String TestBattery;
  private String Order_Filled_Out;
  private String Version;
  private String AE_Enroll;
  private String Muscle_Pain_Enroll;
  private String TC_Urine_Enroll;
  private String Other_AE_Enroll_Done;
  private String Other_AE_Enroll_specify;
  private String Diet_Consult_Enroll;
  private String OtherMeasur_Enroll_Complete;

  public ExcelFormParameter(ArrayList<String> parameter) {
    setPatient_Name(parameter.get(0));
    setMRN(parameter.get(1));
    setVisit_Date(parameter.get(2));
    setTestBattery(parameter.get(3));
    setOrder_Filled_Out(parameter.get(4));
    setVersion(parameter.get(5));
    setAE_Enroll(parameter.get(6));
    setMuscle_Pain_Enroll(parameter.get(7));
    setTC_Urine_Enroll(parameter.get(8));
    setOther_AE_Enroll_Done(parameter.get(9));
    setOther_AE_Enroll_specify(parameter.get(10));
    setDiet_Consult_Enroll(parameter.get(11));
    setOtherMeasur_Enroll_Complete(parameter.get(12));
  }

  private void setPatient_Name(String PName) {
    this.Patient_Name = PName;
  }

  public String getPatient_Name() {
    return this.Patient_Name;
  }

  private void setMRN(String mrn) {
    this.MRN = mrn;
  }

  public String getMRN() {
    return this.MRN;
  }

  private void setVisit_Date(String VDate) {
    this.Visit_Date = VDate;
  }

  public String getVisit_Date() {
    return this.Visit_Date;
  }

  private void setTestBattery(String TestB) {
    this.TestBattery = TestB;
  }

  public String getTestBattery() {
    return this.TestBattery;
  }

  private void setOrder_Filled_Out(String OFO) {
    this.Order_Filled_Out = OFO;
  }

  public String getOrder_Filled_Out() {
    return this.Order_Filled_Out;
  }

  private void setVersion(String version) {
    this.Version = version;
  }

  public String getVersion() {
    return this.Version;
  }

  private void setAE_Enroll(String AEE) {
    this.AE_Enroll = AEE;
  }

  public String getAE_Enroll() {
    return this.AE_Enroll;
  }

  private void setMuscle_Pain_Enroll(String MPE) {
    this.Muscle_Pain_Enroll = MPE;
  }

  public String getMuscle_Pain_Enroll() {
    return this.Muscle_Pain_Enroll;
  }

  private void setTC_Urine_Enroll(String TUE) {
    this.TC_Urine_Enroll = TUE;
  }

  public String getTC_Urine_Enroll() {
    return this.TC_Urine_Enroll;
  }

  private void setOther_AE_Enroll_Done(String OAED) {
    this.Other_AE_Enroll_Done = OAED;
  }

  public String getOther_AE_Enroll_Done() {
    return this.Other_AE_Enroll_Done;
  }

  private void setOther_AE_Enroll_specify(String OAES) {
    this.Other_AE_Enroll_specify = OAES;
  }

  public String getOther_AE_Enroll_specify() {
    return this.Other_AE_Enroll_specify;
  }

  private void setDiet_Consult_Enroll(String DCE) {
    this.Diet_Consult_Enroll = DCE;
  }

  public String getDiet_Consult_Enroll() {
    return this.Diet_Consult_Enroll;
  }

  private void setOtherMeasur_Enroll_Complete(String OEC) {
    this.OtherMeasur_Enroll_Complete = OEC;
  }

  public String getOtherMeasur_Enroll_Complete() {
    return this.OtherMeasur_Enroll_Complete;
  }

}
