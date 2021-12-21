package pl.put.poznan.transformer.buildings;

/**
 * Location is the abstract base class for all locations.
 * This class implements <code>LocINT</code> which is crucial
 * to use Composite design-pattern.
 * Location has two private fields:
 * <ul>
 *     <li>id - mandatory - provided on creation</li>
 *     <li>name - optional</li>
 * </ul>
 * @see LocINT
 */
public abstract class Location implements LocINT{
    int     id;
    String  name;

    /**
     * Default constructor
     * @param id mandatory id of the location
     */
    public Location(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
