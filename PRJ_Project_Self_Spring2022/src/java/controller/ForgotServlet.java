/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CustomerDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customers;

/**
 *
 * @author Dell
 */
public class ForgotServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ForgotServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//        processRequest(request, response);
        response.sendRedirect("changepass.jsp");
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
//        processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        CustomerDao c = new CustomerDao();
        String name = request.getParameter("name");
        String new1 = request.getParameter("new");
        String new2 = request.getParameter("new1");
        Customers cu1 = c.checkUser(name);
        HttpSession ses = request.getSession();
        if (name != null) {
            ses.setAttribute("alter", cu1);
            if (cu1 != null) {
                request.setAttribute("pass", "ok");
            } else {
                request.setAttribute("err", "This username isn't valid!");
            }
            request.getRequestDispatcher("changepass.jsp").forward(request, response);
        } 
        else {
            if (!new2.equals(new1)) {
                String err = "You must confirm exactly new password!";
                request.setAttribute("err", err);
                request.setAttribute("pass", "ok");
                request.getRequestDispatcher("changepass.jsp").forward(request, response);
            } else {
                Customers cc = (Customers) ses.getAttribute("alter");
                Customers cu2 = new Customers(cc.getId(), cc.getName(), cc.getUser(), new1, cc.getEmail(), cc.getPhone(), cc.getAddress());
                c.update(cu2);
                response.sendRedirect("login");
            }
        }
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
