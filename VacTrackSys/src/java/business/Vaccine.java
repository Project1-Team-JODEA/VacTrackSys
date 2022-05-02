/**
 *  Alex Breitenbach
 * @author 
 */
package business;

/**
 *
 * @author alexs
 */
public class Vaccine {
    private String vid, date,vtype, manufacturer, lotnum, location, state, locatype, nurse;
    
    // default constructor
    public Vaccine(){
        this.vid = "";
        this.date = "";
        this.vtype="";
        this.manufacturer = "";
        this.lotnum = "";
        this.location = "";
        this.state = "";
        this.nurse = "";
    }
    
    // normal constructor.  All fields should be validated BEFORE calling this method
    public Vaccine(String vid, String date,String vtype, String manufacturer, String lotnum, String location, String state, String locatype, String nurse){
        this.vid = vid;
        this.date = date;
        this.vtype = vtype;
        this.manufacturer = manufacturer;
        this.lotnum = lotnum;
        this.location = location;
        this.state = state;
        this.locatype = locatype;
        this.nurse = nurse;
    }
/**
 * 
 * @return Vaccination ID | String
 */
    public String getVid() {
        return vid;
    }
/**
 * set Vaccine ID
 * @param vid String
 */
    public void setVid(String vid) {
        this.vid = vid;
    }
/**
 * 
 * @return date (String)
 */
    public String getDate() {
        return date;
    }
/**
 * 
 * @param date 
 */
    public void setDate(String date) {
        this.date = date;
    }
/**
 * 
 * @return manufacturer (String)
 */
    public String getManufacturer() {
        return manufacturer;
    }
/**
 * 
 * @param manufacturer String
 */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
/**
 * 
 * @return LotNumber - String
 */
    public String getLotnum() {
        return lotnum;
    }
/**
 * 
 * @param lotnum String | Lot Number or Batch Number
 */
    public void setLotnum(String lotnum) {
        this.lotnum = lotnum;
    }
/**
 * 
 * @return Vaccination Location (String)
 */
    public String getLocation() {
        return location;
    }
/**
 * 
 * @param location - String| Vaccination Location
 */
    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
/**
 * 
 * @return Location Type (String)
 */
    public String getLocatype() {
        return locatype;
    }
/**
 * 
 * @param locatype Location Type (String)
 */
    public void setLocatype(String locatype) {
        this.locatype = locatype;
    }
/**
 * 
 * @return Name of Nurse - String
 */
    public String getNurse() {
        return nurse;
    }
/**
 * 
 * @param nurse Name of Nurse 
 */
    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }
    
}