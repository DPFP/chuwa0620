package org.example.Subject;

import org.example.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CreditCardSubject implements Subject {
    private List<Observer> observerList = new ArrayList<>();

    /**
     * @description attach the observer to the subject

     * @param observer: user is the observer here
     * @return void
     * @author zhanghm
     * @date 6/23/23 3:20 PM
     */
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    /**
     * @description detach the observer to the subject

     * @param observer: user is the observer here
     * @return void
     * @author zhanghm
     * @date 6/23/23 3:22 PM
     */
    @Override
    public void unregisterObserver(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * This function is to notify all the observers
     *
     * @param isGlobal
     * @param message
     */
    @Override
    public void notifyObservers(Boolean isGlobal, String message) {
        for (Observer observer : observerList){
            observer.update(isGlobal, message);
        }
    }
}
