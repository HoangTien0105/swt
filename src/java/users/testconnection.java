/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.util.ArrayList;

/**
 *
 * @author nguyenhuuphuoc
 */
public class testconnection {
        public static void main(String[] args) throws Exception {
        try {
            ArrayList<UserDTO> list = UserDAO.getAccounts();
            for (UserDTO account : list) {
//                System.out.println(account);
                System.out.println(account.getUserID() + "," + account.getUsername() + "," + account.getPassword() + ","
                        + account.getFullname() + "," + account.getPhoneNumber() + 
                        ","  + account.getDateOfBirth() + "," + account.getRoleID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
