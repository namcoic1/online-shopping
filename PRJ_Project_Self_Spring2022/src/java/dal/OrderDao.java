/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import model.Cart;
import model.Categories;
import model.Customers;
import model.Items;
import model.Orders;
import model.Products;
import model.Shippers;

/**
 *
 * @author Dell
 */
public class OrderDao extends DBContext {
    
    public List<Orders> getAll() {
        List<Orders> list = new ArrayList<>();
        String sql="select * from Orders";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Orders o=new Orders();
                o.setId(rs.getInt("Id"));
                o.setOrddate(rs.getString("OrderDate"));
                o.setShidate(rs.getString("ShippedDate"));
                o.setShiaddress(rs.getString("ShippedAddress"));
                o.setAmount(rs.getInt("TotalAmount"));
                o.setCusid(rs.getInt("CustomerId"));
                o.setShiid(rs.getInt("ShipperId"));
                list.add(o);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public List<Items> getAllByOrid(int id) {
        List<Items> list = new ArrayList<>();
        ProductDao p = new ProductDao();
        String sql="select * from [Orders Details] where OrderId=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Items o=new Items();
                o.setProduct(p.getById(rs.getInt("ProductId")));
                o.setQuantity(rs.getInt("Quantity"));
                o.setPrice(rs.getInt("UnitPrice"));
                Orders od = new Orders();
                od.setId(rs.getInt("OrderId"));
                o.setOd(od);
                list.add(o);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public List<Orders> getAllByCusid(int id) {
        List<Orders> list = new ArrayList<>();
        String sql="select o.Id, OrderDate, ShippedDate, ShippedAddress, TotalAmount, CustomerId, s.Name from Orders o join Shippers s on ShipperId = s.Id where CustomerId=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Orders o=new Orders();
                o.setId(rs.getInt("Id"));
                o.setOrddate(rs.getString("OrderDate"));
                o.setShidate(rs.getString("ShippedDate"));
                o.setShiaddress(rs.getString("ShippedAddress"));
                o.setAmount(rs.getInt("TotalAmount"));
                o.setCusid(rs.getInt("CustomerId"));
                Shippers s = new Shippers();
                s.setName(rs.getString("Name"));
                o.setShip(s);
                list.add(o);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public List<Orders> getAllByShid(int id) {
        List<Orders> list = new ArrayList<>();
        String sql="select * from Orders where ShipperId=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Orders o=new Orders();
                o.setId(rs.getInt("Id"));
                o.setOrddate(rs.getString("OrderDate"));
                o.setShidate(rs.getString("ShippedDate"));
                o.setShiaddress(rs.getString("ShippedAddress"));
                o.setAmount(rs.getInt("TotalAmount"));
                o.setCusid(rs.getInt("CustomerId"));
                o.setShiid(rs.getInt("ShipperId"));
                list.add(o);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public List<Categories> getByBestCate() {
        List<Categories> list = new ArrayList<>();
        String sql="select c.Name as CateName, COUNT(c.Name) as Total from Categories c join Products p on c.Id = CategoryId join [Orders Details] od on p.Id = ProductId \n" +
            "group by c.Name";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Categories o=new Categories();
                o.setName(rs.getString("CateName"));
                o.setTotal(rs.getInt("Total"));
                list.add(o);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public List<Customers> getByBestCus() {
        List<Customers> list = new ArrayList<>();
        String sql="select c.ContactName, COUNT(c.ContactName) as Total from Customers c join Orders o on c.Id = CustomerId \n" +
            "group by c.ContactName";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Customers o=new Customers();
                o.setName(rs.getString("ContactName"));
                o.setTotal(rs.getInt("Total"));
                list.add(o);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return list;
    }
    public void insert(int id, String address, Cart cart, Customers cus, Shippers shi, int a, int b){
        LocalDate curDate=LocalDate.now();
        String datef=curDate.toString();
        Random s = new Random();
        LocalDate shiDate = LocalDate.now().of(curDate.getYear(), curDate.getMonth(), curDate.getDayOfMonth()+s.nextInt((a-b)+1)+b);
        String datet = shiDate.toString();
        String sql1="insert into Orders values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement st1=connection.prepareStatement(sql1);
            st1.setInt(1, id);
            st1.setString(2, datef);
            st1.setString(3, datet);
            st1.setString(4, address);
            st1.setInt(5, cart.getFinal_total());
            st1.setInt(6, cus.getId());
            st1.setInt(7, shi.getId());
            st1.executeUpdate();
            String sql2="select top 1 Id from Orders order by Id desc";
            PreparedStatement st2=connection.prepareStatement(sql2);
            ResultSet rs=st2.executeQuery();
            if(rs.next()){
                int oid=rs.getInt("Id");
                for(Items i:cart.getItems()){
                    String sql3="insert into [Orders Details] values(?,?,?,?)";
                    PreparedStatement st3=connection.prepareStatement(sql3);
                    st3.setInt(1, i.getProduct().getId());
                    st3.setInt(2, oid);
                    st3.setInt(3, i.getPrice());
                    st3.setInt(4, i.getQuantity());
                    st3.executeUpdate();
                }
            }
//            String sql3="update Products set Quantity=Quantity-? where Id=?";
//            PreparedStatement st4=connection.prepareStatement(sql3);
//            for(Items i:cart.getItems()){
//                st4.setInt(1, i.getQuantity());
//                st4.setInt(2, i.getProduct().getId());
//                st4.executeUpdate();
//            }
        }catch(SQLException e){
            System.err.println("e");
        }
    }
    public void delete(int id, Cart cart){
    }
    public void update(int id, Cart cart, Customers cus, Shippers shi){
    }
    public static void main(String[] args) {
        OrderDao o = new OrderDao();
        System.out.println(o.getByBestCus());
    }
}
