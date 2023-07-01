package org.example.Subject;

import org.example.Observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers(Boolean isGlobal, String message);
}
