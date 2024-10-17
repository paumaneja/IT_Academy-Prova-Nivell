package org.scape.models;

import org.scape.Exceptions.RoomNotFoundException;
import org.scape.enums.DifficultyLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {

    private List<Room> rooms = new ArrayList<>();


    private Room findRoomById(String id){

        for (Room room : rooms) {
            if (room.getId().equalsIgnoreCase(id)) {
                return room;
            }
        }
        return null;
    }

    public void createNewRoom(String id, String name, DifficultyLevel difficultyLevel) throws RoomNotFoundException {

        if(findRoomById(id) != null){
            throw new RoomNotFoundException("Room with id " + id + " already exists.");
        }
        Room room = new Room(id, name, difficultyLevel);
        rooms.add(room);
    }

    public void addClueToRoom(String id, Clue clue) throws RoomNotFoundException {
       Room room = findRoomById(id);
        if(room != null){
            room.addClue(clue);
        } else {
            throw new RoomNotFoundException("Room with id " + id + " not exists.");
        }
    }

    public void addDecorationToRoom(String id, Decoration decoration) throws RoomNotFoundException{
        Room room = findRoomById(id);
        if(room != null){
            room.addDecoration(decoration);
        } else {
            throw new RoomNotFoundException("Room with id " + id + " not exists.");
        }
    }

    public void showInventory(){
        for (Room room : rooms) {
            System.out.println(rooms);
        }
    }


    /*
    public void deleteInventoryItemToRoom(String id) throws RoomNotFoundException {
        Scanner input = new Scanner(System.in);
        Room room = findRoomById(id);
        if (room != null){
            System.out.println("Delete Clue or Decoration? 'CLUE / DECO");
            String type = input.nextLine();
        } else {
            throw new RoomNotFoundException("Room with id " + id + " not exists.");
        }

        switch (type){
            case "CLUE":
                System.out.println("Clue id: ");
                String idClue = input.nextLine();
                deleteClueToRoom(room, idClue);
                break;
            case "DECO":
                System.out.println("Deco id: ");
                String idDeco = input.nextLine();
                deleteDecorationToRoom(room, decoration);
                break;
        }
    }

    public void deleteClueToRoom(Room room, String idClue){

        room.getClues().remove(idClue);

    }

    public void deleteDecorationToRoom(Room room, String idDecoration){

    }
     */
}
