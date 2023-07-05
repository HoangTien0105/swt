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
public class ContractError {
    private int contractIDError;
    private String staffTypeError;
    private Date startDateError;
    private Date endDateError;
    private double salaryError;
    private String userIDError;
    private String contractError;

    public ContractError() {
    }

    public ContractError(int contractIDError, String staffTypeError, Date startDateError, Date endDateError, double salaryError, String userIDError, String contractError) {
        this.contractIDError = contractIDError;
        this.staffTypeError = staffTypeError;
        this.startDateError = startDateError;
        this.endDateError = endDateError;
        this.salaryError = salaryError;
        this.userIDError = userIDError;
        this.contractError = contractError;
    }

    public int getContractIDError() {
        return contractIDError;
    }

    public void setContractIDError(int contractIDError) {
        this.contractIDError = contractIDError;
    }

    public String getStaffTypeError() {
        return staffTypeError;
    }

    public void setStaffTypeError(String staffTypeError) {
        this.staffTypeError = staffTypeError;
    }

    public Date getStartDateError() {
        return startDateError;
    }

    public void setStartDateError(Date startDateError) {
        this.startDateError = startDateError;
    }

    public Date getEndDateError() {
        return endDateError;
    }

    public void setEndDateError(Date endDateError) {
        this.endDateError = endDateError;
    }

    public double getSalaryError() {
        return salaryError;
    }

    public void setSalaryError(double salaryError) {
        this.salaryError = salaryError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getContractError() {
        return contractError;
    }

    public void setContractError(String contractError) {
        this.contractError = contractError;
    }
}
