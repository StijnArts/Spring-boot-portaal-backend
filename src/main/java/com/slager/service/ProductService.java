package com.slager.service;

import com.slager.datasource.dao.*;
import com.slager.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public ProductsDTO getProducts(int companyId) {
        return productDAO.getProducts(companyId);
    }

    public ProductDetailDTO getProduct(int companyId, int productId) {
        return productDAO.getProduct(companyId, productId);
    }

    public ProductDetailDTO updateProduct(int companyId, ProductDetailDTO productDetailDTO) {
        productDAO.updateProduct(companyId,productDetailDTO);
        return getProduct(companyId,productDetailDTO.getId());
    }
}
