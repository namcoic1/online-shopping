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

/**
 *
 * @author Dell
 */
public class CategoryDao extends DBContext{
    
    public List<Categories> getAll() {
        List<Categories> list = new ArrayList<>();
        String sql="select * from Categories";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Categories ca=new Categories();
                ca.setId(rs.getInt("Id"));
                ca.setName(rs.getString("Name"));
                ca.setImage(rs.getString("Image"));
                ca.setDes(rs.getString("Description"));
                list.add(ca);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public Categories getById(int id) {
        String sql="select * from Categories where Id=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Categories ca=new Categories();
                ca.setId(rs.getInt("Id"));
                ca.setName(rs.getString("Name"));
                ca.setImage(rs.getString("Image"));
                ca.setDes(rs.getString("Description"));
                return ca;
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return null;
    }
    public Categories getByName(String name) {
        String sql="select * from Categories where Name like '%"+name+"%'";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Categories ca=new Categories();
                ca.setId(rs.getInt("Id"));
                ca.setName(rs.getString("Name"));
                ca.setImage(rs.getString("Image"));
                ca.setDes(rs.getString("Description"));
                return ca;
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return null;
    }
    public void insert(Categories ca, int id) {
        String sql = "insert into Categories values(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, ca.getName());
            st.setString(3, ca.getImage());
            st.setString(4, ca.getDes());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public void delete(int id) {
        String sql = "delete from Categories where Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public void update(Categories ca) {
        String sql = "update Categories set Name=?, Image=?, Description=? where Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, ca.getName());
            st.setString(2, ca.getImage());
            st.setString(3, ca.getDes());
            st.setInt(4, ca.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) {
        CategoryDao ca = new CategoryDao();
        System.out.println("");
    }
}
