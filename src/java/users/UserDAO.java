/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import utils.DBUtils;

public class UserDAO {
    private static final String LOGIN = "SELECT Fullname, RoleID FROM Users "
                                      + "WHERE username = ? AND password = ?";
    
    public UserDTO checkLogin(String username, String password) throws SQLException, ClassNotFoundException{
        UserDTO listuser = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if(rs.next()){
                    String Fullname = rs.getString("Fullname");
                    String RoleID = rs.getString("RoleID");
                    listuser = new UserDTO(RoleID, username, Fullname, password, Fullname, Date.valueOf(LocalDate.now()), 0);
                }
            }
            
        } finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(rs!=null) rs.close();
        }
        return listuser;
    }
}
