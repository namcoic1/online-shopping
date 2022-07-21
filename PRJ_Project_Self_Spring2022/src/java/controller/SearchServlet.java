/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDao;
import dal.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categories;
import model.Products;

/**
 *
 * @author Dell
 */
public class SearchServlet extends HttpServlet {

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
            out.println("<title>Servlet SearchServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        String key = request.getParameter("form");
        String xpage = request.getParameter("page");
        ProductDao p = new ProductDao();
        CategoryDao c = new CategoryDao();
        List<Products> list1 = p.getAll();
        List<Categories> list2 = c.getAll();
        List<Products> list3;
        int id;
        int page;
        int numPerPage = 4;
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        if (key == null) {
            key = "";
        }
        int start, end;
        if (key.trim().length() == 0) {
            response.sendRedirect("product?id=0");  
        }
        else {  
            if ((key.equalsIgnoreCase("sneaker") || key.equalsIgnoreCase("slip-on")
                || key.equalsIgnoreCase("boot") || key.equalsIgnoreCase("sandal"))) {
                list3 = p.search("no", key, 0);
            }
            else {
                try {
                    int num1 = Integer.parseInt(key);
                    list3 = p.search("no", "no", num1);
                } catch(NumberFormatException e) {
                    list3 = p.search(key, "no", 0);
                }
            }
            int size = list3.size();
            int num = (size%numPerPage==0? size/numPerPage : size/numPerPage + 1);
            start = (page - 1)*numPerPage;
            end = Math.min(page*numPerPage, size);
            Categories ca = c.getByName(key);
            List<Products> list = p.getListByPage(list3, start, end);
            request.setAttribute("key", key);
            request.setAttribute("searchpro", list);
            request.setAttribute("size", list3.size());
            request.setAttribute("catename", ca);
            request.setAttribute("page", page);
            request.setAttribute("num", num);
            request.setAttribute("allcate", list2);
            request.getRequestDispatcher("product.jsp").forward(request, response);
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
