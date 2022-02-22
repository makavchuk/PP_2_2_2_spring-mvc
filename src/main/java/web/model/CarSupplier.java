package web.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CarSupplier {

    public List<Car> carsStorage;

    public CarSupplier() {
        this.carsStorage = Arrays.asList(new Car("Mercedes", "CLG", 2020),
                new Car("BMW", "7", 2010),
                new Car("Ford", "Escort", 2000),
                new Car("Toyota", "Corolla", 2002),
                new Car("Fiat", "Cordoba", 1995));
    }
}
