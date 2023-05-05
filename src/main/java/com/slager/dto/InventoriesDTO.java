package com.slager.dto;

import java.util.*;

public class InventoriesDTO {
    List<InventoryDTO> inventoryDTOS;



    public InventoriesDTO(List<InventoryDTO> inventoryDTOS) {
        this.inventoryDTOS = inventoryDTOS;
    }

    public List<InventoryDTO> getInventoryDTOS() {
        return inventoryDTOS;
    }

    public void setInventoryDTOS(List<InventoryDTO> inventoryDTOS) {
        this.inventoryDTOS = inventoryDTOS;
    }
}
