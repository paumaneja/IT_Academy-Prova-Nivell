package scape.models;

import scape.enums.MaterialType;

public class Decoration extends Item {

    private MaterialType material;
    private double price;


    public Decoration(String name, double price, MaterialType material) {
        super(++idCounter, name);
        this.material = material;
        this.price = price;
    }

    public MaterialType getMaterial() {
        return material;
    }

    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Decoration{" +
                "material=" + material +
                ", price=" + price +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
