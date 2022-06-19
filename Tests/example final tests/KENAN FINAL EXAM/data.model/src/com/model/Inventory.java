package com.model;

public class Inventory {
    private final String INV_NUMBER;
    private int cnt;

    private Category category;
    private String invDescription;
    private double price;

    public Inventory(Category category, double price) {
        this.setCategory(category);
        this.setPrice(price);
        INV_NUMBER = String.valueOf(CanRandomize.RAND.generator.nextInt());
        this.setInvDescription(String.format("Product-%s", INV_NUMBER));

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getInvDescription() {
        return invDescription;
    }

    public void setInvDescription(String invDescription) {
        this.invDescription = invDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%.2f\n%s", INV_NUMBER, category, price, category.suppliers);
    }
}
