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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class UserDAO {

    private static final String LOGIN = "SELECT UserID, Fullname, PhoneNumber, DateOfBirth, RoleID FROM Users "
            + "WHERE username = ? AND password = ?";

    private static final String SEARCH = "SELECT UserID, Username, Fullname, Password, PhoneNumber, DateOfBirth, RoleID FROM Users "
            + "WHERE Fullname like ?";

    private static final String UPDATE = "UPDATE Users "
            + "SET Username=?, Fullname=?, PhoneNumber=?, RoleID=? "
            + "WHERE UserID=?";

    private static final String DELETE = "DELETE FROM Users "
            + "WHERE UserID=?";

    private static final String INSERT = "INSERT INTO Users(UserID, Username, Fullname, Password, PhoneNumber, DateOfBirth, RoleID) "
            + "VALUES(?,?,?,?,?,?,?)";

    public UserDTO checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        UserDTO listuser = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String userID = rs.getString("UserID");
                    String fullName = rs.getString("Fullname");
                    String phoneNumber = rs.getString("PhoneNumber");
                    Date date = rs.getDate("DateOfBirth");
                    int roleID = Integer.parseInt(rs.getString("RoleID"));
                    listuser = new UserDTO(userID, username, fullName, password, phoneNumber, date, roleID);
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return listuser;
    }

    public List<UserDTO> search(String search) throws SQLException, ClassNotFoundException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("UserID");
                    String username = rs.getString("Username");
                    String fullName = rs.getString("Fullname");
                    String password = rs.getString("Password");
                    String phoneNumber = rs.getString("PhoneNumber");
                    Date date = rs.getDate("DateOfBirth");
                    int roleID = Integer.parseInt(rs.getString("RoleID"));
                    list.add(new UserDTO(userID, username, fullName, password, phoneNumber, date, roleID));
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean update(UserDTO user) throws SQLException, ClassNotFoundException {
        boolean checked = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getUsername());
                ptm.setString(2, user.getFullname());
                ptm.setString(3, user.getPhoneNumber());
                ptm.setInt(4, user.getRoleID());
                ptm.setString(5, user.getUserID());
                checked = ptm.executeUpdate() > 0 ? true : false;
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

    public boolean delete(String userID) throws SQLException, ClassNotFoundException {
        boolean checked = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, userID);
                checked = ptm.executeUpdate() > 0 ? true : false;
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

    public boolean insert(UserDTO user) throws SQLException, ClassNotFoundException {
        boolean checked = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getUsername());
                ptm.setString(3, user.getFullname());
                ptm.setString(4, user.getPassword());
                ptm.setString(5, user.getPhoneNumber());
                ptm.setDate(6, user.getDateOfBirth());
                ptm.setInt(7, user.getRoleID());
                checked = ptm.executeUpdate() > 0 ? true : false;
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

    public static ArrayList<UserDTO> getAccounts() throws Exception {
        ArrayList<UserDTO> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "select UserID, Username, Fullname, Password, Phonenumber, DateOfBirth, roleID"
                    + " from dbo.Users";
            Statement st = cn.createStatement();
            ResultSet table = st.executeQuery(sql);
            if (table != null) {
                while (table.next()) {
                    String AccID = table.getString("UserID");
                    String Username = table.getString("Username");
                    String Fullname = table.getString("Fullname");
                    String Password = table.getString("Password");
                    String Phone = table.getString("Phonenumber");
                    Date date = table.getDate("DateOfBirth");
                    int Role = table.getInt("RoleID");
                    UserDTO acc = new UserDTO(AccID, Username, Fullname, Password, Phone, date, Role);
                    list.add(acc);
                }
            }
            cn.close();
        }
        return list;
    }

    public static ArrayList<UserDTO> getAccountByUsername(String username) throws Exception {
        ArrayList<UserDTO> list = new ArrayList<>();
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "select UserID, Username, Fullname, Password, Phonenumber, DateOfBirth, roleID"
                    + " from dbo.Users where username=? COLLATE Latin1_General_CS_AS";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet table = pst.executeQuery();
            if (table != null) {
                while (table.next()) {
                    String AccID = table.getString("UserID");
                    String Username = table.getString("Username");
                    String Fullname = table.getString("Fullname");
                    String Password = table.getString("Password");
                    String Phone = table.getString("Phonenumber");
                    Date date = table.getDate("DateOfBirth");
                    int Role = table.getInt("RoleID");
                    UserDTO acc = new UserDTO(AccID, Username, Fullname, Password, Phone, date, Role);
                    list.add(acc);
                }
            }
            cn.close();
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        try {
            ArrayList<UserDTO> list = UserDAO.getAccounts();
            for (UserDTO account : list) {
                System.out.println(account);
//                System.out.println(account.getUserID() + "," + account.getUsername() + "," + account.getPassword() + ","
//                        + account.getFullname() + "," + account.getPhoneNumber() + 
//                        ","  + account.getDateOfBirth() + "," + account.getRoleID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
