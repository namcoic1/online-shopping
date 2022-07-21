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
public class Products {
    int id;
    String name;
    String image;
    int price;
    int stock;
    String detail;
    int cid;
    Categories cate;

    public Products() {
    }

    public Products(String name, String image, int price, int stock, String detail, int cid) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.detail = detail;
        this.cid = cid;
    }
    
    public Products(int id, String name, String image, int price, int stock, String detail, int cid) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.detail = detail;
        this.cid = cid;
    }
    
    public Products(int id, String name, String image, int price, int stock, String detail, int cid, Categories cate) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.detail = detail;
        this.cid = cid;
        this.cate = cate;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Categories getCate() {
        return cate;
    }

    public void setCate(Categories cate) {
        this.cate = cate;
    }

}
