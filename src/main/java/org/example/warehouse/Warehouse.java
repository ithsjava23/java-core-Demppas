package org.example.warehouse;

import java.util.ArrayList;
import java.util.Objects;

public class Warehouse {
    ArrayList<ProductRecord> productList = new ArrayList<>();

    public static Warehouse getInstance() {
        Warehouse warehouse = new Warehouse();
        return warehouse;
    }

    public void addProduct (ProductRecord productRecord){
        productList.add(productRecord);
    }


}


