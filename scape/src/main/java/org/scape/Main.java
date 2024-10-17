package org.scape;

import org.scape.Exceptions.RoomNotFoundException;
import org.scape.enums.DifficultyLevel;
import org.scape.enums.MaterialType;
import org.scape.enums.ThemeType;
import org.scape.models.Clue;
import org.scape.models.Decoration;
import org.scape.models.InventoryManager;

import java.util.Scanner;

import static org.scape.enums.MaterialType.WOOD;
import static org.scape.enums.ThemeType.HORROR;

public class Main {
    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();
        boolean out = false;
        Scanner input = new Scanner(System.in);

        do{
            switch(menu()){
                case 1:
                    System.out.println("Room id: ");
                    String id = input.nextLine();
                    System.out.println("Room name: ");
                    String name = input.nextLine();
                    System.out.println("Difficulty Level: 'EASY, MEDIUM, HARD'");
                    DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(input.nextLine());
                    try {
                        manager.createNewRoom(id, name, difficultyLevel);
                    } catch (RoomNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println("Room id: ");
                    id = input.nextLine();
                    //Creo una Clue (podria pedirlo al usuario o hacer un metodo que lo cree)
                    String idClue = "pista1";
                    double price = 2.3;
                    String nameClue = "Pista del terror.";
                    ThemeType theme = HORROR;
                    int timeToSlove = 5;
                    Clue clue = new Clue(idClue, price, nameClue, theme, timeToSlove);
                    try {
                        manager.addClueToRoom(id, clue);
                    } catch (RoomNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println("Room id: ");
                    id = input.nextLine();
                    //Creo una Decoration (podria pedirlo al usuario o hacer un metodo que lo cree)
                    String idDecoration = "deco1";
                    price = 5.3;
                    String nameDecoration = "Jarrón.";
                    MaterialType material = WOOD;
                    Decoration decoration = new Decoration(idDecoration, price, nameDecoration, material);
                    try {
                        manager.addDecorationToRoom(id, decoration);
                    } catch (RoomNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    manager.showInventory();
                    break;
                case 5: //metode5();
                    break;
                case 0: System.out.println("Thank you. Bye");
                    out = true;
                    break;
            }
        }while(!out);
    }

    public static byte menu(){
        Scanner input = new Scanner(System.in);
        byte option;
        final byte MIN = 0;
        final byte MAX = 5;

        do{
            System.out.println("\nPRINCIPAL MENU");
            System.out.println("1. Create new room.");
            System.out.println("2. Add clue to room.");
            System.out.println("3. Add decoration item.");
            System.out.println("4. Show inventory.");
            System.out.println("5. Delete inventory item.");
            System.out.println("0. Logout.\n");
            option = input.nextByte();
            if(option < MIN || option > MAX){
                System.out.println("Choose a valid option.");
            }
        }while(option < MIN || option > MAX);
        return option;
    }
}