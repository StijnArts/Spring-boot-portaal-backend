package com.slager.dto;

import java.util.*;

public class ProductsDTO {
    List<ProductDTO> products;

    public ProductsDTO(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
