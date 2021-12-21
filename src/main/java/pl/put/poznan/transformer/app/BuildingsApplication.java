package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.transformer.buildings.*;

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class BuildingsApplication {
    public static CompoundLocation compound;
    public static void main(String[] args) {
        LocationComposite storey1 = new Storey(2);
        Location storey2 = new Storey(2);
        storey1.add(new Room(
                2,
                20,
                30,
                10,
                20.2
        ));
        storey1.add(new Room(
                1,
                20,
                30,
                10,
                20.2
        ));

        compound = new CompoundLocation();
        compound.add(storey1);

        System.out.println(compound.getArea());
        SpringApplication.run(BuildingsApplication.class, args);
    }
}
