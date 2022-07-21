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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categories;
import model.Products;

/**
 *
 * @author Dell
 */
public class CheckBox_Select_Servlet extends HttpServlet {

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
            out.println("<title>Servlet CheckBoxServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckBoxServlet at " + request.getContextPath() + "</h1>");
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
    boolean isCheck(int d,int[] id){
        if(id==null)
            return false;
        else{
            for (int i = 0; i < id.length; i++) {
                if(id[i]==d)
                    return true;
            }
            return false;
        }  
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String[] id_raw = request.getParameterValues("cid");
        String cid_raw = request.getParameter("cid");
        String op = request.getParameter("op");
        String xpage = request.getParameter("page");
        ProductDao p =new ProductDao();
        CategoryDao c = new CategoryDao();
        List<Products> list1 = p.getAll();
        List<Categories> list2 = c.getAll();
        List<Products> list3;
        
        int[] id = null;
        int page;
        int numPerPage = 4;
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        boolean[] cid = new boolean[list2.size()];
        for (int i = 0; i < cid.length; i++) {
            if(isCheck(list2.get(i).getId(), id))
                cid[i]=true;
            else
                cid[i]=false;
        }
        if (id_raw == null) {
            numPerPage = 8;
            if (op.equals("default")) {
                list3 = p.checkBox(id, "default");
            } else {
                list3 = p.checkBox(id, op);
            }
        }
        else {
            id = new int[id_raw.length];
            for (int i = 0; i < id.length; i++) {
                 id[i] = Integer.parseInt(id_raw[i]);
            }
            for (int i = 0; i < cid.length; i++) {
                if(isCheck(list2.get(i).getId(), id))
                    cid[i]=true;
                else
                    cid[i]=false;
            }
            if (op.equals("default")) {
                list3 = p.checkBox(id, "default");
            } else {
                list3 = p.checkBox(id, op);
            }
        }
        int size = list3.size();
        int num = (size%numPerPage==0? size/numPerPage : size/numPerPage + 1);
        start = (page - 1)*numPerPage;
        end = Math.min(page*numPerPage, size);
        List<Products> list = p.getListByPage(list3, start, end);
        Categories ca;
        request.setAttribute("data", list);
        request.setAttribute("cidd", cid);
        request.setAttribute("size", list3.size());
        request.setAttribute("select", op);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("allpro", list1);
        request.setAttribute("allcate", list2);
        try {
            int cidd = Integer.parseInt(cid_raw);
            ca = c.getById(cidd);
        } catch (NumberFormatException e) {
            ca = null;
            System.err.println("e");
        }
        request.setAttribute("specialcate", ca);
        request.getRequestDispatcher("product.jsp").forward(request, response);
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
