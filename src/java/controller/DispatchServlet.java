/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {

    private static final String WELCOME_PAGE = "login.html";

    private static final String LOGIN = "LogIn";
    private static final String LOGIN_PAGE = "LogInServlet";

    private static final String USERTABLE = "Usertable";
    private static final String USERTABLE_PAGE = "usertable.jsp";

    private static final String CONTRACT = "Contract";
    private static final String CONTRACT_PAGE = "contract.jsp";

    private static final String OTLEAVES = "OTleaves";
    private static final String OTLEAVES_PAGE = "OTLeaves.jsp";

    private static final String SEARCH_USER = "Search User";
    private static final String SEARCH_USER_PAGE = "SearchUserServlet";

    private static final String UPDATE_USER = "UpdateUser";
    private static final String UPDATE_USER_PAGE = "UpdateUserServlet";

    private static final String DELETE_USER = "DeleteUser";
    private static final String DELETE_USER_PAGE = "DeleteUserServlet";

    private static final String ADD_USER = "Add User";
    private static final String ADD_USER_PAGE = "createUser.html";

    private static final String CREATE_USER = "CreateUser";
    private static final String CREATE_USER_PAGE = "CreateUserServlet";

    private static final String VIEW_INFO = "ViewInfo";
    private static final String VIEW_INFO_PAGE = "ViewInforServlet";

    private static final String REPORT_PAGE = "Report.jsp";

    private static final String CREATE_FORM = "CreateNewForm";
    private static final String CREATENEWFORM_PAGE = "CreateNewFormServlet";

    private static final String VIEW_REPORT = "ViewReport";
    private static final String VIEWREPORT_PAGE = "ViewReportServlet";

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
        String url = WELCOME_PAGE;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = WELCOME_PAGE;
            } else if (LOGIN.equals(action)) {
                url = LOGIN_PAGE;
            } else if (USERTABLE.equals(action)) {
                url = USERTABLE_PAGE;
            } else if (CONTRACT.equals(action)) {
                url = CONTRACT_PAGE;
            } else if (OTLEAVES.equals(action)) {
                url = OTLEAVES_PAGE;
            } else if (SEARCH_USER.equals(action)) {
                url = SEARCH_USER_PAGE;
            } else if (UPDATE_USER.equals(action)) {
                url = UPDATE_USER_PAGE;
            } else if (DELETE_USER.equals(action)) {
                url = DELETE_USER_PAGE;
            } else if (ADD_USER.equals(action)) {
                url = ADD_USER_PAGE;
            } else if (CREATE_USER.equals(action)) {
                url = CREATE_USER_PAGE;
            } else if (VIEW_INFO.equals(action)) {
                url = VIEW_INFO_PAGE;
            } else if (action.equals("searchAccount")) {
                url = "SearchServlet";
            } else if (action.equals("Report")) {
                url = REPORT_PAGE;
            } else if (CREATE_FORM.equals(action)) {
                url = CREATENEWFORM_PAGE;
            } else if (VIEW_REPORT.equals(action)) {
                url = VIEWREPORT_PAGE;
            }

        } catch (Exception e) {
            log("Error at DispatchServlet: " + e.toString());
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
