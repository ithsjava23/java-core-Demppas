package org.example.warehouse;

import java.util.Objects;

public class ProductRecord {
   private String Name;
    private String prodID;
    private String Category;
    public Double Price;

    ProductRecord(String Name, int prodID, String Category, Double Price) {
        this.Name = Name;
        this.prodID = prodID;
        this.Category = Category;
        this.Price = Price;
    }

    public static String getName() {
        return Name;
    }

    public static String getProdID() {
        return prodID;
    }

    public static String getCategory() {
        return Category;
    }

    public static Double getPrice() {
        return Price;
    }



}
