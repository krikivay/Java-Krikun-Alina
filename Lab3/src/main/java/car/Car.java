package car;



public class Car {
    private String producer;
    private String model;
    private int year;
    private String color;

    public Car() {
        producer = "Mazda";
        model = "CX7";
        year = 2007;
        color = "brown";
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}
