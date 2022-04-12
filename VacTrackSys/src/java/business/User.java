/**
 *
 * @author Alex Breitenbach
 */
package business;
//import AppSecurity;

public class User {

    public boolean isSearchedPatients() {
        if (searched == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getSearched() {
        return searched;
    }

    public void setSearched(Boolean searched) {
        this.searched = searched;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(String accesslevel) {
        this.accesslevel = accesslevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassattempt() {
        return passattempt;
    }

    public void setPassattempt(String passattempt) {
        this.passattempt = passattempt;
    }

    private String username, password, accesslevel, email,
            location, passattempt, question, answer;
    
    private Boolean searched = false;
    // default constructor

    public User() {
        this.username = "";
        this.password = "";
        this.accesslevel = "";
        this.email = "";
        this.location = "";
        this.passattempt = "";
        this.searched = false;
        this.question = "";
        this.answer = "";
    }

    //normal constructor.  All fields should be validated BEFORE calling this method.  Add functionality for limiting scope / permissions???
    public User(String username, String password, String accesslevel, String email, String location, String passattempt) {
        this.username = username;
        this.password = password;
        this.accesslevel = accesslevel;
        this.email = email;
        this.location = location;
        this.passattempt = passattempt;
        this.searched = false;
    }

    /**
     * Returns true if User password mataches
     *
     * @return boolean
     *
     */
    public boolean isAuthenticated() {
        if (this.getPassword().equals(this.getPassattempt())) {
            return true;
        }
        return false;
    }

    public void secureInfo() {

    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
