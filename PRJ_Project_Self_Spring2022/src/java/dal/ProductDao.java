/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categories;
import model.Products;

/**
 *
 * @author Dell
 */
public class ProductDao extends DBContext {
    
    public List<Products> getAll() {
        List<Products> list = new ArrayList<>();
        String sql="select * from Products";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Products p=new Products();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("Name"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("UnitPrice"));
                p.setStock(rs.getInt("UnitStock"));
                p.setDetail(rs.getString("Detail"));
                p.setCid(rs.getInt("CategoryId"));
                list.add(p);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public List<Products> getAllWithCate() {
        List<Products> list = new ArrayList<>();
        String sql = "select p.Id, p.Name, p.Image, UnitPrice, UnitStock, p.Detail, c.Name as cName "
                + "from Products p join Categories c on CategoryId = c.Id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("Name"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("UnitPrice"));
                p.setStock(rs.getInt("UnitStock"));
                p.setDetail(rs.getString("Detail"));
                Categories c = new Categories();
                c.setName(rs.getString("cName"));
                p.setCate(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public Products getById(int id) {
        String sql="select * from Products where Id=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Products p=new Products();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("Name"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("UnitPrice"));
                p.setStock(rs.getInt("UnitStock"));
                p.setDetail(rs.getString("Detail"));
                p.setCid(rs.getInt("CategoryId"));
                return p;
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return null;
    }
    public List<Products> getAllByCid(int id) {
        List<Products> list = new ArrayList<>();
        String sql="select * from Products where CategoryId=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Products p=new Products();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("Name"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("UnitPrice"));
                p.setStock(rs.getInt("UnitStock"));
                p.setDetail(rs.getString("Detail"));
                p.setCid(rs.getInt("CategoryId"));
                list.add(p);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public List<Products> getListByPage(List<Products> list, int start, int end) {
        ArrayList<Products> arr = new ArrayList<>();
        for(int i = start; i < end; i++){
            arr.add(list.get(i));
        }
        return arr;
    }
    public List<Products> search(String name, String catename, int price) {
        List<Products> list = new ArrayList<>();
        String sql="";
        if (name != null && catename.equals("no") && price == 0) {
            sql="select * from Products"
                + " where Name like '%"+name+"%' order by Name, UnitPrice desc";
        } else if (name.equals("no") && catename != null && price == 0) {
            sql="select p.Id, p.Name, p.Image, UnitPrice, UnitStock, Detail, CategoryId from Products p join Categories c on p.CategoryId = c.Id" 
                + " where c.Name like '%"+catename+"%' order by Name, UnitPrice desc";
        } else if (name.equals("no") && catename.equals("no") && price != 0) {
            sql="select top 12 Id, Name, Image, UnitPrice, UnitStock, Detail, CategoryId from Products"
            + " where UnitPrice<="+price+" order by UnitPrice desc, Name";
        }
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Products p=new Products();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("Name"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("UnitPrice"));
                p.setStock(rs.getInt("UnitStock"));
                p.setDetail(rs.getString("Detail"));
                p.setCid(rs.getInt("CategoryId"));
                list.add(p);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public List<Products> checkBox(int[] id, String order){
        List<Products> list = new ArrayList<>();
        String sql = "select p.Id, p.Name, p.Image, UnitPrice, UnitStock, Detail, CategoryId, c.Name, c.Image, c.Description\n" 
                + "from Products p join  Categories c on c.Id = CategoryId"
                + " where 1=1 ";
        if(id != null){
            sql +="and CategoryId in(";
            for (int i = 0; i < id.length; i++) {
                sql += id[i]+",";
            }
            if(sql.endsWith(",")) {
                sql=sql.substring(0, sql.length()-1);
            }
            sql += ") ";
        }
        if (order.equals("best")) {
            sql += "and UnitStock >= 30 order by UnitStock desc";
        }
        else if (order.equals("low")) {
            sql += "order by UnitPrice";
        }
        else if (order.equals("high")) {
            sql += "order by UnitPrice desc";
        } else {
            sql += "";
        }
        try {    
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Products p = new Products();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("Name"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("UnitPrice"));
                p.setStock(rs.getInt("UnitStock"));
                p.setDetail(rs.getString("Detail"));
                p.setCid(rs.getInt("CategoryId"));
                Categories ca = new Categories(rs.getInt("CategoryId"), rs.getString("Name"), rs.getString("Image"), rs.getString("Description"));
                p.setCate(ca);
                list.add(p);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public void insert(Products p, int id) {
        String sql = "insert into Products values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, p.getName());
            st.setString(3, p.getImage());
            st.setInt(4, p.getPrice());
            st.setInt(5, p.getStock());
            st.setString(6, p.getDetail());
            st.setInt(7, p.getCid());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public void delete(int id) {
        String sql = "delete from Products where Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public void update(Products p) {
        String sql = "update Products set Name=?, Image=?, UnitPrice=?, UnitStock=?, Detail=?, CategoryId=? where Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setString(2, p.getImage());
            st.setInt(3, p.getPrice());
            st.setInt(4, p.getStock());
            st.setString(5, p.getDetail());
            st.setInt(6, p.getCid());
            st.setInt(7, p.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) {
        ProductDao p = new ProductDao();

    }
}
