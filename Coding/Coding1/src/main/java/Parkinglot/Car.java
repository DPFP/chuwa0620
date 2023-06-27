package Parkinglot;

import lombok.Data;

import java.util.Date;
@Data
public class Car {
    private String licensePlateNumber;
    private CarTypes carType;
    private Date enterTime;

    public Car(String licensePlateNumber, CarTypes carType) {
        this.licensePlateNumber = licensePlateNumber;
        this.carType = carType;
        this.enterTime = new Date();
    }
}
