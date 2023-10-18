package org.example.warehouse;

import java.util.ArrayList;
import java.util.Objects;

public class Warehouse {
    ArrayList<ProductRecord> productList = new ArrayList<>();

    public static Warehouse getInstance() {
        Warehouse warehouse = new Warehouse();
        return warehouse;

    }

    public void equals(Warehouse warehouse) {
            if (new Warehouse.equals(warehouse)) {
                warehouse = new Warehouse;
            }
    }

    public void addProduct(ProductRecord productRecord) {
        productList.add(productRecord);
    }

    public void tryName (ProductRecord productrecord) {
        if (ProductRecord.getName().isEmpty() || ProductRecord.getName() = "") {
            throw new IllegalArgumentException("Product name can't be null or empty.");
        }
    }
    public void tryCategory (ProductRecord productrecord){
        if (ProductRecord.getCategory().isEmpty()) {
            throw new IllegalArgumentException("Category can't be null.");
        }
    }

    public void checkID (ProductRecord productRecord){
        if (ProductRecord.getProdID().equals("") || ProductRecord.getProdID().isEmpty()){
            //assign UUID to ProdID
        }
    }

    public void tryPrice (ProductRecord productrecord){
        if (ProductRecord.getPrice().isNaN())
            ProductRecord.Price = 0;
    }

}
