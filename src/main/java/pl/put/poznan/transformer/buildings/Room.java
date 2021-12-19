package pl.put.poznan.transformer.buildings;

public class Room extends Location {
    private int     area;
    private int     capacity;
    private int     light;
    private float   heating;


    // @TODO: zabezpieczyc przed ujemnymi wartosciami
    public Room(int id, int area, int capacity, int light, float eating) {
        super(id);
        this.area       = area;
        this.capacity   = capacity;
        this.light      = light;
        this.heating     = eating;
    }

    public int getArea()     { return area;     }
    public int getCapacity() { return capacity; }
    public int getLight()    { return light;    }
    public float getHeating() { return heating;   }
}
