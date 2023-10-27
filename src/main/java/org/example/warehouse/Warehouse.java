package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;

public class Warehouse {
    ArrayList<ProductRecord> productList = new ArrayList<>();
    String name = "";

    private Warehouse (){

    }
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
        } if (price == null) price = BigDecimal.ZERO;
        ProductRecord productRecord = new ProductRecord(prodID, name, category, price);
        for (ProductRecord existingProduct: productList){
            if (productRecord.uuid().equals(existingProduct.uuid())){
                throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
            }
        }
        productList.add(productRecord);
        return productRecord;
    }

    public List<ProductRecord> getProducts(){
        return Collections.unmodifiableList(productList);
    }
    public Optional<ProductRecord> getProductById (UUID prodID){
        for (ProductRecord productRecord:productList){
            if (prodID == productRecord.uuid()){
                return Optional.of(productRecord);
            }
        }
        return Optional.empty();
    }
    public void updateProductPrice(UUID prodID, BigDecimal price) {
        for (ProductRecord productRecord:productList) {
            if (prodID != null && prodID.equals(productRecord.uuid())) {
               productRecord.setPrice(price);
               return;
            }
        }
        throw new IllegalArgumentException("Product with that id doesn't exist.");
    }


    public List<ProductRecord> getChangedProducts (){
        var newPriceProduct = new ArrayList<ProductRecord>();
        for (ProductRecord productRecord:productList){
            if (productRecord.getChanged()){
                newPriceProduct.add(productRecord);
            }
        }
        return Collections.unmodifiableList(newPriceProduct);
    }

    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        Map <Category, List<ProductRecord>> mapOfCategory = new HashMap<>();
        for (ProductRecord productRecord:productList){
            if (mapOfCategory.containsKey(productRecord.category())){
                mapOfCategory.get(productRecord.category()).add(productRecord);
            } else {
                var newList = new ArrayList<ProductRecord>();
                newList.add(productRecord);
                mapOfCategory.put(productRecord.category(), newList);
            }
        }
        return mapOfCategory;
    }
    public List <ProductRecord> getProductsBy (Category category){
        var categoryList = new ArrayList<ProductRecord>();
        for (ProductRecord productRecord:productList){
            if (productRecord.category().equals(category)){
            categoryList.add(productRecord);
            }
        }
        return categoryList;
    }
}
