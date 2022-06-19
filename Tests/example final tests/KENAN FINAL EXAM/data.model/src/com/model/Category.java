package com.model;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    A(0, new ArrayList<String>()),
    B(1, new ArrayList<String>()),
    C(2, new ArrayList<String>()),
    D(3, new ArrayList<String>());

    int reorderQty;
    List<String> suppliers;

    Category(int reorderQty, List<String> suppliers) {
        this.reorderQty = reorderQty;
        this.suppliers = suppliers;
    }

    public int getReorderQty() {
        return reorderQty;
    }

    public void setReorderQty(int reorderQty) {
        this.reorderQty = reorderQty;
    }

    public List<String> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<String> suppliers) {
        this.suppliers = suppliers;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", suppliers=" + suppliers +
                '}';
    }
}
