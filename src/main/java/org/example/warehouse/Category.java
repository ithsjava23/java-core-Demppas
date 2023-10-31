package org.example.warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {
private String name = "";
private static final Map <String, Category> mapOfCategories = new HashMap<>();
    private Category (){}
    public static Category of(String name) {
        if (name == null)throw new IllegalArgumentException("Category name can't be null");
        Category cat = mapOfCategories.get(name);
            if (cat == null) {
            Category category = new Category();
            category.setName(name.substring(0, 1).toUpperCase() + name.substring(1));
            mapOfCategories.put(name, category);
                return category;
            } else {
                return cat;
            }

    }
    @Override
    public boolean equals (Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Category cat)) return false;
        return cat.getName().equals(this.getName());

    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
