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
import model.Shippers;

/**
 *
 * @author Dell
 */
public class ShipperDao extends DBContext {
    
    public List<Shippers> getAll() {
        List<Shippers> list = new ArrayList<>();
        String sql="select * from Shippers";
        try{ 
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Shippers o=new Shippers();
                o.setId(rs.getInt("Id"));
                o.setName(rs.getString("Name"));
                o.setPhone(rs.getString("Phone"));
                o.setStatus(rs.getBoolean("Status"));
                list.add(o);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public Shippers getById(int id) {
        String sql="select * from Shippers where Id=?";
        try{ 
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                Shippers o=new Shippers();
                o.setId(rs.getInt("Id"));
                o.setName(rs.getString("Name"));
                o.setPhone(rs.getString("Phone"));
                o.setStatus(rs.getBoolean("Status"));
                return o;
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return null;
    }
    public void insert(Shippers ca, int id) {
        String sql = "insert into Shippers values(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, ca.getName());
            st.setString(3, ca.getPhone());
            st.setBoolean(4, ca.isStatus());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public void delete(int id) {
        String sql = "delete from Shippers where Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public void update(Shippers ca) {
        String sql = "update Shippers set Name=?, Phone =?, Status=? where Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, ca.getName());
            st.setString(2, ca.getPhone());
            st.setBoolean(3, ca.isStatus());
            st.setInt(4, ca.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void main(String[] args) {
        ShipperDao s = new ShipperDao();
        
    }
}
