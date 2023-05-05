package com.slager.service;

import com.slager.datasource.dao.*;
import com.slager.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class InventoryService {

    private InventoryDAO inventoryDAO;

    @Autowired
    public InventoryService(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    public InventoriesDTO getInventory(int companyID) {
        return inventoryDAO.getInventory(companyID);
    }

    public InventoriesDTO updateInventory(int companyID, InventoryDTO productInventoryDTO) {
        inventoryDAO.updateInventory(companyID,productInventoryDTO);
        return inventoryDAO.getInventory(companyID);
    }
}
