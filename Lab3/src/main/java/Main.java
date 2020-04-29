import car.Car;
import carService.CarService;
import config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Car car = (Car)context.getBean("defaultCar");
        CarService carService = context.getBean(CarService.class);
        carService.save(car);
    }
}
