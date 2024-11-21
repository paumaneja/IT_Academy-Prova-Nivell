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

}
