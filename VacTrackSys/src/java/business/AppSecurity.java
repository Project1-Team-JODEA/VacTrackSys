/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package business;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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
 * This class provides functions for security purposes. <br>
 * <h2>Functions:</h2>
 * <ul>
 * <li>getGenCode() </li>
 * <li>generateSate() </li>
 * 
 * <li>hasValue(String value, String salt) </li>
 * <li>write() </li>
 * </ul>
 *
 */
public class AppSecurity {

    public static final String AES = "AES", MD5 = "MD5";
//    public final String /
    private String value, valuetype, option, errmsg;
    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int iterations = 10000;
    private static final int keylength = 256, KEY_LENGTH = 512;
    int iterationCount = 1024;
    int keyStrength = 256;
    byte[] iv;
    private static String saltval;
    private byte[] byte_val;
    private KeyGenerator keyGen;
    private static PBEKeySpec spec;
//    private static final String email = "jodeavactracker@outlook.com", username = "VacTrack", password = "JODEAD3velopment";
    private static final String email = "jodeavactracker@outlook.com", username = "VacTrack", password = "JODEAD3velopment";
    private static final SecureRandom RAND = new SecureRandom();
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
    //email = "VacTrack@workmail.com"

    /**
     * Generates 6 digit code
     *
     * @return code (int)
     */
    public static int getGenCode() {
        int code = 0;
        code = (int) (Math.random() * 1000000);

        return code;
    }

    /**
     * Creates a <code>byte[]</code> array with specified <code>KEYLENGTH</code><br>
     * and generates random bytes with a SecureRandom object
     *      *
     * @see java.security.SecureRandom 
     * @see java.util.Optional
     * 
     * @return
     */
    public static Optional<String> generateSalt() {
        byte[] salt = new byte[KEY_LENGTH];
        RAND.nextBytes(salt);
        return Optional.of(Base64.getEncoder().encodeToString(salt));
    }

    /**
     *
     * @param val
     * @param salt
     * @return hashed value (Optional)
     */
    public static Optional<String> hashValue(String val, String salt) {
        char[] chars = val.toCharArray();
        byte[] bytes = salt.getBytes();
        spec = new PBEKeySpec(chars, bytes, iterations, KEY_LENGTH);
        Arrays.fill(chars, Character.MIN_VALUE);
        try {
            SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] secValue = fac.generateSecret(spec).getEncoded();
            return Optional.of(Base64.getEncoder().encodeToString(secValue));
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            spec.clearPassword();
        }
    }

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
//    public static String encrypt(String data) {
//        String encryptedVal = null;
//        try {
//            //        SecureRando
//            SecureRandom random = new SecureRandom();
//            char[] d = data.toCharArray();
//            byte[] salt = new byte[30];//;;getSaltValue();//new byte[30];
//            String xd = getSaltValue();
//
//            random.nextBytes(salt);
//            /* generate hash value*/
//
////            System.out.println(hash);
//            /* generate hash value */
//            KeySpec spec = new PBEKeySpec(d, salt, iterations, keylength);
//            Arrays.fill(d, Character.MIN_VALUE);
//            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//            byte[] hash = factory.generateSecret(spec).getEncoded();
////            byte[] secureVal = get
////            String e = hash.toString();
//            /*Encrypt password using */
//            encryptedVal = Base64.getEncoder().encodeToString(hash);
//
//            return encryptedVal;
//        } catch (InvalidKeySpecException ex) {
//            // Logger.getLogger(AppSecurity.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoSuchAlgorithmException ex) {
//            // Logger.getLogger(AppSecurity.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return data;
//    }
    public static boolean verify(String p, String k, String s) {
        Optional<String> optEncrypted = hashValue(p, s);
        if (!optEncrypted.isPresent()) {
            return false;
        }
        return optEncrypted.get().equals(k);
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

    /**
     *
     * @param uemail User Email (String)
     * @param msg message (String)
     * @param subject subject of email
     */
    public static boolean sendEmail(String uemail, String subject, String msg) {
        try {
            Properties prop = System.getProperties();//new Properties(); //System.getProperties();
            String[] sd = uemail.split("@");
            int index = uemail.indexOf("@");
            String smtp = "";
            String head = "<h1>VacTracker Support</h1> <br> <h3>By Team JODEA</h3>",
                    signature = "<footer><address>Team JODEA</address></footer>";
            String body = "<p>" + msg + "</p>";
            prop.setProperty("mail.smtp.host", "smtp.outlook.office365.com");
            prop.setProperty("mail.smtp.port", "587");
            prop.put("mail.password", password);
//            prop.put("", "");
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
            mimeBodyPart.setContent(head + body + signature, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

//            Provider pv = session.
//            Transport tr = session.
            Transport.send(message);
            System.out.println("message sent.");
            return true;
        } catch (AddressException ex) {
            return false;
        } catch (MessagingException ex) {
            return false;
        } finally {

        }

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

    public static void write(User u, Patient p, String url, String input) throws IOException, ClassNotFoundException, SQLException {
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
