/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package business;

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
public class ProviderTest {
    
    public ProviderTest() {
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
     * Test of getFname method, of class Provider.
     */
    @Test
    public void testGetFname() {
        System.out.println("getFname");
        Provider instance = new Provider();
        String expResult = "";
        String result = instance.getFname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLname method, of class Provider.
     */
    @Test
    public void testGetLname() {
        System.out.println("getLname");
        Provider instance = new Provider();
        String expResult = "";
        String result = instance.getLname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinit method, of class Provider.
     */
    @Test
    public void testGetMinit() {
        System.out.println("getMinit");
        Provider instance = new Provider();
        String expResult = "";
        String result = instance.getMinit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDob method, of class Provider.
     */
    @Test
    public void testGetDob() {
        System.out.println("getDob");
        Provider instance = new Provider();
        String expResult = "";
        String result = instance.getDob();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEtype method, of class Provider.
     */
    @Test
    public void testGetEtype() {
        System.out.println("getEtype");
        Provider instance = new Provider();
        String expResult = "";
        String result = instance.getEtype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFname method, of class Provider.
     */
    @Test
    public void testSetFname() {
        System.out.println("setFname");
        String fname = "";
        Provider instance = new Provider();
        instance.setFname(fname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLname method, of class Provider.
     */
    @Test
    public void testSetLname() {
        System.out.println("setLname");
        String lname = "";
        Provider instance = new Provider();
        instance.setLname(lname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMinit method, of class Provider.
     */
    @Test
    public void testSetMinit() {
        System.out.println("setMinit");
        String minit = "";
        Provider instance = new Provider();
        instance.setMinit(minit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDob method, of class Provider.
     */
    @Test
    public void testSetDob() {
        System.out.println("setDob");
        String dob = "";
        Provider instance = new Provider();
        instance.setDob(dob);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEtype method, of class Provider.
     */
    @Test
    public void testSetEtype() {
        System.out.println("setEtype");
        String etype = "";
        Provider instance = new Provider();
        instance.setEtype(etype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
