package pl.put.poznan.transformer.buildings;

public abstract class Location implements LocINT{
    int     id;
    String  name;

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
