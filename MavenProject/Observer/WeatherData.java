package Observer;
import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private float temperature, humidity, pressure;

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }


    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void dettach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(temperature,humidity,pressure);
        }
    }
}
