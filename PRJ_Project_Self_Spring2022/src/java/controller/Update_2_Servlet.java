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
public class Update_2_Servlet extends HttpServlet {

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
            out.println("<title>Servlet Update_2_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update_2_Servlet at " + request.getContextPath() + "</h1>");
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
        ProductDao p = new ProductDao();
        CategoryDao c = new CategoryDao();
        ShipperDao shi = new ShipperDao();
        HttpSession ses=request.getSession();
        Customers a=(Customers)ses.getAttribute("acc");
        request.setAttribute("allcate", c.getAll());
        if (a != null && a.getUser().equals("namnguyen")) {
            try {
                int id = Integer.parseInt(id_raw);
                if (name.equals("pro")) {
                    request.setAttribute("pro", name);
                    request.setAttribute("info", p.getById(id));
                } else if (name.equals("cate")) {
                    request.setAttribute("cate", name);
                    request.setAttribute("info", c.getById(id));
                } else if (name.equals("ship")) {
                    request.setAttribute("ship", name);
                    request.setAttribute("info", shi.getById(id));
                }
                request.getRequestDispatcher("updateany.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                System.err.println("e");
            }
        } else {
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
        String id_raw = request.getParameter("id");
        String cid_raw = request.getParameter("cid");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String phone = request.getParameter("phone");
        String price_raw = request.getParameter("price");
        String stock_raw = request.getParameter("stock");
        String detail = request.getParameter("detail");
        String status = request.getParameter("sta");
        String n = request.getParameter("n");
        int id, cid, price, stock;
        ProductDao p = new ProductDao();
        CategoryDao c = new CategoryDao();
        ShipperDao shi = new ShipperDao();
        if (n.equals("pro")) {
            if (name.trim().length() == 0 || image.trim().length() == 0) {
                request.setAttribute("pro", "pro");
                request.setAttribute("allcate", c.getAll());
                request.setAttribute("err", "Fill in the blank below!");
                request.getRequestDispatcher("updateany.jsp").forward(request, response);
            }
            else {
                try {
                id=Integer.parseInt(id_raw);
                cid=Integer.parseInt(cid_raw);
                price=Integer.parseInt(price_raw);
                stock=Integer.parseInt(stock_raw);
                Products pp = new Products(id, name, image, price, stock, detail, cid);
                p.update(pp);
                response.sendRedirect("admmanage?kind=pro");
                }
                catch(NumberFormatException e) {
                    System.err.println(e);
                }
            }
        }
        else if (n.equals("cate")) {
            if (name.trim().length() == 0 || image.trim().length() == 0) {
                    request.setAttribute("cate", "cate");
                    request.setAttribute("allcate", c.getAll());
                    request.setAttribute("err", "Fill in the blank below!");
                    request.getRequestDispatcher("updateany.jsp").forward(request, response);
            }
            else {
                try {
                    id=Integer.parseInt(id_raw);
                    Categories cc = new Categories(id, name, image, detail);
                    c.update(cc);
                    response.sendRedirect("admmanage?kind=cate");
                }
                catch(NumberFormatException e) {
                    System.err.println(e);
                }
            }
        }
        else if (n.equals("ship")) {
            if (name.trim().length() == 0 || phone.trim().length() == 0) {
                    request.setAttribute("ship", "ship");
                    request.setAttribute("allcate", c.getAll());
                    request.setAttribute("err", "Fill in the blank below!");
                    request.getRequestDispatcher("updateany.jsp").forward(request, response);
            }
            else {
                try {
                    id=Integer.parseInt(id_raw);
                    boolean aa = true;
                    if (status.equals("0")) aa = false;
                    Shippers si = new Shippers(id, name, phone, aa);
                    shi.update(si);
                    response.sendRedirect("admmanage?kind=shi");
                }
                catch(NumberFormatException e) {
                    System.err.println(e);
                }
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
