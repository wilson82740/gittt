package DBTable;

import java.util.ArrayList;

public class DATARECORD {

  private String ID;
  private String FORMVERSIONID;
  private String FORMGROUPID;
  private String EXTERNALDATAID;
  private String STATUS;
  private String EVENTID;
  private String EVENTSEQUENCE;
  private String FILLEDOUTLABEL;
  private String CREATORID;
  private String CREATEDDATE;
  private String LASTUPDID;
  private String LASTUPDDATE;
  private String SDVALIDATION;
  private String DOUBLECHECK;

  public DATARECORD(ArrayList<String> parameter) {

    setID(parameter.get(0));
    setFORMVERSIONID(parameter.get(1));
    setFORMGROUPID(parameter.get(2));
    setEXTERNALDATAID(parameter.get(3));
    setSTATUS(parameter.get(4));
    setEVENTID(parameter.get(5));
    setEVENTSEQUENCE(parameter.get(6));
    setFILLEDOUTLABEL(parameter.get(7));
    setCREATORID(parameter.get(8));
    setCREATEDDATE(parameter.get(9));
    setLASTUPDID(parameter.get(10));
    setLASTUPDDATE(parameter.get(11));
    setSDVALIDATION(parameter.get(12));
    setDOUBLECHECK(parameter.get(13));
  }

  private void setID(String id) {
    this.ID = id;
  }

  public String getID() {
    return this.ID;
  }

  private void setFORMVERSIONID(String FVID) {
    this.FORMVERSIONID = FVID;
  }

  public String getFORMVERSIONID() {
    return this.FORMVERSIONID;
  }

  private void setFORMGROUPID(String FGID) {
    this.FORMGROUPID = FGID;
  }

  public String getFORMGROUPID() {
    return this.FORMGROUPID;
  }

  private void setEXTERNALDATAID(String EDID) {
    this.EXTERNALDATAID = EDID;
  }

  public String getEXTERNALDATAID() {
    return this.EXTERNALDATAID;
  }

  private void setSTATUS(String status) {
    this.STATUS = status;
  }

  public String getSTATUS() {
    return this.STATUS;
  }

  private void setEVENTID(String EID) {
    this.EVENTID = EID;
  }

  public String getEVENTID() {
    return this.EVENTID;
  }

  private void setEVENTSEQUENCE(String ES) {
    this.EVENTSEQUENCE = ES;
  }

  public String getEVENTSEQUENCE() {
    return this.EVENTSEQUENCE;
  }

  private void setFILLEDOUTLABEL(String FO) {
    this.FILLEDOUTLABEL = FO;
  }

  public String getFILLEDOUTLABEL() {
    return this.FILLEDOUTLABEL;
  }

  private void setCREATORID(String CID) {
    this.CREATORID = CID;
  }

  public String getCREATORID() {
    return this.CREATORID;
  }

  private void setCREATEDDATE(String CD) {
    this.CREATEDDATE = CD;
  }

  public String getCREATEDDATE() {
    return this.CREATEDDATE;
  }

  private void setLASTUPDID(String LID) {
    this.LASTUPDID = LID;
  }

  public String getLASTUPDID() {
    return this.LASTUPDID;
  }

  private void setLASTUPDDATE(String LD) {
    this.LASTUPDDATE = LD;
  }

  public String getLASTUPDDATE() {
    return this.LASTUPDDATE;
  }

  private void setSDVALIDATION(String SA) {
    this.SDVALIDATION = SA;
  }

  public String getSDVALIDATION() {
    return this.SDVALIDATION;
  }

  private void setDOUBLECHECK(String DC) {
    this.DOUBLECHECK = DC;
  }

  public String getDOUBLECHECK() {
    return this.DOUBLECHECK;
  }
}
