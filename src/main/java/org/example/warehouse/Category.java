package org.example.warehouse;

public class Category {
String name = "";

    public static Category of(String name) {
        Category category = new Category();
        category.setName(name.toUpperCase());
        return category;
    }
    @Override
    public boolean equals (Object obj) {
        if (obj != null && obj.equals(getName())) return true;
        else return false;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
