package car;

import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class CarTXT implements ICar {

    @Override
    public void save(Car car) {
        String result = car.toString() + "\n";
        try(FileWriter wr = new FileWriter("cars.txt")){
            wr.write(result);
            wr.flush();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
