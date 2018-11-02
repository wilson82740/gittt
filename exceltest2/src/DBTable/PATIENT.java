package DBTable;

import java.util.ArrayList;

public class PATIENT {

  private String PATIENTID;
  private String MRN;
  private String LAST_NAME;
  private String FIRST_NAME;
  private String PHONE;
  private String GENDER;
  private String DOB;
  private String ETHNICITY;
  private String RACE;
  private String STREET_ADDRESS_1;
  private String STREET_ADDRESS_2;
  private String CITY;
  private String STATE_CD;
  private String ZIP;
  private String ALT_PHONE;
  private String SALUTATION;
  private String COUNTRY;
  private String NOTE;
  private String AUTHKEY;
  private String USERNAME;
  private String SYSTEMACCESS;
  private String HANDNESS;
  private String OCCUPATION;

  public PATIENT(ArrayList<String> parameter) {
    setPATIENTID(parameter.get(0));
    setMRN(parameter.get(1));
    setLAST_NAME(parameter.get(2));
    setFIRST_NAME(parameter.get(3));
    setPHONE(parameter.get(4));
    setGENDER(parameter.get(5));
    setDOB(parameter.get(6));
    setETHNICITY(parameter.get(7));
    setRACE(parameter.get(8));
    setSTREET_ADDRESS_1(parameter.get(9));
    setSTREET_ADDRESS_2(parameter.get(10));
    setCITY(parameter.get(11));
    setSTATE_CD(parameter.get(12));
    setZIP(parameter.get(13));
    setALT_PHONE(parameter.get(14));
    setSALUTATION(parameter.get(15));
    setCOUNTRY(parameter.get(16));
    setNOTE(parameter.get(17));
    setAUTHKEY(parameter.get(18));
    setUSERNAME(parameter.get(19));
    setSYSTEMACCESS(parameter.get(20));
    setHANDNESS(parameter.get(21));
    setOCCUPATION(parameter.get(22));
  }

  private void setPATIENTID(String PID) {
    this.PATIENTID = PID;
  }

  public String getPATIENTID() {
    return this.PATIENTID;
  }

  private void setMRN(String mrn) {
    this.MRN = mrn;
  }

  public String getMRN() {
    return this.MRN;
  }

  private void setLAST_NAME(String LN) {
    this.LAST_NAME = LN;
  }

  public String getLAST_NAME() {
    return this.LAST_NAME;
  }

  private void setFIRST_NAME(String FN) {
    this.FIRST_NAME = FN;
  }

  public String getFIRST_NAME() {
    return this.FIRST_NAME;
  }

  private void setPHONE(String phone) {
    this.PHONE = phone;
  }

  public String getPHONE() {
    return this.PHONE;
  }

  private void setGENDER(String gender) {
    this.GENDER = gender;
  }

  public String getGENDER() {
    return this.GENDER;
  }

  private void setDOB(String dob) {
    this.DOB = dob;
  }

  public String getDOB() {
    return this.DOB;
  }

  private void setETHNICITY(String EC) {
    this.ETHNICITY = EC;
  }

  public String getETHNICITY() {
    return this.ETHNICITY;
  }

  private void setRACE(String race) {
    this.RACE = race;
  }

  public String getRACE() {
    return this.RACE;
  }

  private void setSTREET_ADDRESS_1(String SA1) {
    this.STREET_ADDRESS_1 = SA1;
  }

  public String getSTREET_ADDRESS_1() {
    return this.STREET_ADDRESS_1;
  }

  private void setSTREET_ADDRESS_2(String SA2) {
    this.STREET_ADDRESS_2 = SA2;
  }

  public String getSTREET_ADDRESS_2() {
    return this.STREET_ADDRESS_2;
  }

  private void setCITY(String city) {
    this.CITY = city;
  }

  public String getCITY() {
    return this.CITY;
  }

  private void setSTATE_CD(String SCD) {
    this.STATE_CD = SCD;
  }

  public String getSTATE_CD() {
    return this.STATE_CD;
  }

  private void setZIP(String zip) {
    this.ZIP = zip;
  }

  public String getZIP() {
    return this.ZIP;
  }

  private void setALT_PHONE(String AP) {
    this.ALT_PHONE = AP;
  }

  public String getALT_PHONE() {
    return this.ALT_PHONE;
  }

  private void setSALUTATION(String SAtion) {
    this.SALUTATION = SAtion;
  }

  public String getSALUTATION() {
    return this.SALUTATION;
  }

  private void setCOUNTRY(String country) {
    this.COUNTRY = country;
  }

  public String getCOUNTRY() {
    return this.COUNTRY;
  }

  private void setNOTE(String note) {
    this.NOTE = note;
  }

  public String getNOTE() {
    return this.NOTE;
  }

  private void setAUTHKEY(String AK) {
    this.AUTHKEY = AK;
  }

  public String getAUTHKEY() {
    return this.AUTHKEY;
  }

  private void setUSERNAME(String UN) {
    this.USERNAME = UN;
  }

  public String getUSERNAME() {
    return this.USERNAME;
  }

  private void setSYSTEMACCESS(String SAccess) {
    this.SYSTEMACCESS = SAccess;
  }

  public String getSYSTEMACCESS() {
    return this.SYSTEMACCESS;
  }

  private void setHANDNESS(String HN) {
    this.HANDNESS = HN;
  }

  public String getHANDNESS() {
    return this.HANDNESS;
  }

  private void setOCCUPATION(String OA) {
    this.OCCUPATION = OA;
  }

  public String getOCCUPATION() {
    return this.OCCUPATION;
  }
}
