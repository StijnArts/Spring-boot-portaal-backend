package com.slager.datasource.dao;

import com.slager.datasource.queryhelper.*;
import com.slager.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class InventoryDAO extends DataAccessObject {
    @Autowired
    public InventoryDAO(QueryHelper queryHelper) {
        super(queryHelper);
    }

    public InventoriesDTO getInventory(int companyId) {
        ArrayList<Object> parameters = new ArrayList();
        parameters.add(companyId);
        String query = "SELECT P.PRODUCTID, P.[NAME], I.QUANTITY, I.QUANTITY_MAX\n" +
                "                FROM COMPANYPRODUCTS CP\n" +
                "                JOIN PRODUCT P on P.PRODUCTID = CP.PRODUCTID\n" +
                "                JOIN INVENTORY I on I.COMPANYID = CP.COMPANYID AND I.PRODUCTID = CP.PRODUCTID\n" +
                "                WHERE CP.COMPANYID = ?\n" +
                "                ORDER BY P.[NAME]";
        return new InventoriesDTO(queryHelper.executeQueryWithResultAndTransaction(query, parameters, getInventoryMapper()));
    }

    private RowMapper<InventoryDTO> getInventoryMapper() {
        return (resultSet,rownum)->{
            return new InventoryDTO(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4));
        };
    }

    public void updateInventory(int companyID, InventoryDTO productInventoryDTO){
        ArrayList<Object> parameters = new ArrayList();
        parameters.add(productInventoryDTO.getQuantity());
        parameters.add(productInventoryDTO.getMaxQuantity());
        parameters.add(productInventoryDTO.getProductId());
        parameters.add(companyID);
        String query = "UPDATE INVENTORY\n" +
                "SET QUANTITY = ?, QUANTITY_MAX = ?\n" +
                "WHERE PRODUCTID = ? AND COMPANYID = ?\n";
        queryHelper.executeQueryWithoutResultWithTransaction(query, parameters);
    }
}
