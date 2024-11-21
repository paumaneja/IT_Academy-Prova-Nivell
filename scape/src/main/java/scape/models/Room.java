package scape.models;

import scape.enums.DifficultyLevel;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private static int idCounter = 0;
    private final int id;
    private String name;
    private DifficultyLevel difficultyLevel;
    private double totalPrice = 0;
    private List<Item> items = new ArrayList<>();


    public Room(String name, DifficultyLevel difficultyLevel) {
        this.id = ++idCounter;
        this.name = name;
        this.difficultyLevel = difficultyLevel;
    }


    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
