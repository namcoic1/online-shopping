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
import java.util.regex.Pattern;
//import java.util.ArrayList;
//import java.util.List;
import model.Customers;

/**
 *
 * @author Dell
 */
public class CustomerDao extends DBContext {

    public List<Customers> getAll() {
        List<Customers> list = new ArrayList<>();
        String sql = "select * from Customers";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customers ca = new Customers();
                ca.setId(rs.getInt("Id"));
                ca.setName(rs.getString("ContactName"));
                ca.setUser(rs.getString("UserName"));
                ca.setPass(rs.getString("PassWord"));
                ca.setEmail(rs.getString("Email"));
                ca.setPhone(rs.getString("Phone"));
                ca.setAddress(rs.getString("Address"));
                list.add(ca);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    int testChangePass(String user, String newpass, String conformpass) {
        int test, exist = 0;
        String sql = "select * from Customers where UserName=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) exist = 1;
        } catch (SQLException e) { System.err.println(e); }
        System.out.println("User inputs: \nUsername is: " + user + "\nNewPassword is: " + newpass + "\nConformPassword is: " + conformpass);
        if (user != null && exist == 1) test = 1;
        else test = 0;
        if (newpass != null && newpass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,50}$")) test = 1;
        else test = 0;
        if (conformpass != null && conformpass.equals(newpass) && conformpass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,50}$"))
            test = 1;
        else test = 0;
        if (test == 1) {
            System.out.println("Username : success, NewPassword: success, ConformPassword: success.");
            System.out.println("Change password successfully!");
        } else if (exist == 0) {
            System.out.println("Username: fail.");
            System.out.println("Username doesn't exit. Please input another username again!");
        } else System.out.println("Access denied. Please check again username or newpassword or conformpassword!");
        return test;
    }

    public Customers checkPass(String pass) {
        String sql = "select * from Customers where PassWord=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Customers(rs.getInt("Id"), rs.getString("ContactName"), rs.getString("UserName"), rs.getString("PassWord"),
                         rs.getString("Email"), rs.getString("Phone"), rs.getString("Address"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public Customers checkUser(String user) {
        String sql = "select * from Customers where UserName=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Customers(rs.getInt("Id"), rs.getString("ContactName"), rs.getString("UserName"), rs.getString("PassWord"),
                         rs.getString("Email"), rs.getString("Phone"), rs.getString("Address"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public Customers check(String user, String pass) {
        String sql = "select * from Customers where UserName=? and PassWord=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Customers(rs.getInt("Id"), rs.getString("ContactName"), rs.getString("UserName"), rs.getString("PassWord"),
                         rs.getString("Email"), rs.getString("Phone"), rs.getString("Address"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public void insert(Customers c, int id) {
        String sql = "insert into Customers values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, c.getName());
            st.setString(3, c.getUser());
            st.setString(4, c.getPass());
            st.setString(5, c.getEmail());
            st.setString(6, c.getPhone());
            st.setString(7, c.getAddress());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void delete(int id) {
        String sql = "delete from Customers where Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void update(Customers c) {
        String sql = "update Customers set ContactName=?, PassWord=?, Email=?, Phone=?, Address=? where Id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getPass());
            st.setString(3, c.getEmail());
            st.setString(4, c.getPhone());
            st.setString(5, c.getAddress());
            st.setInt(6, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        CustomerDao c = new CustomerDao();
        c.testChangePass("thanh123", "123Aa$Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "123Aa$Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}
