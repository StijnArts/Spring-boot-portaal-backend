package com.slager.resource;

import com.slager.dto.*;
import com.slager.service.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class InventoryResourceTests {
    private static InventoryResource sut;
    private static InventoryService mockedProductService = Mockito.mock(InventoryService.class);
    @BeforeAll
    public static void setup(){
        sut = new InventoryResource(mockedProductService);
    }

    @Test
    public void getInventory(){
        //Arrange
        InventoriesDTO inventoriesDTO = new InventoriesDTO(List.of());
        ResponseEntity<InventoriesDTO> testResponse = ResponseEntity.ok(inventoriesDTO);
        ResponseEntity<InventoriesDTO> sutResponse;
        //Act
        sutResponse = sut.getInventory(0);
        //Assert
        assertEquals(testResponse.getStatusCode(),sutResponse.getStatusCode());
        verify(mockedProductService).getInventory(0);
    }

    @Test
    public void updateInventory(){
        //Arrange
        InventoriesDTO inventoriesDTO = new InventoriesDTO(List.of());
        ResponseEntity<InventoriesDTO> testResponse = ResponseEntity.ok(inventoriesDTO);
        ResponseEntity<InventoriesDTO> sutResponse;
        InventoryDTO inventoryDTO = new InventoryDTO(0,"",0,0);
        //Act
        sutResponse = sut.updateInventory(0, inventoryDTO);
        //Assert
        assertEquals(testResponse.getStatusCode(),sutResponse.getStatusCode());
        verify(mockedProductService).updateInventory(0, inventoryDTO);
    }
}
