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
public class Items {
    
    Products product;
    Orders od;
    int quantity;
    int price;

    public Items() {
    }

    public Items(Products product, int quantity, int price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Items(Products product, int quantity, int price, Orders od) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.od = od;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Orders getOd() {
        return od;
    }

    public void setOd(Orders od) {
        this.od = od;
    }
    
    
}
