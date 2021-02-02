package com.example.springexample.demo.Model;

import java.util.concurrent.atomic.AtomicLong;

public class Product {
   private static final AtomicLong counter=  new AtomicLong();
   private String id;
   private String name;
   private int categoryId;
   private double price;
   private int qty;

    public Product(String id, String name, int categoryId, double price) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
    }

    public Product(String id, String name, int categoryId, double price, int qty) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public static AtomicLong getCounter() {
        return counter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj){
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (getClass()!=obj.getClass())
            return false;
        Product other =  (Product) obj;
        if (id!=other.id)
            return false;
        return true;
    }
    @Override
    public String toString(){
        return "Product [id="+id+", name ="+name+",categoryId= "+categoryId+", price="+price+"]";
    }
}
