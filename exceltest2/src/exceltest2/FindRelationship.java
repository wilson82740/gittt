package exceltest2;

import java.util.ArrayList;

import DBTable.DATAPOINTDATARECORD;
import DBTable.DATARECORD;
import DBTable.DadaPoint;
import DBTable.ExcelFormParameter;
import DBTable.FORM;
import DBTable.FORMVERSION;
import DBTable.PATIENT;
import DBTable.PROTOCOL_PATIENT;
import DBTable.VISIT;

public class FindRelationship {

  ArrayList<ExcelFormParameter> ExcelFormtable =
      new ArrayList<ExcelFormParameter>();

  public FindRelationship() {

  }

  public FindRelationship(ArrayList<DadaPoint> bdpa, ArrayList<PATIENT> bpaa,
      ArrayList<DATAPOINTDATARECORD> bdpdra, ArrayList<PROTOCOL_PATIENT> bprapa,
      ArrayList<VISIT> bvisita, ArrayList<DATARECORD> bdra,
      ArrayList<FORM> bforma, ArrayList<FORMVERSION> bfva) {
    // EFPs string temp store all output parameter
    String[] EFPs;
    String pclpatientid;
    String patientid;
    String formvid;
    ArrayList<ArrayList> tempA = new ArrayList<ArrayList>();
    ArrayList<String> tempS;

    for (int si = 0; si < bdra.size(); si++) { // bdra.size()
      EFPs = new String[13];
      for (int i = 0; i < 13; i++) {
        if (i == 4)
          EFPs[i] = "1";
        else
          EFPs[i] = "";
      }
      // get visit date and pclpatientid
      pclpatientid = getvisitdate(bdra.get(si).getEVENTID(), bvisita, EFPs);
      if (pclpatientid != null) {
        // get patientid
        patientid = getpatientid(pclpatientid, bprapa);
        if (patientid != null) {
          // get patient name and MRN
          getNameMRN(patientid, bpaa, EFPs);
        }
      } else {
        EFPs[2] = bdra.get(si).getEVENTID() + "";
      }
      // get formversion and formid
      formvid = getformversion(bdra.get(si).getFORMVERSIONID(), bfva, EFPs);
      if (formvid != null) {
        // get Test/Battery
        getTB(formvid, bforma, EFPs);
      }
      // get datapoint value
      getvalue(bdra.get(si).getID(), bdpdra, bdpa, EFPs);
      /*
       * System.out.print("EFPs:"); for (int i = 0; i < 17; i++) { if (i == 16)
       * System.out.println(EFPs[i]); else System.out.print(EFPs[i] + " "); }
       */
      tempS = new ArrayList<String>();
      for (int j = 0; j < EFPs.length; j++) {
        /*
         * if(si==2436-5) { System.out.println(EFPs[j]); }
         */
        tempS.add(EFPs[j]);
      }
      tempA.add(tempS);
    }
    for (int i = 0; i < tempA.size(); i++) {
      ExcelFormParameter EFP = new ExcelFormParameter(tempA.get(i));
      ExcelFormtable.add(EFP);
    }
    tempA.clear();

  }

  public String getvisitdate(String eventid, ArrayList<VISIT> bvisita,
      String[] EFPs) {
    ArrayList<Integer> index = new ArrayList<Integer>();
    for (int i = 0; i < bvisita.size(); i++) {
      if (bvisita.get(i).getEVENTID().compareTo(eventid)==0 ) {
        index.add(i);
      }
    }
    if (index.size() >= 2) {
      int day = 0;
      int tday;
      int mon = 0;
      int tmon;
      int year = 0;
      int tyear;
      int selectindex = -1;
      int checkchangp = 0;
      for (int i = 0; i < index.size(); i++) {
        checkchangp = 0;
        // visitdate split to three part(day/month/year)
        String[] visitdate =
            bvisita.get(index.get(i)).getVISITDATE().split("-");
        tday = Integer.parseInt(visitdate[0]);
        // month string to int
        tmon = MonToInt(visitdate[1]);
        tyear = Integer.parseInt(visitdate[2]);
        checkchangp = checkchang(day, mon, year, tday, tmon, tyear);
        if (checkchangp == 1) {
          day = tday;
          mon = tmon;
          year = tyear;
          selectindex = index.get(i);
        }
      }
      EFPs[2] = "20" + year + "/" + mon + "/" + day;
      return bvisita.get(selectindex).getPCLPATIENTID();
    }
    if (index.size() == 0)
      return null;
    else {
      // visitdate split to three part(day/month/year)
      String[] visitdate = bvisita.get(index.get(0)).getVISITDATE().split("-");
      EFPs[2] = "20" + visitdate[2] + "/" + MonToInt(visitdate[1]) + "/"
          + visitdate[0];
      return bvisita.get(index.get(0)).getPCLPATIENTID();
    }
  }

  public String getformversion(String formversionid, ArrayList<FORMVERSION> bfva,
      String[] EFPs) {
    for (int i = 0; i < bfva.size(); i++) {
      if (bfva.get(i).getID().compareTo(formversionid)==0 ) {
        EFPs[5] = "v" + bfva.get(i).getFORMVERSION();
        return bfva.get(i).getFORMID();
      }
    }
    return null;
  }

  public void getTB(String formvid, ArrayList<FORM> bforma, String[] EFPs) {
    for (int i = 0; i < bforma.size(); i++) {
      if (bforma.get(i).getID().compareTo(formvid)==0 ) {
        EFPs[3] = bforma.get(i).getTYPE() + ":" + bforma.get(i).getTITLE() + "-"
            + EFPs[5];
        break;
      }
    }
  }

  public void getvalue(String datarecordid, ArrayList<DATAPOINTDATARECORD> bdpdra,
      ArrayList<DadaPoint> bdpa, String[] EFPs) {
    for (int i = 0; i < bdpdra.size(); i++) {
      if (bdpdra.get(i).getDATARECORDID().compareTo(datarecordid)==0 ) {
        // get value class
        getvalueclass(bdpdra.get(i).getDATAPOINTID(), bdpdra.get(i).getVALUE(),
            bdpa, EFPs);
      }
    }
  }

  public void getvalueclass(String datapoinid, String value,
      ArrayList<DadaPoint> bdpa, String[] EFPs) {
    for (int i = 0; i < bdpa.size(); i++) {
      if (bdpa.get(i).getID().compareTo(datapoinid)==0 ) {
        switch (bdpa.get(i).getNAME()) {
        case "AE_Enroll":
          EFPs[6] = value;
          break;
        case "Muscle_Pain_Enroll":
          EFPs[7] = value;
          break;
        case "TC_Urine_Enroll":
          EFPs[8] = value;
          break;
        case "Other_AE_Enroll_specify":
          EFPs[9] = value;
          break;
        case "Diet_Consult_Enroll":
          EFPs[10] = value;
          break;
        case "Other_AE_Enroll_Done":
          EFPs[11] = value;
          break;
        case "OtherMeasur_Enroll_Complete":
          EFPs[12] = value;
          break;
        default:
          break;
        }
      }
    }
  }

  public String getpatientid(String pclpatientid,
      ArrayList<PROTOCOL_PATIENT> bprapa) {
    for (int i = 0; i < bprapa.size(); i++) {
      if (bprapa.get(i).getID().compareTo(pclpatientid)==0 ) {
        return bprapa.get(i).getPATIENTID();
      }
    }
    return null;
  }

  public void getNameMRN(String patientid, ArrayList<PATIENT> bpaa,
      String[] EFPs) {
    for (int i = 0; i < bpaa.size(); i++) {
      if (bpaa.get(i).getPATIENTID().compareTo(patientid)==0 ) {
        EFPs[1] = bpaa.get(i).getMRN();
        if (bpaa.get(i).getFIRST_NAME() != null)
          EFPs[0] =
              bpaa.get(i).getLAST_NAME() + "," + bpaa.get(i).getFIRST_NAME();
        else
          EFPs[0] = bpaa.get(i).getLAST_NAME();
        break;
      }
    }
    if (EFPs[1] == "") {
      EFPs[0] = patientid + "";
      EFPs[1] = patientid + "";
    }
  }

  public int MonToInt(String MON) {
    switch (MON) {
    case "JAN":
      return 1;
    case "FEB":
      return 2;
    case "MAR":
      return 3;
    case "APR":
      return 4;
    case "MAY":
      return 5;
    case "JUN":
      return 6;
    case "JUL":
      return 7;
    case "AUG":
      return 8;
    case "SEP":
      return 9;
    case "OCT":
      return 10;
    case "NOV":
      return 11;
    case "DEC":
      return 12;
    default:
      return -1;
    }
  }

  public int checkchang(int day, int mon, int year, int tday, int tmon,
      int tyear) {
    if (tyear > year) {
      return 1;
    } else if (tyear == year) {
      if (tmon > mon) {
        return 1;
      } else if (tmon == mon) {
        if (tday > day) {
          return 1;
        }
      }
    }
    return 0;
  }

  public ArrayList<ExcelFormParameter> getEFArrayList() {
    return ExcelFormtable;
  }

}
