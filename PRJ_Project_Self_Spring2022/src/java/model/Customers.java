/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dell
 */
public class Customers {
    int id;
    String name;
    String user;
    String pass;
    String email;
    String phone;
    String address;
    int total;

    public Customers() {
    }

    public Customers(String pass) {
        this.pass = pass;
    }
    
    public Customers(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    public Customers(int id, String name, String user, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    public Customers(String name, String user, String pass, String email, String phone, String address) {
        this.name = name;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    public Customers(int id, String name, String user, String pass, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
