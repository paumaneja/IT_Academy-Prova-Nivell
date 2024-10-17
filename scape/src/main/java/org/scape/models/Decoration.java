package org.scape.models;

import org.scape.enums.MaterialType;

public class Decoration extends InventoryItem{

    private MaterialType material;
    private static final double IVA = 0.21;


    public Decoration(String id, double price, String name, MaterialType material) {
        super(id, price, name);
        this.material = material;
    }

    @Override
    public double calculatePriceWithTax() {
        return this.price + (this.price * IVA);
    }

    @Override
    public String toString() {
        return "Decoration{" +
                "material=" + material +
                ", id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
