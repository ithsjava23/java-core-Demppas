package org.example.warehouse;

import java.util.Objects;

public class ProductRecord {
   private String Name;
    private int prodID;
    private String Category;
    private Double Price;

    ProductRecord(String Name, int prodID, String Category, Double Price) {
        this.Name = Name;
        this.prodID = prodID;
        this.Category = Category;
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    public int getprodID() {
        return prodID;
    }

    public String getCategory() {
        return Category;
    }

    public Double getPrice() {
        return Price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ProductRecord) obj;
        return Objects.equals(this.Name, that.Name) &&
                this.prodID == that.prodID &&
                Objects.equals(this.Category, that.Category) &&
                Objects.equals(this.Price, that.Price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, prodID, Category, Price);
    }

    @Override
    public String toString() {
        return "ProductRecord[" +
                "Name=" + Name + ", " +
                "prodID=" + prodID + ", " +
                "Category=" + Category + ", " +
                "Price=" + Price + ']';
    }

}
