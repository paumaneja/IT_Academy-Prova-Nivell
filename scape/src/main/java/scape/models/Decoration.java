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
}
