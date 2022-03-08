package business;

import business.Vaccine;

/**
 *
 * @author alexs (Alexander Bretenbach
 * TODO:
 * 
 */
public class Patient {

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    private int rid;
    private String ssn, fname, mname, lname, dob, ptype;
    private Vaccine vac1, vac2, vac3, vac4;

    //default constructor
    public Patient() {
        this.rid = -1;
        this.ssn = "";
        this.fname = "";
        this.mname = "";
        this.lname = "";
        this.dob = "";
        this.vac1 = null;
        this.vac2 = null;
        this.vac3 = null;
        this.vac4 = null;
        this.ptype = "";
    }

    //normal constructor.  All fields should be validated BEFORE calling this method.
    public Patient(int rid, String ssn, String fname, String mname, String lname, String dob, Vaccine vac1, Vaccine vac2, Vaccine vac3, Vaccine vac4, String ptype) {
        this.rid = rid;
        this.ssn = ssn;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.dob = dob;
        this.vac1 = vac1;
        this.vac2 = vac2;
        this.vac3 = vac3;
        this.vac4 = vac4;
        this.ptype = ptype;
    }

    /**
     * gets Recipient ID of patient object
     *
     * @return rid (int)
     */
    public int getRid() {
        return rid;
    }

    /**
     * Sets Recipient ID of Patient Object
     *
     * @param rid Recipient ID
     */
    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     *  gets FIrst Name (String) from Patient Object
     * @return fname (String) - First Name
     */
    public String getFname() {
        return fname;
    }
/**
 * Sets First Name (String) of Patient Object
 * @param fname (String)
 */
    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
/**
 * 
 * @return 
 */
    public String getLname() {
        return lname;
    }
/**
 * Sets Patient Last Name (lname - String)
 * @param lname String
 */
    public void setLname(String lname) {
        this.lname = lname;
    }
/**
 * gets dob (date of birth) from Patient object
 * @return dob (String) - Date of Birth
 */
    public String getDob() {
        return dob;
    }
/**
 * Sets DOB (Date of Birth) of Patient Object
 * @param dob Date of Birth (String)
 * 
 */
    public void setDob(String dob) {
        this.dob = dob;
    }
/**
 * 
 * @return vac1 - Vaccine Object
 */
    public Vaccine getVac1() {
        return vac1;
    }
/**
 * 
 * @param vac1 Vaccine Object 
 */
    public void setVac1(Vaccine vac1) {
        this.vac1 = vac1;
    }
/**
 * 
 * @return vac2 - Vaccine Object
 */
    public Vaccine getVac2() {
        return vac2;
    }
/**
 * 
 * @param vac2  Vaccine Object
 */
    public void setVac2(Vaccine vac2) {
        this.vac2 = vac2;
    }
/**
 * 
 * @return vac3-  Vaccine Object
 */
    public Vaccine getVac3() {
        return vac3;
    }
/**
 * 
 * @param vac3  Vaccine Object
 */
    public void setVac3(Vaccine vac3) {
        this.vac3 = vac3;
    }
/**
 * 
 * @return vaccine #4 - Vaccine Object
 */
    public Vaccine getVac4() {
        return vac4;
    }
/**
 * 
 * @param vac4 Vaccine Object
 */
    public void setVac4(Vaccine vac4) {
        this.vac4 = vac4;
    }
    
   
}