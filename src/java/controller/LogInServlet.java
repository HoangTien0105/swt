/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.UserDAO;
import users.UserDTO;

/**
 *
 * @author user
 */
public class LogInServlet extends HttpServlet {
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String HR_MANAGER_PAGE = "hrmanager.jsp";
    private static final String HR_STAFF_PAGE = "hrstaff.jsp";
    private static final String STAFF_PAGE = "staff.jsp";
    private static final int HR_MANAGER = 0;
    private static final int HR_STAFF   = 1;
    private static final int STAFF      = 2;
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
        String url = LOGIN_PAGE;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            UserDAO dao = new UserDAO();
            UserDTO user = dao.checkLogin(username, password);
            if(user==null){
                request.setAttribute("ERROR", "Incorrect username or password");
            }else{
                int roleID = user.getRoleID();
                HttpSession session = request.getSession();
                if(roleID==0){
                    url = HR_MANAGER_PAGE;
                    session.setAttribute("LOGIN_USER", user);
                } else if (roleID==1){
                    url = HR_STAFF_PAGE;
                    session.setAttribute("LOGIN_USER", user);
                } else if (roleID==2){
                    url = STAFF_PAGE;
                    session.setAttribute("LOGIN_USER", user);
                } else {
                    request.setAttribute("ERROR", "Your role is not supported");
                }
            }
        } catch (Exception e) {
            log("Error at LogInServlet: " + e.toString());
        } finally{
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
