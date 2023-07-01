package org.example;

import org.example.Observer.CreditCardObserver;
import org.example.Subject.CreditCardSubject;
import org.example.notification.NotificationStrategyFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        CreditCardSubject creditCardSubject = new CreditCardSubject();
        List<CreditCardObserver> Users = new ArrayList<>();
        String prompt = "Please input your name, phone, email and notification preference(SMS, EMAIL, WHATSAPP), split by ','. Input 'end' to finish register";
        String s = null;
        NotificationStrategyFactory notificationStrategyFactory = new NotificationStrategyFactory();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;

        while (true) {
            out.println(prompt);

            s = reader.readLine();

            NotificationPreference notificationPreference = null;

            try {
                if (s.equals("end")) {
                    break;
                }
                String[] parts = s.split(",");
                if (parts.length != 4){
                    throw new IllegalArgumentException("Wrong input format, not enough parameters");
                }

                String name = parts[0];
                String phone = parts[1];
                String email = parts[2];
                notificationPreference = NotificationPreference.valueOf(parts[3].toUpperCase());

                CreditCardObserver observer = new CreditCardObserver(name, phone, email, notificationStrategyFactory.createNotificationStrategy(notificationPreference));
                creditCardSubject.registerObserver(observer);
            } catch (IllegalArgumentException e) {
                out.println(e.getMessage());
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        creditCardSubject.notifyObservers(Boolean.TRUE, "40% off when you buy Popeyes between 06/13 - 06/19");
        creditCardSubject.notifyObservers(Boolean.FALSE, "you have successfully registered to add and here is your , please use this for \n" +
                "future references.");


    }
}
