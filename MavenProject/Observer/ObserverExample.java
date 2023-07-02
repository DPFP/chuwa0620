package Observer;

public class ObserverExample {
    public static void main(String[] args) {
        Observer sensor1 = new Sensor("living room");
        Observer sensor2 = new Sensor("kitchen");

        Subject weatherData = new WeatherData();
        weatherData.attach(sensor1);
        weatherData.attach(sensor2);

        weatherData.setMeasurements(25.5f, 60.0f, 1013.2f);
        weatherData.setMeasurements(27.2f, 55.5f, 1012.8f);

        weatherData.dettach(sensor2);

        weatherData.setMeasurements(26.8f, 58.0f, 1014.5f);

    }
}
