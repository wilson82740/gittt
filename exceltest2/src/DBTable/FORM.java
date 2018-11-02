package DBTable;

import java.util.ArrayList;

public class FORM {
  private String TITLE;
  private String COMPLETE_BY;
  private String ID;
  private String TYPE;
  private String URL;
  private String DCPID;
  private String INTERNAL_CODE;
  private String INDEPENDENT_FILLOUT_FLG;
  private String LOCKVERSION_FLG;
  private String PCLGROUP_ID;
  private String PRE_POP_FLG;
  private String DISPLAY_PREVIOUS_FLG;
  private String PRE_FILL_FLG;

  public FORM(ArrayList<String> parameter) {
    setTITLE(parameter.get(0));
    setCOMPLETE_BY(parameter.get(1));
    setID(parameter.get(2));
    setTYPE(parameter.get(3));
    setURL(parameter.get(4));
    setDCPID(parameter.get(5));
    setINTERNAL_CODE(parameter.get(6));
    setINDEPENDENT_FILLOUT_FLG(parameter.get(7));
    setLOCKVERSION_FLG(parameter.get(8));
    setPCLGROUP_ID(parameter.get(9));
    setPRE_POP_FLG(parameter.get(10));
    setDISPLAY_PREVIOUS_FLG(parameter.get(11));
    setPRE_FILL_FLG(parameter.get(12));
  }

  private void setTITLE(String title) {
    this.TITLE = title;
  }

  public String getTITLE() {
    return this.TITLE;
  }

  private void setCOMPLETE_BY(String CB) {
    this.COMPLETE_BY = CB;
  }

  public String getCOMPLETE_BY() {
    return this.COMPLETE_BY;
  }

  private void setID(String id) {
    this.ID = id;
  }

  public String getID() {
    return this.ID;
  }

  private void setTYPE(String type) {
    this.TYPE = type;
  }

  public String getTYPE() {
    return this.TYPE;
  }

  private void setURL(String url) {
    this.URL = url;
  }

  public String getURL() {
    return this.URL;
  }

  private void setDCPID(String DID) {
    this.DCPID = DID;
  }

  public String getDCPID() {
    return this.DCPID;
  }

  private void setINTERNAL_CODE(String IC) {
    this.INTERNAL_CODE = IC;
  }

  public String getINTERNAL_CODE() {
    return this.INTERNAL_CODE;
  }

  private void setINDEPENDENT_FILLOUT_FLG(String IFFLG) {
    this.INDEPENDENT_FILLOUT_FLG = IFFLG;
  }

  public String getINDEPENDENT_FILLOUT_FLG() {
    return this.INDEPENDENT_FILLOUT_FLG;
  }

  private void setLOCKVERSION_FLG(String LFLG) {
    this.LOCKVERSION_FLG = LFLG;
  }

  public String getLOCKVERSION_FLG() {
    return this.LOCKVERSION_FLG;
  }

  private void setPCLGROUP_ID(String PGID) {
    this.PCLGROUP_ID = PGID;
  }

  public String getPCLGROUP_ID() {
    return this.PCLGROUP_ID;
  }

  private void setPRE_POP_FLG(String PPFLG) {
    this.PRE_POP_FLG = PPFLG;
  }

  public String getPRE_POP_FLG() {
    return this.PRE_POP_FLG;
  }

  private void setDISPLAY_PREVIOUS_FLG(String DPFLG) {
    this.DISPLAY_PREVIOUS_FLG = DPFLG;
  }

  public String getDISPLAY_PREVIOUS_FLG() {
    return this.DISPLAY_PREVIOUS_FLG;
  }

  private void setPRE_FILL_FLG(String PFFLG) {
    this.PRE_FILL_FLG = PFFLG;
  }

  public String getPRE_FILL_FLG() {
    return this.PRE_FILL_FLG;
  }
}
