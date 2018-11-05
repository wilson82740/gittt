package dbtable;

import java.util.ArrayList;

public class DATAPOINTDATARECORD {

  private String ID;
  private String DATAPOINTID;
  private String DATARECORDID;
  private String VALUE;
  private String CREATORID;
  private String CREATEDDATE;
  private String LASTUPDID;
  private String LASTUPDDATE;

  public DATAPOINTDATARECORD(ArrayList<String> parameter) {

    setID(parameter.get(0));
    setDATAPOINTID(parameter.get(1));
    setDATARECORDID(parameter.get(2));
    setVALUE(parameter.get(3));
    setCREATORID(parameter.get(4));
    setCREATEDDATE(parameter.get(5));
    setLASTUPDID(parameter.get(6));
    setLASTUPDDATE(parameter.get(7));
  }

  private void setID(String ID) {
    this.ID = ID;
  }

  public String getID() {
    return this.ID;
  }

  private void setDATAPOINTID(String DPI) {
    this.DATAPOINTID = DPI;
  }

  public String getDATAPOINTID() {
    return this.DATAPOINTID;
  }

  private void setDATARECORDID(String DRI) {
    this.DATARECORDID = DRI;
  }

  public String getDATARECORDID() {
    return this.DATARECORDID;
  }

  private void setVALUE(String value) {
    this.VALUE = value;
  }

  public String getVALUE() {
    return this.VALUE;
  }

  private void setCREATORID(String CI) {
    this.CREATORID = CI;
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

  private void setLASTUPDID(String LUI) {
    this.LASTUPDID = LUI;
  }

  public String getLASTUPDID() {
    return this.LASTUPDID;
  }

  private void setLASTUPDDATE(String LUD) {
    this.LASTUPDDATE = LUD;
  }

  public String getLASTUPDDATE() {
    return this.LASTUPDDATE;
  }
}
