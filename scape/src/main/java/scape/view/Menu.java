package scape.view;

import scape.enums.DifficultyLevel;
import scape.exceptions.RoomDuplicatedException;
import scape.management.InventoryManager;
import scape.models.Room;
import scape.utils.InputUtils;

import java.util.Optional;
import java.util.Scanner;

public class Menu {

    public static void startMenu(){

        InventoryManager inventoryManager = new InventoryManager();

        boolean exit = false;
        do {
                switch (menu()) {
                    case 1:
                        String name = InputUtils.readString("Name of the room: ");
                        DifficultyLevel level = InputUtils.readEnum("Difficulty level: ", DifficultyLevel.class);
                        try {
                            inventoryManager.createRoom(name, level);
                        } catch (RoomDuplicatedException e){
                            System.out.printf(e.getMessage());
                        }
                        break;
                    case 2:
                        name = InputUtils.readString("Name of the room: ");


                        //controller.createClue();
                        break;
                    case 3:
                        //controller.addClueToRoom();
                        break;
                    case 4:
                        //controller.createDecoration();
                        break;
                    case 5:
                        //controller.addDecoToRoom();
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
}