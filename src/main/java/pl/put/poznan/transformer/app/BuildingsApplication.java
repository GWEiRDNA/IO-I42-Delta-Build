package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.transformer.buildings.*;
import pl.put.poznan.transformer.visitors.HeatAvgVisitor;
import pl.put.poznan.transformer.visitors.HeatExceededVisitor;
import pl.put.poznan.transformer.visitors.LightAvgVisitor;
import pl.put.poznan.transformer.visitors.Visitor;

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class BuildingsApplication {
    public static CompoundLocation compound;
    public static Visitor[] visitors;

    public static void main(String[] args) {
        visitors = new Visitor[3];
        visitors[0] = new LightAvgVisitor();
        visitors[1] = new HeatAvgVisitor();
        visitors[2] = new HeatExceededVisitor(1);


        Storey storey1 = new Storey(1);
        Storey storey2 = new Storey(2);
        storey1.add(new Room(
                2,
                2,
                4,
                8,
                16
        ));
        storey1.add(new Room(
                1,
                3,
                9,
                27,
                81
        ));
        storey2.add(new Room(
                3,
                5,
                25,
                125,
                625
        ));

        compound = new CompoundLocation();
        compound.add(storey1);
        compound.add(storey2);

        System.out.println(compound.getArea());
        System.out.println(compound.getCapacity());
        System.out.println(compound.getLight());
        System.out.println(compound.getHeating());

        LightAvgVisitor lightAvgVisitor = new LightAvgVisitor();
        storey1.accept(lightAvgVisitor);
        System.out.println(lightAvgVisitor.getOutcome());

        SpringApplication.run(BuildingsApplication.class, args);
    }
}
