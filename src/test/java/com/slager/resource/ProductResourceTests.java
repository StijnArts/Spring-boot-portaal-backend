package com.slager.resource;

import com.slager.dto.*;
import com.slager.service.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class ProductResourceTests {

    private static ProductResource sut;
    private static ProductService mockedProductService = Mockito.mock(ProductService.class);
    @BeforeAll
    public static void setup(){
        sut = new ProductResource(mockedProductService);
    }

    @Test
    public void getProducts(){
        //Arrange
        ProductsDTO productsDTO = new ProductsDTO(List.of());
        ResponseEntity<ProductsDTO> testResponse = ResponseEntity.ok(productsDTO);
        ResponseEntity<ProductsDTO> sutResponse;
        //Act
        sutResponse = sut.getProducts(0);
        //Assert
        assertEquals(testResponse.getStatusCode(),sutResponse.getStatusCode());
        verify(mockedProductService).getProducts(0);
    }

    @Test
    public void getProduct(){
        //Arrange
        ProductDetailDTO productsDTO = new ProductDetailDTO(0,"product",0.0F,0,0);
        ResponseEntity<ProductDetailDTO> testResponse = ResponseEntity.ok(productsDTO);
        ResponseEntity<ProductDetailDTO> sutResponse;
        //Act
        sutResponse = sut.getProduct(0,0);
        //Assert
        assertEquals(testResponse.getStatusCode(),sutResponse.getStatusCode());
        verify(mockedProductService).getProduct(0,0);
    }

    @Test
    void updateProduct() {
        //Arrange
        ProductDetailDTO productsDTO = new ProductDetailDTO(0,"product",0.0F,0,0);
        ResponseEntity<ProductDetailDTO> testResponse = ResponseEntity.ok(productsDTO);
        ResponseEntity<ProductDetailDTO> sutResponse;
        //Act
        sutResponse = sut.updateProduct(0,productsDTO);
        //Assert
        assertEquals(testResponse.getStatusCode(),sutResponse.getStatusCode());
        verify(mockedProductService).updateProduct(0,productsDTO);
    }
}
