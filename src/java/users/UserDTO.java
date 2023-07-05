/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.sql.Date;
import java.time.LocalDate;


public class UserDTO {
    private String UserID;
    private String Username;
    private String Fullname;
    private String Password;
    private String PhoneNumber;
    private Date DateOfBirth;
    private int RoleID;

    public UserDTO() {
        this.UserID = " ";
        this.Username = " ";
        this.Fullname = " ";
        this.Password = " ";
        this.PhoneNumber = " ";
        this.DateOfBirth = Date.valueOf(LocalDate.now());
        this.RoleID = 2;
    }
    
    

    public UserDTO(String UserID, String Username, String Fullname, String Password, String PhoneNumber, Date DateOfBirth, int RoleID) {
        this.UserID = UserID;
        this.Username = Username;
        this.Fullname = Fullname;
        this.Password = Password;
        this.PhoneNumber = PhoneNumber;
        this.DateOfBirth = DateOfBirth;
        this.RoleID = RoleID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }
    
    
}
