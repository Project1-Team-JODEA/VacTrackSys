/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package business;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.spec.PBEKeySpec;
import java.util.*;
import javax.crypto.*;
import javax.crypto.SecretKey;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 * Date: Mar 31, 2022 1:18:35 PM File name: AppSecurity.java Author(s): @author
 * eVmPr Supporting File(s): Note(s):
 */
public class AppSecurity {

    public static final String AES = "AES", MD5 = "MD5";
//    public final String /
    private String value, valuetype, option, errmsg;
    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int iterations = 10000;
    private static final int keylength = 256;
    int iterationCount = 1024;
    int keyStrength = 256;
    byte[] iv;
    private static String saltval;
    private byte[] byte_val;
    private KeyGenerator keyGen;
    private static final String email = "jodeavactracker@outlook.com", username = "VacTrack", password = "JODEAD3velopment";
    //email = "VacTrack@workmail.com"
//    AppSecurity(String value) throws Exception {
//        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//
//        KeySpec spec = new PBEKeySpec(value.toCharArray(), salt, iterationCount, keyStrength);
//
//        this.value = "";
//        this.valuetype = "";
//        this.option = "";
//        this.byte_val = new byte[0];
//        this.errmsg = "";
//
//    }
//
//    public AppSecurity(String value, String valuetype, String option) {
//        this.value = value;
//        this.valuetype = valuetype;
//        this.option = option;
//    }

    public static String encryptPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom ran = new SecureRandom();
        byte[] salt = new byte[16];
        ran.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();

        return new String();
    }

    public static String getDecryptedPasswd() {

        return new String();
    }

    /**
     * Takes valud and encrypts it.
     *
     * @exception
     * @param val
     * @return newval String
     */
    public static String encrypt(String data) {
        String encryptedVal = null;
        try {
            //        SecureRando
            SecureRandom random = new SecureRandom();
            char[] d = data.toCharArray();
            byte[] salt = new byte[30];//;;getSaltValue();//new byte[30];
            String xd = getSaltValue();

            random.nextBytes(salt);
            /* generate hash value*/

//            System.out.println(hash);
            /* generate hash value */
            KeySpec spec = new PBEKeySpec(d, salt, iterations, keylength);
            Arrays.fill(d, Character.MIN_VALUE);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
//            byte[] secureVal = get
//            String e = hash.toString();
            /*Encrypt password using */
            encryptedVal = Base64.getEncoder().encodeToString(hash);

            return encryptedVal;
        } catch (InvalidKeySpecException ex) {
            // Logger.getLogger(AppSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            // Logger.getLogger(AppSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public String getEncryptedValue(String val) throws NoSuchAlgorithmException {
//        String en
        String encrypteval = null;

        byte[] bytes = val.getBytes();
        SecretKey sk = (SecretKey) KeyGenerator.getInstance("AES");

        /*Array Hex to String */
//        PBKeySpec spec = new PBEKeySpec();
//                    String saltval = PassBasedEnc.getSaltvalue(30);  
//create cipher
//        MessageDigest mg = MessageDigest.getInstance("MD5");
//        mg.update(u.getPassword().getBytes());
//        byte[] b = mg.digest();
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < b.length; i++) {
//
//        }
//        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
//                    nitialize cipher object
//        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
//        byte[] pas = u.getPassword().getBytes();
//        cipher.update(pas);
//        byte[] cipherText = cipher.doFinal();
//        u.setPassword(new String(cipherText, "UTF-8"));
        return new String();
    }

    public String decrypt(String value) throws Exception {
        String decryptval = null;

        return decryptval;
    }

    public boolean verify(String value1, String hasedVal) {
        return false;
    }

    public static String getSaltValue() {
        Random rand = new SecureRandom();
        byte[] salt = null;
        int x = 20;
        StringBuilder s = new StringBuilder(x);
        for (int i = 0; i < x; i++) {
            s.append(characters.charAt(rand.nextInt(characters.length())));
        }

        String y = new String(s);
//        System.out.println(y);
        salt = y.getBytes();
        return y;
    }

    public byte[] hash() {
        return new byte[0];
    }
    /**
     * generates random 6 digit code 
     * 
     * @return code - int
     */
public static int getGenCode(){
    int code = 0;
    code = (int) (Math.random()*1000000);
    
    return code;
}
    /**
     *
     * @param uemail
     * @param msg
     * @throws AddressException
     * @throws MessagingException
     */
    public static void sendEmail(String uemail,String subject, String msg)
            throws AddressException, MessagingException {
        Properties prop = System.getProperties();//new Properties(); //System.getProperties();
        String[] sd = uemail.split("@");
        int index = uemail.indexOf("@");
        String dom = uemail.substring(index, uemail.length() - 1);
        String head = "<h1>VacTracker Support</h1>", 
                signature="<footer><address>Team JODEA</address></footer>";
        String body = "<p>"+msg+"</p>";
        
        prop.setProperty("mail.smtp.host", "smtp.outlook.office365.com");
        prop.setProperty("mail.smtp.port", "587");
        prop.put("mail.password", password);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        };
        InternetAddress ia = new InternetAddress(email);
        Session session = Session.getInstance(prop, auth);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(uemail));
        message.setSubject(subject);
        message.addHeader("Content-Transfer-Encoding", "8bit");
        message.setSentDate(new Date());
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(head+body+signature, "text/html; charset=utf-8");
        
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);
//Email
//com.sun.mail.dsn.
        Transport.send(message);
        System.out.println("message sent.");
    }

    public static void sendVerificationEmail(String recip) throws AddressException, MessagingException {
        String msg = "<h1>This is my first email using JavaMailer</h1>";
//        SimpleEmail email = new SimpleEMail();
        Properties prop = System.getProperties();//new Properties(); //System.getProperties();
        prop.setProperty("mail.stmp.host", "localhost");//smtp.gmail.com
//        prop.put("mail.smtp.host", "smtp.mailtrap.io");
//        prop.put("mail.smtp.port", "8080");

//        prop.setProperty("", msg);
        prop.setProperty("mail.password", password);

        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
//        Session session = Session.getInstance(prop);
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        ;
        };    
//       Provider provider - new Provider();
Session session = Session.getInstance(prop, auth);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("VacTrack@workmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recip));
        message.setSubject("Mail Subject");
//        message.addHeader(msg, msg);
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
//        return new String();
    }
}
