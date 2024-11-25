package scape.view;

import scape.enums.DifficultyLevel;
import scape.enums.MaterialType;
import scape.enums.ThemeType;
import scape.exceptions.RoomDuplicatedException;
import scape.exceptions.RoomNotFoundException;
import scape.management.InventoryManager;
import scape.models.Clue;
import scape.models.Decoration;
import scape.utils.InputUtils;

import java.util.Scanner;

public class Menu {

    private static final InventoryManager inventoryManager = new InventoryManager();

    public static void startMenu(){

        boolean exit = false;
        do {
                switch (menu()) {
                    case 1:
                        createRoom();
                        break;
                    case 2:
                        addClueToRoom();
                        break;
                    case 3:
                        addDecorationToRoom();
                        break;
                    case 4:
                        inventoryManager.showInventory();
                        break;
                    case 5:
                        removeItemFromRoom();
                        break;
                    case 0:
                        System.out.println("Finishing the program...");
                        exit = true;
                        break;
                }
        } while (!exit);
    }

    public static byte menu() {
        Scanner entrada = new Scanner(System.in);
        byte option;
        final byte MINIMO = 0;
        final byte MAXIMO = 5;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create room");
            System.out.println("2. Add clue to room");
            System.out.println("3. Add decoration to room");
            System.out.println("4. Show inventory");
            System.out.println("5. Delete elements from inventory");

            option = entrada.nextByte();
            if (option < MINIMO || option > MAXIMO) {
                System.out.println("Choose valid option");
            }
        } while (option < MINIMO || option > MAXIMO);
        return option;
    }

    public static void createRoom() {
        String name = InputUtils.readString("Enter room name: ");
        DifficultyLevel level = InputUtils.readEnum("Enter room difficulty (EASY, MEDIUM, HARD): ", DifficultyLevel.class);
        try {
            inventoryManager.createRoom(name, level);
        } catch (RoomDuplicatedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addClueToRoom() {
        String roomName = InputUtils.readString("Enter the room name to add a clue: ");
        String clueName = InputUtils.readString("Enter clue name: ");
        ThemeType theme = InputUtils.readEnum("Enter clue theme (HISTORY, SCIENCE, MYSTERY): ", ThemeType.class);
        int timeToSolve = InputUtils.readInt("Enter time to solve (in minutes): ");
        double price = InputUtils.readDouble("Enter clue price: ");
        Clue clue = new Clue(clueName, theme, timeToSolve, price);
        try {
            inventoryManager.addClueToRoom(roomName, clue);
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addDecorationToRoom() {
        String roomName = InputUtils.readString("Enter the room name to add a decoration: ");
        String decorationName = InputUtils.readString("Enter decoration name: ");
        MaterialType material = InputUtils.readEnum("Enter material type (WOOD, METAL, GLASS): ", MaterialType.class);
        double price = InputUtils.readDouble("Enter decoration price: ");
        Decoration decoration = new Decoration(decorationName, price, material);
        try {
            inventoryManager.addDecorationToRoom(roomName, decoration);
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removeItemFromRoom() {
        String roomName = InputUtils.readString("Enter the room name to remove an item: ");
        String itemName = InputUtils.readString("Enter the item name to remove: ");
        try {
            inventoryManager.removeItemFromRoom(roomName, itemName);
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}