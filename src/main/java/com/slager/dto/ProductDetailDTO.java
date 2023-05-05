package com.slager.dto;

public class ProductDetailDTO {
    int id;
    String name;
    double price;
    int quantity;
    int maxQuantity;

    public ProductDetailDTO() {
    }
    public ProductDetailDTO(int id, String name, double price, int quantity, int maxQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}
