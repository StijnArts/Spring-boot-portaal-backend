package com.slager.datasource.dao;

import com.slager.datasource.queryhelper.*;
import com.slager.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class ProductDAO extends DataAccessObject{

    @Autowired
    public ProductDAO(QueryHelper queryHelper) {
        super(queryHelper);
    }

    public ProductsDTO getProducts(int companyId) {
        ArrayList<Object> parameters = new ArrayList();
        parameters.add(companyId);
        String query = "SELECT P.PRODUCTID, P.[NAME], P.PRICE_PER_KG, I.QUANTITY\n" +
                "FROM COMPANYPRODUCTS CP\n" +
                "JOIN PRODUCT P on P.PRODUCTID = CP.PRODUCTID\n" +
                "JOIN INVENTORY I on I.COMPANYID = CP.COMPANYID AND I.PRODUCTID = CP.PRODUCTID\n" +
                "WHERE CP.COMPANYID = ?\n" +
                "ORDER BY P.[NAME]";
        return new ProductsDTO(queryHelper.executeQueryWithResultAndTransaction(query, parameters, getProductMapper()));
    }

    public ProductDetailDTO getProduct(int companyId, int productId) {
        ArrayList<Object> parameters = new ArrayList();
        parameters.add(companyId);
        parameters.add(productId);
        String query = "SELECT P.PRODUCTID, P.[NAME], P.PRICE_PER_KG, I.QUANTITY, I.QUANTITY_MAX\n" +
                "                FROM COMPANYPRODUCTS CP\n" +
                "                JOIN PRODUCT P on P.PRODUCTID = CP.PRODUCTID\n" +
                "                JOIN INVENTORY I on I.COMPANYID = CP.COMPANYID AND I.PRODUCTID = CP.PRODUCTID\n" +
                "                WHERE CP.COMPANYID = ? AND CP.PRODUCTID = ?\n" +
                "                ORDER BY P.[NAME]";
        List<ProductDetailDTO> productDetailDTOS = queryHelper.executeQueryWithResultAndTransaction(query, parameters, getProductDetailMapper());
        if(productDetailDTOS.size()>0){
            return productDetailDTOS.get(0);
        } else return null;
    }

    private RowMapper<ProductDetailDTO> getProductDetailMapper() {
        return (resultSet, rownum) -> {
            return new ProductDetailDTO(resultSet.getInt(1), resultSet.getString(2),roundToTwoDecimals(resultSet.getDouble(3)),resultSet.getInt(4),resultSet.getInt(5));};
    }

    public void updateProduct(int companyId, ProductDetailDTO productDetailDTO) {
        ArrayList<Object> parameters = new ArrayList();
        parameters.add(productDetailDTO.getPrice());
        parameters.add(productDetailDTO.getName().replaceAll("[^a-zA-Z0-9]", " "));
        parameters.add(productDetailDTO.getId());
        String query = "UPDATE PRODUCT\n" +
                "SET PRICE_PER_KG = ?, NAME = ?\n" +
                "WHERE PRODUCTID = ?\n";
        queryHelper.executeQueryWithoutResultWithTransaction(query, parameters);
        ;
    }

    public RowMapper<ProductDTO> getProductMapper(){
        return (resultSet, rownum) -> {return new ProductDTO(resultSet.getInt(1), resultSet.getString(2),roundToTwoDecimals(resultSet.getDouble(3)),resultSet.getInt(4));};
    }

    public double roundToTwoDecimals(double value){
        return (double) Math.round(value * 100) / 100;
    }
}
