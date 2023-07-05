/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import contracts.ContractDAO;
import contracts.ContractDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import otleaves.OTLeavesDAO;
import otleaves.OTLeavesDTO;
import users.UserDAO;
import users.UserDTO;

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
    
    private static final String SEARCH_USER = "SearchUser";
    private static final String SEARCH_USER_PAGE = "SearchUserServlet";

    private static final String UPDATE_USER = "UpdateUser";
    private static final String UPDATE_USER_PAGE = "UpdateUserServlet";

    private static final String DELETE_USER = "DeleteUser";
    private static final String DELETE_USER_PAGE = "DeleteUserServlet";

    private static final String ADD_USER = "AddUser";
    private static final String ADD_USER_PAGE = "createUser.html";
    
    private static final String CREATE_USER = "CreateUser";
    private static final String CREATE_USER_PAGE= "CreateUserServlet";

    private static final String CONTRACT = "Contract";
    private static final String CONTRACT_PAGE = "contract.jsp";

    private static final String SEARCH_CONTRACT = "SearchContract";
    private static final String SEARCH_CONTRACT_PAGE= "SearchContractServlet";
    
    private static final String DELETE_CONTRACT = "DeleteContract";
    private static final String DELETE_CONTRACT_PAGE= "DeleteContractServlet";
    
    private static final String ADD_CONTRACT = "AddContract";
    private static final String ADD_CONTRACT_PAGE= "createContract.html";
    
    private static final String CREATE_CONTRACT = "CreateContract";
    private static final String CREATE_CONTRACT_PAGE= "CreateContractServlet";
    
    private static final String OTLEAVES = "Leave";
    private static final String OTLEAVES_PAGE = "OTLeaves.jsp";

    private static final String SEARCH_LEAVE = "SearchLeave";
    private static final String SEARCH_LEAVE_PAGE = "SearchLeavesServlet";
    
    private static final String DELETE_LEAVE = "DeleteLeave";
    private static final String DELETE_LEAVE_PAGE = "DeleteLeavesServlet";

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
        UserDAO userDAO = new UserDAO();    
        ContractDAO contractDAO = new ContractDAO();
        OTLeavesDAO otleavesDAO = new OTLeavesDAO();
        
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = WELCOME_PAGE;
            } else if (LOGIN.equals(action)) {
                url = LOGIN_PAGE;
            } else if (USERTABLE.equals(action)) {
                List<UserDTO> allUser = userDAO.searchAll();
                url = USERTABLE_PAGE;
                request.setAttribute("LIST_USER", allUser);
            } else if (CONTRACT.equals(action)) {
                List<ContractDTO> allContract = contractDAO.searchAll();
                url = CONTRACT_PAGE;
                request.setAttribute("LIST_CONTRACT", allContract);
            } else if (OTLEAVES.equals(action)) {
                List<OTLeavesDTO> allLeaves = otleavesDAO.searchAll();
                url = OTLEAVES_PAGE;
                request.setAttribute("LIST_OTLEAVES", allLeaves);
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
            } else if (SEARCH_CONTRACT.equals(action)) {
                url = SEARCH_CONTRACT_PAGE;
            } else if (DELETE_CONTRACT.equals(action)) {
                url = DELETE_CONTRACT_PAGE;
            } else if (ADD_CONTRACT.equals(action)) {
                url = ADD_CONTRACT_PAGE;
            } else if (CREATE_CONTRACT.equals(action)) {
                url = CREATE_CONTRACT_PAGE;
            } else if (SEARCH_LEAVE.equals(action)) {
                url = SEARCH_LEAVE_PAGE;
            } else if (DELETE_LEAVE.equals(action)) {
                url = DELETE_LEAVE_PAGE;
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
