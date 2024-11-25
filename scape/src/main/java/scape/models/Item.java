package scape.models;

import scape.enums.VAT;

public abstract class Item {
    protected static int idCounter = 0;
    protected final int id;
    protected String name;

    public Item(int id, String name) {
        this.id = ++idCounter;
        this.name = name;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Item.idCounter = idCounter;
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
