package com.slager.datasource.dao;

import com.slager.datasource.queryhelper.*;
import com.slager.dto.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.*;
import org.springframework.jdbc.core.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class ProductDAOTests {

    @Test
    public void getProducts(){
        //Arrange
        QueryHelper mockedQueryHelper = Mockito.mock(QueryHelper.class);
        ProductDAO sut = new ProductDAO(mockedQueryHelper);
        List emptyList = List.of();
        ProductsDTO productsDTO = new ProductsDTO(emptyList);
        ArrayList<Object> params = new ArrayList<>();
        Mockito.doReturn(emptyList).when(mockedQueryHelper).executeQueryWithResultAndTransaction("",params,(resultSet,rownum)->{return null;});

        //Act & Assert
        assertEquals(productsDTO.getProducts(),sut.getProducts(0).getProducts());
    }

    @Test
    public void getProductWithNull(){
        //Arrange
        QueryHelper mockedQueryHelper = Mockito.mock(QueryHelper.class);
        ProductDAO sut = new ProductDAO(mockedQueryHelper);

        ProductDetailDTO productDetailDTO = new ProductDetailDTO(0,"",0.0F,0,0);
        List listOfDetails = List.of(productDetailDTO);
        ArrayList<Object> params = new ArrayList<>();
        Mockito.doReturn(listOfDetails).when(mockedQueryHelper)
                .executeQueryWithResultAndTransaction("",params,(resultSet,rownum)->{return null;});

        //Act & Assert
        assertEquals(null,
                sut.getProduct(0,0));
    }

    @Test
    public void getProductWithoutNull(){
        //Arrange
        QueryHelper mockedQueryHelper = Mockito.mock(QueryHelper.class);
        ProductDAO sut = new ProductDAO(mockedQueryHelper);

        ProductDetailDTO productDetailDTO = new ProductDetailDTO(0,"",0.0F,0,0);
        List listOfDetails = List.of(productDetailDTO);
        ArrayList<Object> params = new ArrayList<>();
        Mockito.doReturn(listOfDetails).when(mockedQueryHelper)
                .executeQueryWithResultAndTransaction(ArgumentMatchers.anyString(),ArgumentMatchers.isA(ArrayList.class), ArgumentMatchers.isA(RowMapper.class));

        //Act & Assert
        assertEquals(listOfDetails.get(0),
                sut.getProduct(0,0));
    }

    @Test
    public void updateProduct(){
        //Arrange
        QueryHelper mockedQueryHelper = Mockito.mock(QueryHelper.class);
        ProductDAO sut = new ProductDAO(mockedQueryHelper);
        ProductDetailDTO productDetailDTO = new ProductDetailDTO(0,"",0,0,0);
        //Act
        sut.updateProduct(0,productDetailDTO);
        //Assert
        verify(mockedQueryHelper).executeQueryWithoutResultWithTransaction(ArgumentMatchers.anyString(),ArgumentMatchers.isA(ArrayList.class));
    }
}
