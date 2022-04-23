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
public class UserTest {
    
    public UserTest() {
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
     * Test of isSearchedPatients method, of class User.
     */
    @Test
    public void testIsSearchedPatients() {
        System.out.println("isSearchedPatients");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.isSearchedPatients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSearched method, of class User.
     */
    @Test
    public void testGetSearched() {
        System.out.println("getSearched");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.getSearched();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSearched method, of class User.
     */
    @Test
    public void testSetSearched() {
        System.out.println("setSearched");
        Boolean searched = null;
        User instance = new User();
        instance.setSearched(searched);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        User instance = new User();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccesslevel method, of class User.
     */
    @Test
    public void testGetAccesslevel() {
        System.out.println("getAccesslevel");
        User instance = new User();
        String expResult = "";
        String result = instance.getAccesslevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccesslevel method, of class User.
     */
    @Test
    public void testSetAccesslevel() {
        System.out.println("setAccesslevel");
        String accesslevel = "";
        User instance = new User();
        instance.setAccesslevel(accesslevel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class User.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        User instance = new User();
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class User.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "";
        User instance = new User();
        instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassattempt method, of class User.
     */
    @Test
    public void testGetPassattempt() {
        System.out.println("getPassattempt");
        User instance = new User();
        String expResult = "";
        String result = instance.getPassattempt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassattempt method, of class User.
     */
    @Test
    public void testSetPassattempt() {
        System.out.println("setPassattempt");
        String passattempt = "";
        User instance = new User();
        instance.setPassattempt(passattempt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAuthenticated method, of class User.
     */
    @Test
    public void testIsAuthenticated() {
        System.out.println("isAuthenticated");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.isAuthenticated();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of secureInfo method, of class User.
     */
    @Test
    public void testSecureInfo() {
        System.out.println("secureInfo");
        User instance = new User();
        instance.secureInfo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestion method, of class User.
     */
    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");
        User instance = new User();
        String expResult = "";
        String result = instance.getQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswer method, of class User.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        User instance = new User();
        String expResult = "";
        String result = instance.getAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuestion method, of class User.
     */
    @Test
    public void testSetQuestion() {
        System.out.println("setQuestion");
        String question = "";
        User instance = new User();
        instance.setQuestion(question);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnswer method, of class User.
     */
    @Test
    public void testSetAnswer() {
        System.out.println("setAnswer");
        String answer = "";
        User instance = new User();
        instance.setAnswer(answer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
