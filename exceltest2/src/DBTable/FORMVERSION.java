package DBTable;

import java.util.ArrayList;

public class FORMVERSION {

  private String ID;
  private String CURRENT_FLG;
  private String FORMID;
  private String FORMVERSION;
  private String VERSIONDATE;
  private String CUSTOM_FORMAT;

  public FORMVERSION(ArrayList<String> parameter) {
    setID(parameter.get(0));
    setCURRENT_FLG(parameter.get(1));
    setFORMID(parameter.get(2));
    setFORMVERSION(parameter.get(3));
    setVERSIONDATE(parameter.get(4));
    setCUSTOM_FORMAT(parameter.get(5));
  }

  private void setID(String id) {
    this.ID = id;
  }

  public String getID() {
    return this.ID;
  }

  private void setCURRENT_FLG(String CFLG) {
    this.CURRENT_FLG = CFLG;
  }

  public String getCURRENT_FLG() {
    return this.CURRENT_FLG;
  }

  private void setFORMID(String FID) {
    this.FORMID = FID;
  }

  public String getFORMID() {
    return this.FORMID;
  }

  private void setFORMVERSION(String FV) {
    this.FORMVERSION = FV;
  }

  public String getFORMVERSION() {
    return this.FORMVERSION;
  }

  private void setVERSIONDATE(String VD) {
    this.VERSIONDATE = VD;
  }

  public String getVERSIONDATE() {
    return this.VERSIONDATE;
  }

  private void setCUSTOM_FORMAT(String CF) {
    this.CUSTOM_FORMAT = CF;
  }

  public String getCUSTOM_FORMAT() {
    return this.CUSTOM_FORMAT;
  }
}
