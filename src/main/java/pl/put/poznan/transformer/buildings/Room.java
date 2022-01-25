package pl.put.poznan.transformer.buildings;
import pl.put.poznan.transformer.visitors.Visitor;

/**
 *  Room representation. Stored in Storeys. {@link Room}
 *  @see Storey
 *  @see Location
 *  @see LocINT
 */
public class Room extends Location {
    private double     area;
    private double     capacity;
    private double     light;
    private double     heating;

    // check the sign
    private double     check(double var) {
        if (var < 0) {
            throw new IllegalArgumentException("Room values can't be negative.");
        } else {
            return var;
        }
    }
    /**
     *
     * @param id        id of the Room.
     * @param area      area of the Room in square meters. Should be grater than 0
     * @param capacity  cubature of the Room in cubic meters. Should be grater than 0
     * @param light     ligth power of the Room. Should be grater than 0
     * @param heating   heating power consumption of the Room. Should be grater than 0
     */
    public Room(int id, double area, double capacity, double light, double heating) {
        super(id);
        this.area       = check(area);
        this.capacity   = check(capacity);
        this.light      = check(light);
        this.heating    = check(heating);
    }

    public double      getArea()       { return area;     }
    public double      getCapacity()   { return capacity; }
    public double      getLight()      { return light;    }
    public double      getHeating()    { return heating;   }
    public void        setArea(double area)            { this.area      = check(area);}
    public void        setCapacity(double capacity)    { this.capacity  = check(capacity);}
    public void        setLight(double light)          { this.light     = check(light);}
    public void        setHeating(double heating)      { this.heating   = check(heating);}

    @Override
    public void accept(Visitor visitor) {visitor.visit(this);}
}
