package org.scape.models;

import org.scape.enums.ThemeType;

public class Clue extends InventoryItem{

    private ThemeType theme;
    private int timeToSolve;
    private static final double IVA = 0.10;

    public Clue(String id, double price, String name, ThemeType theme, int timeToSolve) {
        super(id, price, name);
        this.theme = theme;
        this.timeToSolve = timeToSolve;
    }

    @Override
    public double calculatePriceWithTax() {
        return this.price + (this.price * IVA);
    }

    @Override
    public String toString() {
        return "Clue{" +
                "theme=" + theme +
                ", timeToSolve=" + timeToSolve +
                ", id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
