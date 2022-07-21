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
import model.Items;
import model.Products;
import model.Shippers;

/**
 *
 * @author Dell
 */
public class ManageServlet extends HttpServlet {

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
            out.println("<title>Servlet ManageCatProCus_FunServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageCatProCus_FunServlet at " + request.getContextPath() + "</h1>");
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
        CustomerDao cu = new CustomerDao();
        ProductDao p = new ProductDao();
        CategoryDao c = new CategoryDao();
        ShipperDao shi = new ShipperDao();
        OrderDao od = new OrderDao();
        HttpSession ses=request.getSession();
        Customers a=(Customers)ses.getAttribute("acc");
        String kind = request.getParameter("kind");
        String xpage = request.getParameter("page");
        String select;
        int page;
        int numPerPage = 4;
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        request.setAttribute("allcate", c.getAll());
        if (a != null && a.getUser().equals("namnguyen")) {
            if (kind == null) {
                select = "";
                request.setAttribute("select", select);
            }
            else if (kind.equals("cus")) {
                select = kind;
                request.setAttribute("select", select);
                request.setAttribute("allcus", cu.getAll());
            }
            else if (kind.equals("cate")) {
                select = kind;
                request.setAttribute("select", select);
                request.setAttribute("cate", c.getAll());
            }
            else if (kind.equals("pro")) {
                select = kind;
                List<Products> list1 = p.getAllWithCate();
                int size = list1.size();
                int num = (size%numPerPage==0? size/numPerPage : size/numPerPage + 1);
                start = (page - 1)*numPerPage;
                end = Math.min(page*numPerPage, size);
                List<Products> list = p.getListByPage(list1, start, end);
                request.setAttribute("page", page);
                request.setAttribute("num", num);
                request.setAttribute("select", select);
                request.setAttribute("allpro", list);
            }
            else if (kind.equals("shi")) {
                select = kind;
                request.setAttribute("select", select);
                request.setAttribute("allship", shi.getAll());
            }
            else if (kind.equals("sta")) {
                select = kind;
                request.setAttribute("select", select);
                request.setAttribute("sta", "static");
                request.setAttribute("show1", od.getByBestCate());
                request.setAttribute("show2", od.getByBestCus());
            }
            request.getRequestDispatcher("manage.jsp").forward(request, response);
        }else {
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
