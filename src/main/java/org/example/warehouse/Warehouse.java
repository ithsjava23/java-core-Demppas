package org.example.warehouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Warehouse {
    ArrayList<ProductRecord> productList = new ArrayList<>();
    String name = "";
    public static Warehouse getInstance() {
        Warehouse warehouse = new Warehouse();
        return warehouse;
    }
    public static Warehouse getInstance(String name) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(name);
        return warehouse;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public boolean equals (Object obj){
        // is obj null? is obj1 instance of warehouse? if not false.
        return false;
    }

    public void addProduct(UUID prodID, String name, String category, Double price) {
        ProductRecord productRecord = new ProductRecord(prodID, name, category, price);
        productList.add(productRecord);
    }

    public void tryName (ProductRecord productRecord) {
        if (productRecord.name().isEmpty() || productRecord.name() == "") {
            throw new IllegalArgumentException("Product name can't be null or empty.");
        }
    }
    public void tryCategory (ProductRecord productRecord){
        if (productRecord.category().isEmpty()) {
            throw new IllegalArgumentException("Category can't be null.");
        }
    }

    public void checkID (ProductRecord productRecord){
        if (productRecord.uuid().equals("") || productRecord.uuid().isEmpty()){
            //assign UUID to ProdID
        }
    }

    public void tryPrice (ProductRecord productRecord){
        if (productRecord.price().isNaN()) {
            productRecord.setPrice(Double.valueOf(0));
        }
    }

    public List<ProductRecord> getProducts(){
        return Collections.unmodifiableList(productList);
    }
    public ProductRecord getProductById (UUID prodID){
        for (ProductRecord productRecord:productList){
            if (prodID == productRecord.uuid()){
                return productRecord;
            }
        }
        return null;
    }

    public void updateProductPrice(UUID uuid, Double price) {
        //change a product price and save it
    }
}
