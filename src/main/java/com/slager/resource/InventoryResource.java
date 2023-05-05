package com.slager.resource;

import com.slager.dto.*;
import com.slager.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class InventoryResource {

    private InventoryService inventoryService;

    @Autowired
    public InventoryResource(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{companyId}/inventory")
    @ResponseBody
    public ResponseEntity<InventoriesDTO> getInventory(@PathVariable("companyId") int companyID){
        return ResponseEntity.ok(inventoryService.getInventory(companyID));
    }
//
//
    @PutMapping ("/{companyId}/inventory")
    @ResponseBody
    public ResponseEntity<InventoriesDTO> updateInventory(@PathVariable("companyId") int companyId, @RequestBody InventoryDTO productInventoryDTO){
        return ResponseEntity.ok(inventoryService.updateInventory(companyId, productInventoryDTO));
    }
}