package pl.put.poznan.transformer.buildings;

import pl.put.poznan.transformer.visitors.Visitor;

/**
 * Building representation. Stores Storeys{@link Storey}
 * @see      Location
 * @see      LocINT
 */
public class Building extends LocationComposite<Storey> {
    public Building(int id){
        super(id);
    }
    @Override
    public void accept(Visitor visitor) {visitor.visit(this);}
}