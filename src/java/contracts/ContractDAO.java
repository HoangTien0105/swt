/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contracts;

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
public class ContractDAO {
    
    private static final String SEARCH_ALL = "SELECT ContractID, StaffType, ContractStartDate, ContractEndDate, Salary, UserID FROM PersonalContract";
    
    private static final String SEARCH = "SELECT ContractID, StaffType, ContractStartDate, ContractEndDate, Salary, UserID FROM PersonalContract "
                                       + "WHERE UserID like ?";
    
    private static final String DELETE = "DELETE FROM PersonalContract "
                                       + "WHERE ContractID=?";
    
    public List<ContractDTO> searchAll() throws SQLException, ClassNotFoundException{
        List<ContractDTO> list = new ArrayList<>();
        Connection conn=null;
        PreparedStatement ptm=null;
        ResultSet rs=null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(SEARCH_ALL);
                rs = ptm.executeQuery();
                while(rs.next()){
                    int contractID = rs.getInt("ContractID");
                    String staffType = rs.getString("StaffType");
                    Date contractStartDate = rs.getDate("ContractStartDate");
                    Date contractEndDate = rs.getDate("ContractEndDate");
                    double salary = rs.getDouble("Salary");
                    String userID = rs.getString("UserID");
                    
                    list.add(new ContractDTO(contractID, staffType, contractEndDate, contractEndDate, salary, userID));
                }
            }
        }finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return list;
    }

    public List<ContractDTO> search(String search) throws SQLException, ClassNotFoundException {
        List<ContractDTO> contractList = new ArrayList<>();
        Connection conn=null;
        PreparedStatement ptm=null;
        ResultSet rs=null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%"+search +"%");
                rs=ptm.executeQuery();
                while(rs.next()){
                    int contractID = rs.getInt("ContractID");
                    String staffType = rs.getString("StaffType");
                    Date contractStartDate = rs.getDate("ContractStartDate");
                    Date contractEndDate = rs.getDate("ContractEndDate");
                    double salary = rs.getDouble("Salary");
                    String userID = rs.getString("UserID");
 
                    contractList.add(new ContractDTO(contractID, staffType, contractEndDate, contractEndDate, salary, userID));
                }
            }
        }finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return contractList;
    }

    public boolean delete(int contractID) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        PreparedStatement ptm=null;
        boolean check=false;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                ptm = conn.prepareStatement(DELETE);
                ptm.setInt(1, contractID);
                check = ptm.executeUpdate()>0 ? true:false;
            }
        }finally{
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }

    public boolean insert(ContractDTO contract) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean checkDuplicate(int contractID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
