/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */


package business;

/**
 * Date: Mar 22, 2022 9:23:56 PM
 * File name: Location.java
 * Author(s): @author eVmPr
 * Supporting File(s): 
 * Note(s): 
 * 
 */
public class Location {
    private int id;
    private String name,ltype;
    public Location(){
        this.id=0;
        this.name="";
        this.ltype="";
    }
    public Location(int id, String name, String ltype){
        this.id = id;
        this.name = name;
        this.ltype = ltype;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the ltype
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param ltype the ltype to set
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }
    
}
