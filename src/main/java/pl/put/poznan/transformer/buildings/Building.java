package pl.put.poznan.transformer.buildings;

/**
 * Building representation. Stores Storeys{@link Storey}
 * @see      Location
 * @see      LocINT
 */
public class Building extends LocationComposite<Storey> {
    public Building(int id){
        super(id);
    }
}