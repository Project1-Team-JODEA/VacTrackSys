/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package business;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletContext;

/**
 *
 * @author alexs
 */
public class SecLog {
    public static void write(User u, Patient p, String url, String input) throws IOException, ClassNotFoundException, SQLException{
//        try{
//        String test = System.getProperty("user.dir");
//        File myFile = new File(System.getProperty("user.dir"), "SecurityLog.txt");
//        if (myFile.createNewFile()) {
//            // file creation successful
//      } else {
//            // File already exists
//      }
//        } catch (Exception e){
//            
//        }
//        FileWriter myWriter = new FileWriter("SecurityLog.txt");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        output += timestamp.toString();
//        output += "   ";
//        output += u.getUsername();
//        output += "   ";
        String userid = u.getUsername();
        String eventtime = timestamp.toString();
        String patientssn = p.getSsn();
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + url);
        String sql = "INSERT INTO SEC_EVENT VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, null);
        ps.setString(2, patientssn);
        ps.setString(3, userid);
        ps.setString(4, input);
        ps.setString(5, eventtime);
        int rc = ps.executeUpdate();
        conn.close();
    }
}
