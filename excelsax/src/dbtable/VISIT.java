package dbtable;

import java.util.ArrayList;

public class VISIT {

  private String VISITDATE;
  private String FUTUREVISIT_FLG;
  private String ID;
  private String PCLPATIENTID;
  private String EVENTID;
  private String STUDYEVENTDEFID;
  private String STATUS;

  public VISIT(ArrayList<String> parameter) {
    setVISITDATE(parameter.get(0));
    setFUTUREVISIT_FLG(parameter.get(1));
    setID(parameter.get(2));
    setPCLPATIENTID(parameter.get(3));
    setEVENTID(parameter.get(4));
    setSTUDYEVENTDEFID(parameter.get(5));
    setSTATUS(parameter.get(6));
  }

  private void setVISITDATE(String VD) {
    this.VISITDATE = VD;
  }

  public String getVISITDATE() {
    return this.VISITDATE;
  }

  private void setFUTUREVISIT_FLG(String FFLG) {
    this.FUTUREVISIT_FLG = FFLG;
  }

  public String getFUTUREVISIT_FLG() {
    return this.FUTUREVISIT_FLG;
  }

  private void setID(String id) {
    this.ID = id;
  }

  public String getID() {
    return this.ID;
  }

  private void setPCLPATIENTID(String PID) {
    this.PCLPATIENTID = PID;
  }

  public String getPCLPATIENTID() {
    return this.PCLPATIENTID;
  }

  private void setEVENTID(String EID) {
    this.EVENTID = EID;
  }

  public String getEVENTID() {
    return this.EVENTID;
  }

  private void setSTUDYEVENTDEFID(String SEID) {
    this.STUDYEVENTDEFID = SEID;
  }

  public String getSTUDYEVENTDEFID() {
    return this.STUDYEVENTDEFID;
  }

  private void setSTATUS(String status) {
    this.STATUS = status;
  }

  public String getSTATUS() {
    return this.STATUS;
  }
}
