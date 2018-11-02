package dbtable;

import java.util.ArrayList;

public class DadaPoint {

  private String ID;
  private String ELEMENTID;
  private String MEASUNITID;
  private String DATATYPEID;
  private String NAME;
  private String HIGHTHRESHOLD;
  private String LOWTHRESHOLD;
  private String UNIT;
  private String DCPID;
  private String NAME_081;
  private String INTERNAL_CODE;
  private String MINVAL;
  private String MAXVAL;

  public DadaPoint(ArrayList<String> parameter) {

    setID(parameter.get(0));
    setELEMENTID(parameter.get(1));
    setMEASUNITID(parameter.get(2));
    setDATATYPEID(parameter.get(3));
    setNAME(parameter.get(4));
    setHIGHTHRESHOLD(parameter.get(5));
    setLOWTHRESHOLD(parameter.get(6));
    setUNIT(parameter.get(7));
    setDCPID(parameter.get(8));
    setNAME_081(parameter.get(9));
    setINTERNAL_CODE(parameter.get(10));
    setMINVAL(parameter.get(11));
    setMAXVAL(parameter.get(12));
  }

  private void setID(String DPID) {
    this.ID = DPID;
  }

  public String getID() {
    return this.ID;
  }

  private void setELEMENTID(String EID) {
    this.ELEMENTID = EID;
  }

  public String getELEMENTID() {
    return this.ELEMENTID;
  }

  private void setMEASUNITID(String MID) {
    this.MEASUNITID = MID;
  }

  public String getMEASUNITID() {
    return this.MEASUNITID;
  }

  private void setDATATYPEID(String DTID) {
    this.DATATYPEID = DTID;
  }

  public String getDATATYPEID() {
    return this.DATATYPEID;
  }

  private void setNAME(String name) {
    this.NAME = name;
  }

  public String getNAME() {
    return this.NAME;
  }

  private void setHIGHTHRESHOLD(String HT) {
    this.HIGHTHRESHOLD = HT;
  }

  public String getHIGHTHRESHOLD() {
    return this.HIGHTHRESHOLD;
  }

  private void setLOWTHRESHOLD(String LT) {
    this.LOWTHRESHOLD = LT;
  }

  public String getLOWTHRESHOLD() {
    return this.LOWTHRESHOLD;
  }

  private void setUNIT(String unit) {
    this.UNIT = unit;
  }

  public String getUNIT() {
    return this.UNIT;
  }

  private void setDCPID(String DCPID) {
    this.DCPID = DCPID;
  }

  public String getDCPID() {
    return this.DCPID;
  }

  private void setNAME_081(String name_081) {
    this.NAME_081 = name_081;
  }

  public String getNAME_081() {
    return this.NAME_081;
  }

  private void setINTERNAL_CODE(String IC) {
    this.INTERNAL_CODE = IC;
  }

  public String getINTERNAL_CODE() {
    return this.INTERNAL_CODE;
  }

  private void setMINVAL(String MINV) {
    this.MINVAL = MINV;
  }

  public String getMINVAL() {
    return this.MINVAL;
  }

  private void setMAXVAL(String MAXV) {
    this.MAXVAL = MAXV;
  }

  public String getMAXVAL() {
    return this.MAXVAL;
  }

}
