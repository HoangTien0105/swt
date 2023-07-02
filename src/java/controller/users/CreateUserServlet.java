/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import users.UserDAO;
import users.UserDTO;
import users.UserError;

/**
 *
 * @author user
 */
@WebServlet(name = "CreateUserServlet", urlPatterns = {"/CreateUserServlet"})
public class CreateUserServlet extends HttpServlet {

    private static final String ERROR = "createUser.html";
    private static final String SUCCESS = "createUser.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String dateFormat = "yyyy-MM-dd";
        UserError userError = new UserError();

        DateFormat formatter = new SimpleDateFormat(dateFormat);
        try {

            UserDAO dao = new UserDAO();
            boolean check = true;
            String userID = request.getParameter("txtUserID");
            String username = request.getParameter("txtUsername");
            String fullname = request.getParameter("txtFullname");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String phoneNumber = request.getParameter("txtPhoneNumber");
            Date dateOfBirth = (Date) formatter.parse(request.getParameter("DateOfBirth"));
            int roleID = Integer.parseInt(request.getParameter("roleID"));

            if (userID.length() < 1 || userID.length() > 5) {
                userError.setUserIDError("userID must be in [1,5]");
                check = false;
            }

            if (username.length() < 5 || username.length() > 20) {
                userError.setUsernameError("username must be in [5,20]");
                check = false;
            }

            if (fullname.length() < 5 || fullname.length() > 20) {
                userError.setFullNameError("Fullname must be in [5,20]");
                check = false;
            }

            if (!confirm.equals(password)) {
                userError.setConfirmError("2 password are not match!");
                check = false;
            }

            if (phoneNumber.length() < 9 || phoneNumber.length() > 11) {
                userError.setPhoneNumberError("Your phone number is not valid!");
                check = false;
            }

            if (check) {
                UserDTO user = new UserDTO(userID, username, fullname, password, phoneNumber, dateOfBirth, roleID);

                boolean checkInsert = dao.insert(user);
                if (checkInsert) {
                    url = SUCCESS;
                } else {
                    userError.setError("Unknown Error!");
                    request.setAttribute("ERROR_USER", userError);
                }
            } else {
                    request.setAttribute("ERROR_USER", userError);
            }

        } catch (Exception e) {
            log("Error at CreateUserServlet: " + e.toString());
            if(e.toString().contains("duplicate")){
                userError.setUserIDError("There has been user with this UserID before");
                request.setAttribute("ERROR_USER", userError);
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
