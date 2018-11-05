package DBTable;

import java.util.ArrayList;

public class PROTOCOL_PATIENT {

  private String PATIENTID;
  private String ENROLL_STATUS;
  private String ENROLL_DECISION_DATE;
  private String ELIGIBILITY_FLG;
  private String ID;
  private String PROTOCOLID;
  private String SITEID;
  private String ENROLL_PERSONID;

  public PROTOCOL_PATIENT(ArrayList<String> parameter) {
    setPATIENTID(parameter.get(0));
    setENROLL_STATUS(parameter.get(1));
    setENROLL_DECISION_DATE(parameter.get(2));
    setELIGIBILITY_FLG(parameter.get(3));
    setID(parameter.get(4));
    setPROTOCOLID(parameter.get(5));
    setSITEID(parameter.get(6));
    setENROLL_PERSONID(parameter.get(7));
  }

  private void setPATIENTID(String PID) {
    this.PATIENTID = PID;
  }

  public String getPATIENTID() {
    return this.PATIENTID;
  }

  private void setENROLL_STATUS(String ES) {
    this.ENROLL_STATUS = ES;
  }

  public String getENROLL_STATUS() {
    return this.ENROLL_STATUS;
  }

  private void setENROLL_DECISION_DATE(String EDD) {
    this.ENROLL_DECISION_DATE = EDD;
  }

  public String getENROLL_DECISION_DATE() {
    return this.ENROLL_DECISION_DATE;
  }

  private void setELIGIBILITY_FLG(String EF) {
    this.ELIGIBILITY_FLG = EF;
  }

  public String getELIGIBILITY_FLG() {
    return this.ELIGIBILITY_FLG;
  }

  private void setID(String id) {
    this.ID = id;
  }

  public String getID() {
    return this.ID;
  }

  private void setPROTOCOLID(String PRID) {
    this.PROTOCOLID = PRID;
  }

  public String getPROTOCOLID() {
    return this.PROTOCOLID;
  }

  private void setSITEID(String SID) {
    this.SITEID = SID;
  }

  public String getSITEID() {
    return this.SITEID;
  }

  private void setENROLL_PERSONID(String EPID) {
    this.ENROLL_PERSONID = EPID;
  }

  public String getENROLL_PERSONID() {
    return this.ENROLL_PERSONID;
  }

}
