/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otleaves;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author user
 */
public class OTLeavesDAO {
    
    private static final String SEARCH_ALL = "SELECT LeaveID, LeaveStartDate, LeaveEndDate, UserID, RoleID FROM Leave "
            + "WHERE RoleID = 1";
    
    private static final String SEARCH = "SELECT LeaveID, LeaveStartDate, LeaveEndDate, UserID, RoleID FROM Leave "
            + "WHERE RoleID = 1 AND UserID like ?";
    
    private static final String DELETE = "DELETE FROM Leave "
            + "WHERE LeaveID=?";

    public List<OTLeavesDTO> searchAll() throws SQLException, ClassNotFoundException {
        List<OTLeavesDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(SEARCH_ALL);
                rs = ptm.executeQuery();
                while(rs.next()){
                    int ID = rs.getInt("LeaveID");
                    Date startDate = rs.getDate("LeaveStartDate");
                    Date endDate = rs.getDate("LeaveEndDate");
                    String userID = rs.getString("UserID");
                    int roleID = rs.getInt("RoleID");
                    
                    list.add(new OTLeavesDTO(ID, startDate, endDate, userID, roleID));
                }
            }
        }finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return list;
    }

    public List<OTLeavesDTO> search(String searchValue) throws ClassNotFoundException, SQLException {
        List<OTLeavesDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%"+searchValue+"%");
                rs = ptm.executeQuery();
                while(rs.next()){
                    int ID = rs.getInt("LeaveID");
                    Date startDate = rs.getDate("LeaveStartDate");
                    Date endDate = rs.getDate("LeaveEndDate");
                    String userID = rs.getString("UserID");
                    int roleID = rs.getInt("RoleID");
                    
                    list.add(new OTLeavesDTO(ID, startDate, endDate, userID, roleID));
                }
            }
        }finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return list;
    }

    public boolean delete(int leaveID) throws ClassNotFoundException, SQLException {
        boolean checked = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setInt(1, leaveID);
                checked = ptm.executeUpdate()>0? true : false;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checked;
    }
}
