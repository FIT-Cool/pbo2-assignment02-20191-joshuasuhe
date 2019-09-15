package com.joshua.entity;

public class Category {
    public String catName;
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString(){
        return getCatName();
    }
}
