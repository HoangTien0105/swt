/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author user
 */
public class UserError {

    private String userIDError;
    private String usernameError;
    private String fullNameError;
    private String passwordError;
    private String confirmError;
    private String phoneNumberError;
    private Date dateOfBirthError;
    private int roleIDError;
    private String error;

    public UserError() {
        this.userIDError = "";
        this.usernameError = "";
        this.fullNameError = "";
        this.passwordError = "";
        this.confirmError = "";
        this.phoneNumberError = "";
        this.dateOfBirthError = Date.valueOf(LocalDate.now());
        this.roleIDError = 2;
        this.error = "";
    }

    public UserError(String userIDError, String usernameError, String fullNameError, String passwordError, String confirmError, String phoneNumberError, Date dateOfBirthError, int roleIDError, String error) {
        this.userIDError = userIDError;
        this.usernameError = usernameError;
        this.fullNameError = fullNameError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.phoneNumberError = phoneNumberError;
        this.dateOfBirthError = dateOfBirthError;
        this.roleIDError = roleIDError;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getPhoneNumberError() {
        return phoneNumberError;
    }

    public void setPhoneNumberError(String phoneNumberError) {
        this.phoneNumberError = phoneNumberError;
    }

    public Date getDateOfBirthError() {
        return dateOfBirthError;
    }

    public void setDateOfBirthError(Date dateOfBirthError) {
        this.dateOfBirthError = dateOfBirthError;
    }

    public int getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(int roleIDError) {
        this.roleIDError = roleIDError;
    }

}
