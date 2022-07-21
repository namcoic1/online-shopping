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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.Items;
import model.Products;

/**
 *
 * @author Dell
 */
public class ProcessServlet extends HttpServlet {

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
            out.println("<title>Servlet ProcessServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessServlet at " + request.getContextPath() + "</h1>");
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
        ProductDao po = new ProductDao();
        CategoryDao ca = new CategoryDao();
        List<Products> list = po.getAll();
        Cookie[] arr=request.getCookies();
        String txt="";
        if(arr!=null){
            for(Cookie o:arr){
                if(o.getName().equals("cart")){
                    txt+=o.getValue();
//                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        Cart cart=new Cart(txt, list);
        String num_raw=request.getParameter("num");
        String id_raw=request.getParameter("id");
        int id,num;
        try{
            id=Integer.parseInt(id_raw);
            Products p=po.getById(id);
            int numStore=p.getStock();
            num=Integer.parseInt(num_raw);
            if(num==-1&&(cart.getQuantityById(id)<=1)){
                cart.removeItem(id);
            }else{
//                if((num==1) && cart.getQuantityById(id)>=numStore){
//                    num=0;
//                }
                int price=p.getPrice()+5;
                Items t=new Items(p, num, price);
                cart.addItem(t);
            }
        }catch(NumberFormatException e){
            System.err.println("e");
        }
        List<Items> items=cart.getItems();
        txt="";
        if(items.size()>0){
            txt=items.get(0).getProduct().getId()+":"+items.get(0).getQuantity();
            for (int i = 1; i < items.size(); i++) {
                txt+=","+items.get(i).getProduct().getId()+":"+items.get(i).getQuantity();
            }
        }
        Cookie c=new Cookie("cart", txt);
        c.setMaxAge(3*24*60*60);
        response.addCookie(c);
        response.sendRedirect("shopcart");
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
        ProductDao po = new ProductDao();
        CategoryDao ca = new CategoryDao();
        List<Products> list=po.getAll();
        Cookie[] arr=request.getCookies();
        String txt="";
        if(arr!=null){
            for(Cookie o:arr){
                if(o.getName().equals("cart")){
                    txt+=o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        String id=request.getParameter("id");
        String[] ids=txt.split(",");
        String out="";
        for (int i = 0; i < ids.length; i++) {
            String[] s=ids[i].split(":");
            if(!s[0].equals(id)){
                if(out.isEmpty()){
                    out=ids[i];
                }else{
                    out+=","+ids[i];
                }
            }
        }
        if(!out.isEmpty()){
            Cookie c=new Cookie("cart", out);
            c.setMaxAge(3*24*60*60);
            response.addCookie(c);
        }
        Cart cart=new Cart(out, list);
        response.sendRedirect("shopcart");
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
