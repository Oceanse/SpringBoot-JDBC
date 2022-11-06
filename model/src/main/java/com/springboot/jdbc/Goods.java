package com.springboot.jdbc;

public class Goods {

    private String name; //商品名称

    private double price; //商品单价

    private int number; //商品库存

    private String Supplier; //商品生产厂商

    public Goods(String name, double price, int number, String Supplier) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.Supplier = Supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public String describeDetails(){
        return "商品名称："+name+"\n商品价格："+price+"\n库存数量："+number+"\n生产厂商："+Supplier;
    }
}
