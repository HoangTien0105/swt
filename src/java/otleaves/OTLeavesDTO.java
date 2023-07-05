/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otleaves;

import java.sql.Date;

/**
 *
 * @author user
 */
public class OTLeavesDTO {
    private int leaveID;
    private Date leaveStartDate;
    private Date leaveEndDate;
    private String userID;
    private int roleID;

    public OTLeavesDTO() {
    }

    public OTLeavesDTO(int leaveID, Date leaveStartDate, Date leaveEndDate, String userID, int roleID) {
        this.leaveID = leaveID;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.userID = userID;
        this.roleID = roleID;
    }

    public int getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(int leaveID) {
        this.leaveID = leaveID;
    }

    public Date getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(Date leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public Date getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(Date leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
