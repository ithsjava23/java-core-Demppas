package org.example.warehouse;

import java.util.Objects;
import java.util.UUID;

public class ProductRecord {
    private String name;
    private UUID prodID;
    private String category;
    private Double price;

    ProductRecord(UUID prodID, String name, String category, Double price) {
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

    public String category() {
        return category;
    }

    public Double price() {
        return price;
    }
    public void setPrice(Double price){this.price = price;}


}
