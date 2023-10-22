package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;

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
        if (obj != null && obj.equals(getName())) return true;
            else return false;
    }

    public boolean isEmpty (){
        return productList.isEmpty();
    }

    public ProductRecord addProduct(UUID prodID, String name, Category category, BigDecimal price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name can't be null or empty.");
        } if (category == null){
            throw new IllegalArgumentException("Category can't be null.");
        } if (prodID == null){
            prodID = UUID.randomUUID();
        } if (price == null) price = BigDecimal.valueOf(0,2);
        ProductRecord productRecord = new ProductRecord(prodID, name, category, price);
        productList.add(productRecord);
        return productRecord;
    }

    public List<ProductRecord> getProducts(){
        return Collections.unmodifiableList(productList);
    }
    public List<ProductRecord> getProductById (UUID prodID){
        var foundProduct = new ArrayList<ProductRecord>();
        for (ProductRecord productRecord:productList){
            if (prodID == productRecord.uuid()){
                foundProduct.add(productRecord);
            }
        }
        return Collections.unmodifiableList(foundProduct);
    }
    public void updateProductPrice(UUID prodID, BigDecimal price) {
        for (ProductRecord productRecord:productList) {
            if (prodID != null && prodID.equals(productRecord.uuid())) {
               productRecord.setPrice(price);
            }
        }
    }

    public List<ArrayList<ProductRecord>> getChangedProducts (){
        var newPriceProduct = new ArrayList<ProductRecord>();
        for (ProductRecord productRecord:productList){
            if (productRecord.getChanged()){
                newPriceProduct.add(productRecord);
            }
        }
        return List.of(newPriceProduct);
    }

    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        Map <Category, List<ProductRecord>> mapOfCategory = new HashMap<>();
        for (ProductRecord productRecord:productList){
            if (productRecord.category().equals(Category)){
                mapOfCategory.get(Category).add(productRecord);
            }
        }


        //group products by category
    }
    public List <ProductRecord> getProductsBy (Category category){
        Object obj = category;
        for (ProductRecord productRecord:productList){
            if (getProductsGroupedByCategories().containsKey(category)
        }
        //find products belonging to category
    }
}
