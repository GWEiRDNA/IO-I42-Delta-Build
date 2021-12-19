package pl.put.poznan.transformer.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.transformer.buildings.CompoundLocation;
import pl.put.poznan.transformer.buildings.Room;
import pl.put.poznan.transformer.buildings.Storey;

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {
    public static void main(String[] args) {
        Storey storey1 = new Storey(2);
        storey1.add(new Room(
                2,
                20,
                30,
                10,
                20.2f
        ));
        storey1.add(new Room(
                1,
                20,
                30,
                10,
                20.2f
        ));

        CompoundLocation compound = new CompoundLocation();
        compound.add(storey1);

        System.out.println(compound.getArea());
    }
}
