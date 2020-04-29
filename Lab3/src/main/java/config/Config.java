package config;

import car.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"carService", "car"})
public class Config {

    @Bean(name = "defaultCar")
    public Car getDefaultCar(){
        return new Car();
    }
}
