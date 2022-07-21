/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDao;
import dal.CustomerDao;
import dal.OrderDao;
import dal.ProductDao;
import dal.ShipperDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customers;
import model.Orders;
import model.Products;

/**
 *
 * @author Dell
 */
public class Delete_3_Servlet extends HttpServlet {

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
            out.println("<title>Servlet DeleteCusCatePro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteCusCatePro at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        CustomerDao cu = new CustomerDao();
        CategoryDao c = new CategoryDao();
        ProductDao p = new ProductDao();
        ShipperDao shi = new ShipperDao();
        OrderDao od = new OrderDao();
        HttpSession ses=request.getSession();
        Customers a=(Customers)ses.getAttribute("acc");
        if (a != null && a.getUser().equals("namnguyen")) {
            try {
                int id = Integer.parseInt(id_raw);
                if (name.equals("Customer")) {
                    cu.delete(id);
                    response.sendRedirect("admmanage?kind=cus");
                } else if (name.equals("Product")) {
                    p.delete(id);
                    response.sendRedirect("admmanage?kind=pro");
                } else if (name.equals("Category")) {
                    List<Products> list = p.getAllByCid(id);
                    if (list.isEmpty()) {
                        c.delete(id);
                        response.sendRedirect("admmanage?kind=cate");
                    } else {
                        request.setAttribute("err", "Can't delete this category because it's including the products!");
                        request.setAttribute("cate", c.getAll());
                        request.setAttribute("allcate", c.getAll());
                        request.setAttribute("select", "cate");
                        request.getRequestDispatcher("manage.jsp").forward(request, response);
                    } 
                } else if (name.equals("Shipper")) {
                    List<Orders> list = od.getAllByShid(id);
                    if (list.isEmpty()) {
                        shi.delete(id);
                        response.sendRedirect("admmanage?kind=shi");
                    } else {
                        request.setAttribute("err", "Can't delete this shipper because it's including the orders!");
                        request.setAttribute("allship", shi.getAll());
                        request.setAttribute("allcate", c.getAll());
                        request.setAttribute("select", "shi");
                        request.getRequestDispatcher("manage.jsp").forward(request, response);
                    } 
                }
            } catch (NumberFormatException e) {
                System.err.println("e");
            }
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
