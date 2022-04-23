/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package business;

import java.util.Optional;
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
public class AppSecurityTest {
    
    public AppSecurityTest() {
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
     * Test of getGenCode method, of class AppSecurity.
     */
    @Test
    public void testGetGenCode() {
        System.out.println("getGenCode");
        int expResult = 0;
        int result = AppSecurity.getGenCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateSalt method, of class AppSecurity.
     */
    @Test
    public void testGenerateSalt() {
        System.out.println("generateSalt");
        Optional<String> expResult = null;
        Optional<String> result = AppSecurity.generateSalt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashValue method, of class AppSecurity.
     */
    @Test
    public void testHashValue() {
        System.out.println("hashValue");
        String val = "";
        String salt = "";
        Optional<String> expResult = null;
        Optional<String> result = AppSecurity.hashValue(val, salt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encryptPassword method, of class AppSecurity.
     */
    @Test
    public void testEncryptPassword() throws Exception {
        System.out.println("encryptPassword");
        String password = "";
        String expResult = "";
        String result = AppSecurity.encryptPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDecryptedPasswd method, of class AppSecurity.
     */
    @Test
    public void testGetDecryptedPasswd() {
        System.out.println("getDecryptedPasswd");
        String expResult = "";
        String result = AppSecurity.getDecryptedPasswd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verify method, of class AppSecurity.
     */
    @Test
    public void testVerify() {
        System.out.println("verify");
        String p = "";
        String k = "";
        String s = "";
        boolean expResult = false;
        boolean result = AppSecurity.verify(p, k, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEncryptedValue method, of class AppSecurity.
     */
    @Test
    public void testGetEncryptedValue() throws Exception {
        System.out.println("getEncryptedValue");
        String val = "";
        AppSecurity instance = new AppSecurity();
        String expResult = "";
        String result = instance.getEncryptedValue(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrypt method, of class AppSecurity.
     */
    @Test
    public void testDecrypt() throws Exception {
        System.out.println("decrypt");
        String value = "";
        AppSecurity instance = new AppSecurity();
        String expResult = "";
        String result = instance.decrypt(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendEmail method, of class AppSecurity.
     */
    @Test
    public void testSendEmail() {
        System.out.println("sendEmail");
        String uemail = "";
        String subject = "";
        String msg = "";
        boolean expResult = false;
        boolean result = AppSecurity.sendEmail(uemail, subject, msg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendVerificationEmail method, of class AppSecurity.
     */
    @Test
    public void testSendVerificationEmail() throws Exception {
        System.out.println("sendVerificationEmail");
        String recip = "";
        AppSecurity.sendVerificationEmail(recip);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class AppSecurity.
     */
    @Test
    public void testWrite() throws Exception {
        System.out.println("write");
        User u = null;
        Patient p = null;
        String url = "";
        String input = "";
        AppSecurity.write(u, p, url, input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
