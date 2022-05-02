/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

/**
 * Date: Feb 20, 2022 4:22:19 PM
 * File name: Connect.java
 * Author(s): @author eVmPr
 * Supporting File(s): 
 * Note(s): 
 */
import java.sql.*;
public class Connect {
public Connect(String path){
    try{
        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection con = DriverManager.getConnection(path);
        
    
    }catch(Exception e){
        System.out.print(e);
    }
}
}
