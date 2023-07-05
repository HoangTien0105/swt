/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.contracts;

import contracts.ContractDAO;
import contracts.ContractDTO;
import contracts.ContractError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import users.UserDTO;

/**
 *
 * @author user
 */
@WebServlet(name = "CreateContractServlet", urlPatterns = {"/CreateContractServlet"})
public class CreateContractServlet extends HttpServlet {

    private static final String ERROR = "createContract.html";
    private static final String SUCCESS = "createContract.jsp";

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
        ContractError contractError = new ContractError();
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        try {

            ContractDAO dao = new ContractDAO();
            boolean check = true;
            int contractID = Integer.parseInt(request.getParameter("contractID"));
            String staffType = request.getParameter("txtStaffType");
            Date contractStartDate = (Date) formatter.parse(request.getParameter("contractStartDate"));
            Date contractEndDate = (Date) formatter.parse(request.getParameter("contractEndDate"));
            double salary = Double.parseDouble(request.getParameter("salary"));
            String userID = request.getParameter("userID");

            boolean checkDuplicate = dao.checkDuplicate(contractID);
            if (checkDuplicate) {
                check = false;
            }

            if (staffType != "HR Manager" || staffType != "HR Staff" || staffType != "Staff") {
                contractError.setStaffTypeError("Invalid role in our company");
                check = false;
            }

            if (userID.length() < 1 || userID.length() > 5) {
                contractError.setUserIDError("userID must be in [1,5]");
                check = false;
            }

            if (check) {
                ContractDTO contract = new ContractDTO(contractID, staffType, contractEndDate, contractEndDate, salary, userID);

                boolean checkInsert = dao.insert(contract);
                if (checkInsert) {
                    url = SUCCESS;
                } else {
                    contractError.setContractError("Unknown Error!");
                    request.setAttribute("ERROR_CONTRACT", contractError);
                }
            } else {
                request.setAttribute("ERROR_CONTRACT", contractError);
            }

        } catch (Exception e) {
            log("Error at CreateUserServlet: " + e.toString());
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
