package observer;

public interface Subject {
    // add subscriber (observer)
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
