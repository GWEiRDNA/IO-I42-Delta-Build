package pl.put.poznan.transformer.visitors;
import pl.put.poznan.transformer.buildings.*;

import java.util.Vector;

public interface Visitor {
    public void reset();
    public void visit(Room r);
    public void visit(Storey s);
    public void visit(Building b);
    public Object getOutcome();
}