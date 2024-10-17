package org.scape.models;

import org.scape.enums.DifficultyLevel;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String id;
    private String name;
    private DifficultyLevel difficultyLevel;
    private double totalPrice;
    private List<Clue> clues = new ArrayList<>();
    private List<Decoration> decorations = new ArrayList<>();


    public Room(String id, String name, DifficultyLevel difficultyLevel) {
        this.id = id;
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.totalPrice = 0.0;
    }


    public void addClue(Clue clue){
        clues.add(clue);
        totalPrice = clue.calculatePriceWithTax();
    }

    public void addDecoration(Decoration decoration){
        decorations.add(decoration);
        totalPrice = decoration.calculatePriceWithTax();
    }

    public String getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Clue> getClues() {
        return clues;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                ", totalPrice=" + totalPrice +
                ", clues=" + clues +
                ", decorations=" + decorations +
                '}';
    }
}
