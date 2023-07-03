/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author nguyenhuuphuoc
 */
public class ReportDAO implements Serializable {

    public boolean createNewForm(ReportDTO dto) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Write SQL command
                String sql = "INSERT INTO Report (ReportID , ReportName, Content, UserID)" + " VALUES (?, ?, ?, ?)";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getReportID());
                stm.setString(2, dto.getReportName());
                stm.setString(3, dto.getContent());
                stm.setString(4, dto.getUserID());
                //4. Execute Statement Object to get result
                int row = stm.executeUpdate();
                //5. Process result
                if (row > 0) {
                    result = true;
                }
            }//end connection has existed
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public static ArrayList<ReportDTO> getReports() throws Exception {
        ArrayList<ReportDTO> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "select ReportID, ReportName, Content, UserID"
                    + " from dbo.Report";
            Statement st = cn.createStatement();
            ResultSet table = st.executeQuery(sql);
            if (table != null) {
                while (table.next()) {
                    String ReportID = table.getString("UserID");
                    String ReportName = table.getString("ReportName");
                    String Content = table.getString("Content");
                    String UserID = table.getString("UserID");
                    ReportDTO acc = new ReportDTO(ReportID, ReportName, Content, UserID);
                    list.add(acc);
                }
            }
            cn.close();
        }
        return list;
    }
}
