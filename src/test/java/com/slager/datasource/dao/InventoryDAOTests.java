package com.slager.datasource.dao;

import com.slager.datasource.queryhelper.*;
import com.slager.dto.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class InventoryDAOTests {

    @Test
    public void getInventory(){
        //Arrange
        QueryHelper mockedQueryHelper = Mockito.mock(QueryHelper.class);
        InventoryDAO sut = new InventoryDAO(mockedQueryHelper);
        List emptyList = List.of();
        InventoriesDTO inventoriesDTO = new InventoriesDTO(emptyList);
        ArrayList<Object> params = new ArrayList<>();
        Mockito.doReturn(emptyList).when(mockedQueryHelper).executeQueryWithResultAndTransaction("",params,(resultSet,rownum)->{return null;});

        //Act & Assert
        assertEquals(inventoriesDTO.getInventoryDTOS(),sut.getInventory(0).getInventoryDTOS());
    }

    @Test
    public void updateInventory(){
        //Arrange
        QueryHelper mockedQueryHelper = Mockito.mock(QueryHelper.class);
        InventoryDAO sut = new InventoryDAO(mockedQueryHelper);
        InventoryDTO inventoryDTO = new InventoryDTO(0,"",0,0);
        //Act
        sut.updateInventory(0,inventoryDTO);
        //Assert
        verify(mockedQueryHelper).executeQueryWithoutResultWithTransaction(ArgumentMatchers.anyString(),ArgumentMatchers.isA(ArrayList.class));
    }
}
