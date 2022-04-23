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
    private String name,ltype, street1, street2, city;
    private int zip;
    public Location(){
        this.id=0;
        this.name="";
        this.ltype="";
        this.street1 = "";
        this.street2="";
        this.zip=0;
    }
    public Location(int id, String name, String ltype, String street1, String street2, String city, int zip){
        this.id = id;
        this.name = name;
        this.ltype = ltype;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city; this.zip = zip;
                
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

    /**
     * @return the street1
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * @return the street2
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the zip
     */
    public int getZip() {
        return zip;
    }

    /**
     * @param street1 the street1 to set
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * @param street2 the street2 to set
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(int zip) {
        this.zip = zip;
    }
    
}
