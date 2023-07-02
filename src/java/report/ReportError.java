/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

/**
 *
 * @author nguyenhuuphuoc
 */
public class ReportError {

    private String reportIDLengthErr;
    private String reportNameLengthErr;
    private String contentLengthErr;
    private String userIDLengthErr;

    public ReportError() {
        // Default constructor
    }

    public ReportError(String reportIDLengthErr, String reportNameLengthErr, String contentLengthErr, String userIDLengthErr) {
        this.reportIDLengthErr = reportIDLengthErr;
        this.reportNameLengthErr = reportNameLengthErr;
        this.contentLengthErr = contentLengthErr;
        this.userIDLengthErr = userIDLengthErr;
    }

    public String getReportIDLengthErr() {
        return reportIDLengthErr;
    }

    public void setReportIDLengthErr(String reportIDLengthErr) {
        this.reportIDLengthErr = reportIDLengthErr;
    }

    public String getReportNameLengthErr() {
        return reportNameLengthErr;
    }

    public void setReportNameLengthErr(String reportNameLengthErr) {
        this.reportNameLengthErr = reportNameLengthErr;
    }

    public String getContentLengthErr() {
        return contentLengthErr;
    }

    public void setContentLengthErr(String contentLengthErr) {
        this.contentLengthErr = contentLengthErr;
    }

    public String getUserIDLengthErr() {
        return userIDLengthErr;
    }

    public void setUserIDLengthErr(String userIDLengthErr) {
        this.userIDLengthErr = userIDLengthErr;
    }

   

    
}
