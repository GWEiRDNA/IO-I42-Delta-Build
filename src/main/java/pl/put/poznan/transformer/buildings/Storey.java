package pl.put.poznan.transformer.buildings;

import java.util.Vector;

public class Storey extends Location {
    private Vector<Room> rooms = new Vector<Room>();
    public void add(Room room) {
        rooms.add(room);
    }
    public void remove(int id) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).id == id) {
                rooms.removeElementAt(i);
            }
        }
    }
}
