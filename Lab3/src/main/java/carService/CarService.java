package carService;

import car.Car;
import car.ICar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {
    @Autowired
    private List<ICar> cars = new ArrayList<>();

    public void save(Car car){
        for(ICar iCar : this.cars){
            iCar.save(car);
        }
    }
}
