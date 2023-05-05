package com.slager.dto;

public class InventoryDTO {
    int productId;
    String name;
    int quantity;
    int maxQuantity;

    public InventoryDTO() {
    }

    public InventoryDTO(int productId, String name, int quantity, int maxQuantity) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}
