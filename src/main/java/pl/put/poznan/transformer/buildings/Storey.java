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
    public Storey(int id) {
        super.id = id;
    }
    public int getArea() {
        int total = 0;
        for (Room room : rooms) {
            total += room.getArea();
        }
        return total;
    }
    public int getCapacity() {
        int total = 0;
        for (Room room : rooms) {
            total += room.getCapacity();
        }
        return total;
    }
    public int getLight() {
        int total = 0;
        for (Room room : rooms) {
            total += room.getLight();
        }
        return total;
    }
    public float getEating() {
        float total = 0;
        for (Room room : rooms) {
            total += room.getEating();
        }
        return total;
    }
}
