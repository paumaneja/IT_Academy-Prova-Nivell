package scape.models;

import scape.enums.ThemeType;

public class Clue extends Item {

    private ThemeType theme;
    private int timeToSolve;
    private double price;

    public Clue(String name, ThemeType theme, int timeToSolve, double price) {
        super(++idCounter, name);
        this.theme = theme;
        this.timeToSolve = timeToSolve;
        this.price = price;
    }
}
