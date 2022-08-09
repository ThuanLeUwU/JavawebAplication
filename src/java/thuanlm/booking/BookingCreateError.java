/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuanlm.booking;

/**
 *
 * @author lthua
 */
public class BookingCreateError {
    private String usernameIssExisted;
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String fullNameLengthErr;
    private String confirmNot;

    /**
     * @return the usernameIssExisted
     */
    public String getUsernameIssExisted() {
        return usernameIssExisted;
    }

    /**
     * @param usernameIssExisted the usernameIssExisted to set
     */
    public void setUsernameIssExisted(String usernameIssExisted) {
        this.usernameIssExisted = usernameIssExisted;
    }

    /**
     * @return the usernameLengthErr
     */
    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    /**
     * @param usernameLengthErr the usernameLengthErr to set
     */
    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    /**
     * @return the passwordLengthErr
     */
    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    /**
     * @param passwordLengthErr the passwordLengthErr to set
     */
    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    /**
     * @return the fullNameLengthErr
     */
    public String getFullNameLengthErr() {
        return fullNameLengthErr;
    }

    /**
     * @param fullNameLengthErr the fullNameLengthErr to set
     */
    public void setFullNameLengthErr(String fullNameLengthErr) {
        this.fullNameLengthErr = fullNameLengthErr;
    }

    /**
     * @return the confirmNot
     */
    public String getConfirmNot() {
        return confirmNot;
    }

    /**
     * @param confirmNot the confirmNot to set
     */
    public void setConfirmNot(String confirmNot) {
        this.confirmNot = confirmNot;
    }
    
}
