package com.slager.service;

import com.slager.datasource.dao.*;
import com.slager.dto.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class InventoryServiceTests {
    private static InventoryService sut;
    private static InventoryDAO mockedInventoryDAO = Mockito.mock(InventoryDAO.class);
    @BeforeAll
    public static void setup(){
        sut = new InventoryService(mockedInventoryDAO);
    }

    @Test
    void getInventory() {
        //Arrange
        InventoriesDTO inventoryDTO = new InventoriesDTO(List.of());
        Mockito.doReturn(inventoryDTO).when(mockedInventoryDAO).getInventory(0);
        //Act
        InventoriesDTO actual = sut.getInventory(0);
        //Assert
        verify(mockedInventoryDAO).getInventory(0);
        assertEquals(inventoryDTO,actual);
    }

    @Test
    void updateInventory() {
        //Arrange
        InventoryDTO inventoryDTO = new InventoryDTO(0,"product",0,0);
        InventoriesDTO inventoriesDTO = new InventoriesDTO(List.of());
        Mockito.doReturn(inventoriesDTO).when(mockedInventoryDAO).getInventory(0);
        //Act
        sut.updateInventory(0,inventoryDTO);
        InventoriesDTO actual = sut.getInventory(0);
        //Assert
        verify(mockedInventoryDAO).updateInventory(0,inventoryDTO);
        assertEquals(inventoriesDTO,actual);
    }
}
