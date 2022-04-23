/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package business;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eVmPr
 */
public class PatientTest {
    
    public PatientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRid method, of class Patient.
     */
    @Test
    public void testGetRid() {
        System.out.println("getRid");
        Patient instance = new Patient();
        int expResult = 0;
        int result = instance.getRid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRid method, of class Patient.
     */
    @Test
    public void testSetRid() {
        System.out.println("setRid");
        int rid = 0;
        Patient instance = new Patient();
        instance.setRid(rid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSsn method, of class Patient.
     */
    @Test
    public void testGetSsn() {
        System.out.println("getSsn");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getSsn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSsn method, of class Patient.
     */
    @Test
    public void testSetSsn() {
        System.out.println("setSsn");
        String ssn = "";
        Patient instance = new Patient();
        instance.setSsn(ssn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFname method, of class Patient.
     */
    @Test
    public void testGetFname() {
        System.out.println("getFname");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getFname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFname method, of class Patient.
     */
    @Test
    public void testSetFname() {
        System.out.println("setFname");
        String fname = "";
        Patient instance = new Patient();
        instance.setFname(fname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMname method, of class Patient.
     */
    @Test
    public void testGetMname() {
        System.out.println("getMname");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getMname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMname method, of class Patient.
     */
    @Test
    public void testSetMname() {
        System.out.println("setMname");
        String mname = "";
        Patient instance = new Patient();
        instance.setMname(mname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLname method, of class Patient.
     */
    @Test
    public void testGetLname() {
        System.out.println("getLname");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getLname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLname method, of class Patient.
     */
    @Test
    public void testSetLname() {
        System.out.println("setLname");
        String lname = "";
        Patient instance = new Patient();
        instance.setLname(lname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDob method, of class Patient.
     */
    @Test
    public void testGetDob() {
        System.out.println("getDob");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getDob();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDob method, of class Patient.
     */
    @Test
    public void testSetDob() {
        System.out.println("setDob");
        String dob = "";
        Patient instance = new Patient();
        instance.setDob(dob);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVac1 method, of class Patient.
     */
    @Test
    public void testGetVac1() {
        System.out.println("getVac1");
        Patient instance = new Patient();
        Vaccine expResult = null;
        Vaccine result = instance.getVac1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVac1 method, of class Patient.
     */
    @Test
    public void testSetVac1() {
        System.out.println("setVac1");
        Vaccine vac1 = null;
        Patient instance = new Patient();
        instance.setVac1(vac1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVac2 method, of class Patient.
     */
    @Test
    public void testGetVac2() {
        System.out.println("getVac2");
        Patient instance = new Patient();
        Vaccine expResult = null;
        Vaccine result = instance.getVac2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVac2 method, of class Patient.
     */
    @Test
    public void testSetVac2() {
        System.out.println("setVac2");
        Vaccine vac2 = null;
        Patient instance = new Patient();
        instance.setVac2(vac2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVac3 method, of class Patient.
     */
    @Test
    public void testGetVac3() {
        System.out.println("getVac3");
        Patient instance = new Patient();
        Vaccine expResult = null;
        Vaccine result = instance.getVac3();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVac3 method, of class Patient.
     */
    @Test
    public void testSetVac3() {
        System.out.println("setVac3");
        Vaccine vac3 = null;
        Patient instance = new Patient();
        instance.setVac3(vac3);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVac4 method, of class Patient.
     */
    @Test
    public void testGetVac4() {
        System.out.println("getVac4");
        Patient instance = new Patient();
        Vaccine expResult = null;
        Vaccine result = instance.getVac4();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVac4 method, of class Patient.
     */
    @Test
    public void testSetVac4() {
        System.out.println("setVac4");
        Vaccine vac4 = null;
        Patient instance = new Patient();
        instance.setVac4(vac4);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPtype method, of class Patient.
     */
    @Test
    public void testSetPtype() {
        System.out.println("setPtype");
        String ptype = "";
        Patient instance = new Patient();
        instance.setPtype(ptype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPtype method, of class Patient.
     */
    @Test
    public void testGetPtype() {
        System.out.println("getPtype");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getPtype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVacStat method, of class Patient.
     */
    @Test
    public void testGetVacStat() {
        System.out.println("getVacStat");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getVacStat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReport method, of class Patient.
     */
    @Test
    public void testGetReport() {
        System.out.println("getReport");
        ArrayList<Patient> p = null;
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getReport(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
