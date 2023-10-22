package org.example.warehouse;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class ProductRecord {
    private String name;
    private UUID prodID;
    private Category category;
    private BigDecimal price;
    private boolean changed = false;
    ProductRecord(UUID prodID, String name, Category category, BigDecimal price) {
        this.name = name;
        this.prodID = prodID;
        this.category = category;
        this.price = price;
    }

    public String name() {
        return name;
    }

    public UUID uuid() {
        return prodID;
    }
    public void setUUID(UUID prodID){this.prodID = prodID;}

    public Category category() {
        return category;
    }

    public BigDecimal price() {
        return price;
    }
    public void setPrice(BigDecimal price){
        if (!price.equals(this.price)){
        this.price = price;
        this.changed = true;}
    }
    public boolean getChanged() {return changed;}

}
