    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Cart {
    List<Items> items;
    int final_total;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Items> items) {
        this.items = items;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
    
    Items getItemById(int id) {
        for (Items i : items) {
            if (i.getProduct().getId() == id) {
                return i;
            }
        }
        return null;
    }
    
    Products getProductById(int id, List<Products> list) {
        for (Products p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }
    
    public int getPriceById(int id) {
        return getItemById(id).getPrice();
    }
    
    public void addItem(Items t) {
        if (getItemById(t.getProduct().getId()) != null) {
            Items m = getItemById(t.getProduct().getId());
            if (m.getQuantity() + t.getQuantity() <= t.getProduct().getStock())
                m.setQuantity(m.getQuantity() + t.getQuantity());
            else 
                m.setQuantity(Math.min(m.getQuantity() + t.getQuantity(), t.getProduct().getStock()));
        } else {
            items.add(t);
        }
    }
    
    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }
    
    public int getTotalQuantity() {
        int t = 0;
        for (Items i : items) {
            t += i.getQuantity();
        }
        return t;
    }
    
    public int getTotalMoney() {
        int t = 0;
        for (Items i : items) {
            t += (i.getQuantity()*i.getPrice());
        }
        return t;
    }
    
    public void setFinal_total(int final_total) {
        this.final_total = final_total;
    }
    
    public int getFinal_total() {
        return final_total;
    }

    public Cart (String t, List<Products> list) {
        items = new ArrayList<>();
        if (t != null && t.length() != 0) {
            String[] s = t.split(",");
            for (String i : s) {
                String[] n = i.split(":");
                int id = Integer.parseInt(n[0]);
                int quantity = Integer.parseInt(n[1]);
                Products p = getProductById(id, list);
                Items it = new Items(p, quantity, p.getPrice()+5);
                addItem(it);
            }
        }
    }
}
