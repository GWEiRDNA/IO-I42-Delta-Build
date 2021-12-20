package pl.put.poznan.transformer.buildings;

public class Room extends Location {
    private double     area;
    private double     capacity;
    private double     light;
    private double   heating;

    public Room(int id, double area, double capacity, double light, double heating) {
        super(id);
        if(area <0 || capacity <0 || light<0 || heating <0)
            throw new IllegalArgumentException("Area, Capacity, Light and Heating can't be negative.");
        this.area       = area;
        this.capacity   = capacity;
        this.light      = light;
        this.heating    = heating;
    }

    public double      getArea()       { return area;     }
    public double      getCapacity()   { return capacity; }
    public double      getLight()      { return light;    }
    public double      getHeating()    { return heating;   }
    public void        setArea(double area)            { this.area = area;}
    public void        setCapacity(double capacity)    { this.capacity = capacity;}
    public void        setLight(double light)          { this.light = light;}
    public void        setHeating(double heating)      { this.heating = heating;}
}
