package Observer;

public interface Subject {
    void attach(Observer observer);
    void dettach(Observer observer);
    void notifyObservers();
    void setMeasurements(float temperature, float humidity, float pressure);
}
