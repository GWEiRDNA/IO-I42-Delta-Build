package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.transformer.buildings.CompoundLocation;
import pl.put.poznan.transformer.buildings.Room;
import pl.put.poznan.transformer.buildings.Storey;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {
    public static CompoundLocation compound;
    public static void main(String[] args) {
        Room room1 = new Room(
                1,
                20,
                30,
                10,
                20.2f
        );
        Room room2 = new Room(
                2,
                20,
                30,
                10,
                20.2f
        );
        room1.setName("testing...");
        Storey storey1 = new Storey(2);
        storey1.add(room1);
        storey1.add(room2);

        compound = new CompoundLocation();
        compound.add(storey1);

        SpringApplication.run(TextTransformerApplication.class, args);
    }
}
