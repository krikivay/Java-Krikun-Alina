package car;

import accessor.Accessor;
import org.springframework.stereotype.Component;

@Component
public class CarDatabase implements ICar{
    @Override
    public void save(Car car) {
        try {
            Accessor ac = Accessor.getInstance();
            ac.selectDatabase("cars");
            ac.selectTable();
            ac.insertCar(car);
            ac.closeConnection();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
