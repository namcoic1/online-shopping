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
public class Orders {
    int id;
    String orddate;
    String shidate;
    String shiaddress;
    int amount;
    int cusid;
    int shiid;
    Customers cus;
    Shippers ship;
    
    public Orders() {
    }
    
    public Orders(String orddate, String shidate, String shiaddress, int amount, int cusid, int shiid) {
        this.orddate = orddate;
        this.shidate = shidate;
        this.shiaddress = shiaddress;
        this.amount = amount;
        this.cusid = cusid;
        this.shiid = shiid;
    }

    public Orders(int id, String orddate, String shidate, String shiaddress, int amount, int cusid, int shiid) {
        this.id = id;
        this.orddate = orddate;
        this.shidate = shidate;
        this.shiaddress = shiaddress;
        this.amount = amount;
        this.cusid = cusid;
        this.shiid = shiid;
    }

    public Orders(int id, String orddate, String shidate, String shiaddress, int amount, int cusid, int shiid, Customers cus, Shippers ship) {
        this.id = id;
        this.orddate = orddate;
        this.shidate = shidate;
        this.shiaddress = shiaddress;
        this.amount = amount;
        this.cusid = cusid;
        this.shiid = shiid;
        this.cus = cus;
        this.ship = ship;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrddate() {
        return orddate;
    }

    public void setOrddate(String orddate) {
        this.orddate = orddate;
    }

    public String getShidate() {
        return shidate;
    }

    public void setShidate(String shidate) {
        this.shidate = shidate;
    }

    public String getShiaddress() {
        return shiaddress;
    }

    public void setShiaddress(String shiaddress) {
        this.shiaddress = shiaddress;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public int getShiid() {
        return shiid;
    }

    public void setShiid(int shiid) {
        this.shiid = shiid;
    }

    public Customers getCus() {
        return cus;
    }

    public void setCus(Customers cus) {
        this.cus = cus;
    }

    public Shippers getShip() {
        return ship;
    }

    public void setShip(Shippers ship) {
        this.ship = ship;
    }

}
