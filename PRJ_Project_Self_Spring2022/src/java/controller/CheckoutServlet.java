/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDao;
import dal.OrderDao;
import dal.ProductDao;
import dal.ShipperDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Customers;
import model.Products;
import model.Shippers;

/**
 *
 * @author Dell
 */
public class CheckoutServlet extends HttpServlet {

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
            out.println("<title>Servlet CheckoutServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutServlet at " + request.getContextPath() + "</h1>");
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
        ShipperDao s = new ShipperDao();
        HttpSession ses=request.getSession();
        Customers a=(Customers)ses.getAttribute("acc");
        String kind = request.getParameter("shidate");
        String total = request.getParameter("total");
        if(a==null){
            response.sendRedirect("login");
        }else{
            if (!a.getUser().equals("namnguyen")) {
                request.setAttribute("info", a);
                request.setAttribute("kind", kind);
                request.setAttribute("total", total);
                request.setAttribute("allcate", c.getAll());
                request.setAttribute("allship", s.getAll());
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            } else {
                response.sendRedirect("shopcart");
            }
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
        String add = request.getParameter("add");
        String shi_raw = request.getParameter("shi");
        String kind = request.getParameter("kind");
        String total = request.getParameter("total");
        int a = 0, b = 0;
        if (kind.equals("default")) {
            a = 9;
            b = 4;
        }
        else if (kind.equals("rush")) {
            a = 3;
            b = 2;
        } else if (kind.equals("express")) {
            a = 2;
            b = 1;
        }
        ProductDao p = new ProductDao();
        OrderDao od = new OrderDao();
        ShipperDao s = new ShipperDao();
        HttpSession ses=request.getSession();
        Cookie[] arr=request.getCookies();
        String txt="";
        if(arr!=null){
            for(Cookie o:arr){
                if(o.getName().equals("cart")){
                    txt+=o.getValue();
                }
            }
        }
        List<Products> list=p.getAll();
        Cart cart=new Cart(txt, list);
        cart.setFinal_total(Integer.parseInt(total));
        try {
            int id = od.getAll().size()+1;
            Customers acc=(Customers)ses.getAttribute("acc");
            int shi = Integer.parseInt(shi_raw);
            Shippers si = s.getById(shi);
            od.insert(id, add, cart, acc, si, a, b);
            Cookie c=new Cookie("cart", "");
            c.setMaxAge(0);
            response.addCookie(c);
            response.sendRedirect("shopcart?sta=suc");
        } catch(NullPointerException e) {
            System.err.println("e");
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
