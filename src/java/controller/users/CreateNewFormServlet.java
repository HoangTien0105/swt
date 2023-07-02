/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import report.ReportDAO;
import report.ReportDTO;
import report.ReportError;

/**
 *
 * @author nguyenhuuphuoc
 */
@WebServlet(name = "CreateNewForm", urlPatterns = {"/CreateNewForm"})
public class CreateNewFormServlet extends HttpServlet {

    private String ERROR_PAGE = "Report.jsp";
    private String STAFF_PAGE = "staff.jsp";

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
        PrintWriter out = response.getWriter();
        String reportid = request.getParameter("txtreportID");
        String reportname = request.getParameter("txtreportName");
        String content = request.getParameter("txtcontent");
        String userid = request.getParameter("txtuserID");
        boolean foundErr = false;
        ReportError errors = new ReportError();
        String url = ERROR_PAGE;
        try {
            if (reportid.trim().length() < 2 || reportid.trim().length() > 20) {
                foundErr = true;
                errors.setReportIDLengthErr("ReportID is required 2 - 20 characters");
            }
            if (reportname.trim().length() < 2 || reportname.trim().length() > 30) {
                foundErr = true;
                errors.setReportNameLengthErr("ReportName is requied 2 to 30 characters");
            }
            if (content.trim().length() < 2) {
                foundErr = true;
                errors.setContentLengthErr("Content is required more than 2 characters");
            }
            if (userid.trim().length() < 3 || userid.trim().length() > 10) {
                foundErr = true;
                errors.setUserIDLengthErr("UserID is requied 3 to 10 characters");
            }
            if (foundErr) {
                //1.1 store errors object attribute
                request.setAttribute("CREATE_ERROR", errors);
                //1.2 pass to error page to show
            } else {
                ReportDAO dao = new ReportDAO();
                ReportDTO dto = new ReportDTO(reportid, reportname, content, userid);
                boolean result = dao.createNewForm(dto);
                if (result) {
                    url = STAFF_PAGE;
                }
            }
        } catch (ClassNotFoundException ex) {
            log("CreateNewForm - ClassNotFound" + ex.getMessage());
        } catch (SQLException ex) {
            log("CreateNewForm  - SQLException" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
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
