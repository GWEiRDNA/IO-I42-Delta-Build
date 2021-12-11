package pl.put.poznan.transformer.buildings;

public class Room extends Location {
    private int     area;
    private int     capacity;
    private int     light;
    private float   eating;

    Room(int id, int area, int capacity, int light, float eating) {
        super.id        = id;
        this.area       = area;
        this.capacity   = capacity;
        this.light      = light;
        this.eating     = eating;
    }
}
