package com.slager.service;

import com.slager.datasource.dao.*;
import com.slager.dto.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class ProductServiceTests {

    private static ProductService sut;
    private static ProductDAO mockedProductDAO = Mockito.mock(ProductDAO.class);
    @BeforeAll
    public static void setup(){
        sut = new ProductService(mockedProductDAO);
    }

    @Test
    public void getProducts(){
        //Arrange
        ProductsDTO productsDTO = new ProductsDTO(List.of());
        Mockito.doReturn(productsDTO).when(mockedProductDAO).getProducts(0);
        //Act & Assert
        assertEquals(productsDTO,sut.getProducts(0));
    }

    @Test
    public void getProduct(){
        //Arrange
        //Act
        sut.getProduct(10,10);
        //Assert
        verify(mockedProductDAO).getProduct(10,10);
    }

    @Test
    void updateProduct() {
        //Arrange
        ProductDetailDTO productsDTO = new ProductDetailDTO(0,"product",0.0F,0,0);
        Mockito.doReturn(productsDTO).when(mockedProductDAO).getProduct(0,0);
        //Act
        sut.updateProduct(0,productsDTO);
        ProductDetailDTO actual = sut.getProduct(0,0);
        //Assert
        verify(mockedProductDAO).updateProduct(0,productsDTO);
        assertEquals(productsDTO,actual);
    }
}
