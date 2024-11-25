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

    public ThemeType getTheme() {
        return theme;
    }

    public void setTheme(ThemeType theme) {
        this.theme = theme;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTimeToSolve() {
        return timeToSolve;
    }

    public void setTimeToSolve(int timeToSolve) {
        this.timeToSolve = timeToSolve;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "theme=" + theme +
                ", timeToSolve=" + timeToSolve +
                ", price=" + price +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
