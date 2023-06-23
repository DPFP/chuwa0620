package org.example.Subject;

import org.example.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CreditCardSubject implements Subject {
    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(Boolean isGlobal, String message) {
        for (Observer observer : observerList){
            observer.update(isGlobal, message);
        }
    }
}
