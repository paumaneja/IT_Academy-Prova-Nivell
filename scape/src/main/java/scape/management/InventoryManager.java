package scape.management;

import scape.enums.DifficultyLevel;
import scape.enums.VAT;
import scape.exceptions.RoomDuplicatedException;
import scape.exceptions.RoomNotFoundException;
import scape.models.Clue;
import scape.models.Decoration;
import scape.models.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryManager {

    private final List<Room> rooms;

    public InventoryManager() {
        this.rooms = new ArrayList<>();
    }


    public void createRoom(String roomName, DifficultyLevel level) throws RoomDuplicatedException {
        if (findRoomByName(roomName).isPresent()){
            throw new RoomDuplicatedException("A room with name " + roomName + "already exists.");
        }
        Room newRoom = new Room(roomName, level);
        rooms.add(newRoom);
        System.out.println("Room created.");
    }

    public Optional<Room> findRoomByName(String roomName){
        return rooms.stream().filter(room -> room.getName().equalsIgnoreCase(roomName)).findFirst();
    }

    public void addClueToRoom(String roomName, Clue clue) throws RoomNotFoundException {
        Room room = findRoomByName(roomName).orElseThrow(() ->
                new RoomNotFoundException("Room '" + roomName + "' not found."));
        room.getItems().add(clue);
        double cluePriceWithVAT = clue.getPrice() + (clue.getPrice() * VAT.CLUE.getTax());
        room.setTotalPrice(room.getTotalPrice() + cluePriceWithVAT);
        System.out.println("Clue '" + clue.getName() + "' added to room '" + roomName + "'.");
    }

    public void addDecorationToRoom(String roomName, Decoration decoration) throws RoomNotFoundException {
        Room room = findRoomByName(roomName).orElseThrow(() ->
                new RoomNotFoundException("Room '" + roomName + "' not found."));
        room.getItems().add(decoration);
        double decorationPriceWithVAT = decoration.getPrice() + (decoration.getPrice() * VAT.DECORATION.getTax());
        room.setTotalPrice(room.getTotalPrice() + decorationPriceWithVAT);
        System.out.println("Decoration '" + decoration.getName() + "' added to room '" + roomName + "'.");
    }

    public void showInventory() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms in inventory.");
            return;
        }
        rooms.forEach(room -> {
            System.out.println("Room ID: " + room.getId());
            System.out.println("Name: " + room.getName());
            System.out.println("Difficulty: " + room.getDifficultyLevel());
            System.out.println("Total Price: €" + room.getTotalPrice());
            System.out.println("Items: ");
            room.getItems().forEach(item -> System.out.println("- " + item.getName()));
        });
    }

    public void removeItemFromRoom(String roomName, String itemName) throws RoomNotFoundException {
        Room room = findRoomByName(roomName).orElseThrow(() ->
                new RoomNotFoundException("Room '" + roomName + "' not found."));
        boolean removed = room.getItems().removeIf(item -> {
            if (item.getName().equalsIgnoreCase(itemName)) {
                double itemPriceWithVAT;
                if (item instanceof Clue) {
                    itemPriceWithVAT = ((Clue) item).getPrice() + ((Clue) item).getPrice() * VAT.CLUE.getTax();
                } else if (item instanceof Decoration) {
                    itemPriceWithVAT = ((Decoration) item).getPrice() + ((Decoration)item).getPrice() * VAT.DECORATION.getTax();
                } else {
                    return false;
                }
                room.setTotalPrice(room.getTotalPrice() - itemPriceWithVAT);
                return true;
            }
            return false;
        });
        if (removed) {
            System.out.println("Item '" + itemName + "' removed from room '" + roomName + "'.");
        } else {
            System.out.println("Item '" + itemName + "' not found in room '" + roomName + "'.");
        }
    }
}
