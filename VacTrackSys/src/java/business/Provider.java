/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package business;

/**
 * Date: Apr 11, 2022 5:48:43 PM File name: Provider.java Author(s): @author
 * eVmPr Supporting File(s): Note(s):
 */
public class Provider {

    private String fname, lname, minit, dob, etype;
    private User u;
    public Provider() {
        this.fname="";
         this.fname = "";
        this.minit = "";
        this.lname = ""; 
        this.etype="";
        this.dob = "";
    }
    public Provider( String fname, String minit, String lname, String etype, String dob){
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.etype = etype;
        this.dob = dob;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @return the minit
     */
    public String getMinit() {
        return minit;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @return the etype
     */
    public String getEtype() {
        return etype;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @param minit the minit to set
     */
    public void setMinit(String minit) {
        this.minit = minit;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @param etype the etype to set
     */
    public void setEtype(String etype) {
        this.etype = etype;
    }
    
}
