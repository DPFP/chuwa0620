package Observer;

public class Sensor implements Observer{
    private String name;

    public Sensor(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println(name + ": Temperature = " + temperature +
                "°C, Humidity = " + humidity + "%, Pressure = " + pressure + " hPa");
    }
}
