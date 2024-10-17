package org.scape.models;

public abstract class InventoryItem {
    protected String id;
    protected double price;
    protected String name;

    public InventoryItem(String id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public abstract double calculatePriceWithTax();

    @Override
    public String toString() {
        return "InventoryItem{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
