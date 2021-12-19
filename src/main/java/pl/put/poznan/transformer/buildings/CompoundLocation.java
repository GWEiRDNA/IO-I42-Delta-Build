package pl.put.poznan.transformer.buildings;

import javax.swing.plaf.ComponentUI;
import java.util.Vector;

public class CompoundLocation extends LocationComposite<Location> {
    // private int nextId = 0;
    public CompoundLocation(){
        super(0);
    }

    public CompoundLocation(int id){
        super(id);
    }
}
