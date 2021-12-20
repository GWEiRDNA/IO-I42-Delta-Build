package pl.put.poznan.transformer.buildings;

public class CompoundLocation extends LocationComposite<Location> {
    // private int nextId = 0;
    public CompoundLocation(){
        super(0);
    }

    public CompoundLocation(int id){
        super(id);
    }
}
