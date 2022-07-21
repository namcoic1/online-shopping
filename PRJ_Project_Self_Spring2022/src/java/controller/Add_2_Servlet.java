/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDao;
import dal.ProductDao;
import dal.ShipperDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Categories;
import model.Customers;
import model.Products;
import model.Shippers;

/**
 *
 * @author Dell
 */
public class Add_2_Servlet extends HttpServlet {

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
            out.println("<title>Servlet AddCatePro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCatePro at " + request.getContextPath() + "</h1>");
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
        CategoryDao c = new CategoryDao();
        HttpSession ses=request.getSession();
        Customers a=(Customers)ses.getAttribute("acc");
        String type = request.getParameter("type");
        request.setAttribute("allcate", c.getAll());
        if (a != null && a.getUser().equals("namnguyen")) {
            if (type.equals("pro")) {
                request.setAttribute("pro", type);
            } else if (type.equals("cate")) {
                request.setAttribute("cate", type);
            }
            else if (type.equals("ship")) {
                request.setAttribute("ship", type);
            }
            request.getRequestDispatcher("addany.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        String cid_raw = request.getParameter("cid");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String price_raw = request.getParameter("price");
        String stock_raw = request.getParameter("stock");
        String detail = request.getParameter("detail");
        String phone = request.getParameter("phone");
        String status = request.getParameter("sta");
        String n = request.getParameter("n");
        ProductDao p = new ProductDao();
        CategoryDao c = new CategoryDao();
        ShipperDao shi = new ShipperDao();
        int cid;
        int price;
        int stock;
        if (n.equals("pro")) {
            if (name.trim().length() == 0 || image.trim().length() == 0) {
                request.setAttribute("pro", "pro");
                request.setAttribute("allcate", c.getAll());
                request.setAttribute("err", "Fill in the blank below!");
                request.getRequestDispatcher("addany.jsp").forward(request, response);
            } else {
                try {
                cid = Integer.parseInt(cid_raw);
                price = Integer.parseInt(price_raw);
                stock = Integer.parseInt(stock_raw);
                int lastId = p.getAll().size()+1;
                Products pp = new Products(name, image, price, stock, detail, cid);
                p.insert(pp, lastId);
                response.sendRedirect("admmanage?kind=pro");
                } catch (NumberFormatException e) {
                    System.err.println("e");
                }
            }
        } else if (n.equals("cate")) {
            if (name.trim().length() == 0 || image.trim().length() == 0) {
                request.setAttribute("cate", "cate");
                request.setAttribute("allcate", c.getAll());
                request.setAttribute("err", "Fill in the blank below!");
                request.getRequestDispatcher("addany.jsp").forward(request, response);
            } else {
                int lastId = c.getAll().size()+1;
                Categories cc = new Categories(name, image, detail);
                c.insert(cc, lastId);
                response.sendRedirect("admmanage?kind=cate"); 
            }
        } else if (n.equals("ship")) {
            if (name.trim().length() == 0 || phone.trim().length() == 0) {
                request.setAttribute("ship", "ship");
                request.setAttribute("allcate", c.getAll());
                request.setAttribute("err", "Fill in the blank below!");
                request.getRequestDispatcher("addany.jsp").forward(request, response);
            } else {
                int lastId = shi.getAll().size()+1;
                boolean aa = true;
                if (status.equals("0")) aa = false;
                Shippers ship = new Shippers(name, phone, aa);
                shi.insert(ship, lastId);
                response.sendRedirect("admmanage?kind=shi"); 
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
