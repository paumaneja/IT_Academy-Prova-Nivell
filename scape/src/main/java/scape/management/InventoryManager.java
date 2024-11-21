package scape.management;

import scape.enums.DifficultyLevel;
import scape.exceptions.RoomDuplicatedException;
import scape.models.Room;
import scape.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryManager {

    private final List<Room> rooms;

    public InventoryManager() {
        this.rooms = new ArrayList<>();
    }


    public void createRoom(String name, DifficultyLevel level) throws RoomDuplicatedException {

        if (findRoomByName(name).isPresent()){
            throw new RoomDuplicatedException("A room with name " + name + "already exists.");
        }

        Room newRoom = new Room(name, level);
        rooms.add(newRoom);
        System.out.println("Room created.");

    }

    public Optional<Room> findRoomByName(String name){
        return rooms.stream().filter(room -> room.getName().equalsIgnoreCase(name)).findFirst();
    }

    public void addClueToRoom() {

    }
}
