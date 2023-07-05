/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contracts;

import java.sql.Date;

/**
 *
 * @author user
 */
public class ContractDTO {
    private int contractID;
    private String staffType;
    private Date startDate;
    private Date endDate;
    private double salary;
    private String userID;

    public ContractDTO() {
        
    }

    public ContractDTO(int contractID, String staffType, Date startDate, Date endDate, double salary, String userID) {
        this.contractID = contractID;
        this.staffType = staffType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.userID = userID;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
}
