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
public class ChangePassServlet extends HttpServlet {

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
            out.println("<title>Servlet ChangePassServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePassServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession ses = request.getSession();
        Customers c = (Customers) ses.getAttribute("acc");
        if (c != null) {
            request.setAttribute("change", "ok");
            request.getRequestDispatcher("changepass.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("login");
        }
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
        String old = request.getParameter("old");
        String new1 = request.getParameter("new");
        String new2 = request.getParameter("new1");
        HttpSession ses = request.getSession();
        CustomerDao d = new CustomerDao();
        Customers cc = d.checkPass(old);
        if (cc != null) {
            if (!old.equals(cc.getPass())) {
                String err = "You must enter exactly old password!";
                request.setAttribute("err", err);
                request.setAttribute("change", "ok");
                request.getRequestDispatcher("changepass.jsp").forward(request, response);
            }
            else if (!new2.equals(new1)) {
                Customers cu = new Customers(old);
                String err = "You must confirm exactly new password!";
                request.setAttribute("info", cu);
                request.setAttribute("err", err);
                request.setAttribute("change", "ok");
                request.getRequestDispatcher("changepass.jsp").forward(request, response);
            } else {
                Customers cu = new Customers(cc.getId(), cc.getName(), cc.getUser(), new1, cc.getEmail(), cc.getPhone(), cc.getAddress());
                d.update(cu);
                ses.setAttribute("acc",cu);
                response.sendRedirect("home");
            }
        } else {
            String err = "This password isn't exist before!";
            request.setAttribute("err", err);
            request.setAttribute("change", "ok");
            request.getRequestDispatcher("changepass.jsp").forward(request, response);
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
