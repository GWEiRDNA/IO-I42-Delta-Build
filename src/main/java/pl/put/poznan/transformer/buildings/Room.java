package pl.put.poznan.transformer.buildings;

public class Room extends Location {
    private int     area;
    private int     capacity;
    private int     light;
    private float   heating;

    public Room(int id, int area, int capacity, int light, float heating) {
        super(id);
        if(area <0 || capacity <0 || light<0 || heating <0)
            throw new IllegalArgumentException("Area, Capacity, Light and Heating can't be negative.");
        this.area       = area;
        this.capacity   = capacity;
        this.light      = light;
        this.heating    = heating;
    }

    public int      getArea()       { return area;     }
    public int      getCapacity()   { return capacity; }
    public int      getLight()      { return light;    }
    public float    getHeating()    { return heating;   }
}
