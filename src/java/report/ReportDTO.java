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
public class ReportDTO {
    private String reportID;
    private String reportName;
    private String content;
    private String userID;

    public ReportDTO() {
        // Default constructor
    }

    public ReportDTO(String reportID, String reportName, String content, String userID) {
        this.reportID = reportID;
        this.reportName = reportName;
        this.content = content;
        this.userID = userID;
    }

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }




}

