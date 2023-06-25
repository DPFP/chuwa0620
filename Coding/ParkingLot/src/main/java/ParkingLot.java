import java.util.Arrays;

abstract class Vehicle {

    public abstract boolean checkAvailable(Level[] parkingLot);
    public abstract void unPark(Level[] parkingLot);

    private int parkLevel;
    private int parkRow;

    private int parkType; //1, 2, 3

    public Vehicle() {
        this.parkLevel = -1;
        this.parkRow = -1;
        this.parkType = -1;
    }

    public int getParkType() {
        return parkType;
    }

    public void setParkType(int parkType) {
        this.parkType = parkType;
    }

    public int getParkLevel() {
        return parkLevel;
    }

    public void setParkLevel(int parkLevel) {
        this.parkLevel = parkLevel;
    }

    public int getParkRow() {
        return parkRow;
    }

    public void setParkRow(int parkRow) {
        this.parkRow = parkRow;
    }

}

class Motorcycle extends Vehicle {
    // Write your code here

    @Override
    public boolean checkAvailable(Level[] parkingLot) {
        if (this.getParkType() != -1)return false;
        for (int i = 0; i < parkingLot.length; i++) {
            Row[] rowsOnLevel = parkingLot[i].getRows();
            for (int j = 0; j < rowsOnLevel.length; j++) {
                if (rowsOnLevel[j].getSmallSpotNum() > 0) {
                    rowsOnLevel[j].setSmallSpotNum(rowsOnLevel[j].getSmallSpotNum() - 1);
                    this.setParkLevel(i);
                    this.setParkRow(j);
                    this.setParkType(1);
                    return true;
                }
            }
        }
        for (int i = 0; i < parkingLot.length; i++) {
            Row[] rowsOnLevel = parkingLot[i].getRows();
            for (int j = 0; j < rowsOnLevel.length; j++) {
                if (rowsOnLevel[j].getMidSpotNum() > 0) {
                    rowsOnLevel[j].setMidSpotNum(rowsOnLevel[j].getMidSpotNum() - 1);
                    this.setParkLevel(i);
                    this.setParkRow(j);
                    this.setParkType(2);
                    return true;
                }
            }
        }
        for (int i = 0; i < parkingLot.length; i++) {
            Row[] rowsOnLevel = parkingLot[i].getRows();
            for (int j = 0; j < rowsOnLevel.length; j++) {
                if (rowsOnLevel[j].getLargeSpotNum() > 0) {
                    rowsOnLevel[j].setLargeSpotNum(rowsOnLevel[j].getLargeSpotNum() - 1);
                    this.setParkLevel(i);
                    this.setParkRow(j);
                    this.setParkType(3);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void unPark(Level[] parkingLot) {
        if (this.getParkType() == -1)return;
        int level = this.getParkLevel();
        int row = this.getParkRow();
        if (this.getParkType() == 1) {
            int parkingSiteNumber = parkingLot[level].getRows()[row].getSmallSpotNum();
            parkingLot[level].getRows()[row].setSmallSpotNum(parkingSiteNumber + 1);
            this.setParkType(-1);
            this.setParkLevel(-1);
            this.setParkRow(-1);
        } else if (this.getParkType() == 2) {
            int parkingSiteNumber = parkingLot[level].getRows()[row].getMidSpotNum();
            parkingLot[level].getRows()[row].setMidSpotNum(parkingSiteNumber + 1);
            this.setParkType(-1);
            this.setParkLevel(-1);
            this.setParkRow(-1);
        } else if (this.getParkType() == 3) {
            int parkingSiteNumber = parkingLot[level].getRows()[row].getLargeSpotNum();
            parkingLot[level].getRows()[row].setLargeSpotNum(parkingSiteNumber + 1);
            this.setParkType(-1);
            this.setParkLevel(-1);
            this.setParkRow(-1);
        }
    }
}

class Car extends Vehicle {
    // Write your code here
    @Override
    public boolean checkAvailable(Level[] parkingLot) {
        if (this.getParkType() != -1)return false;
        for (int i = 0; i < parkingLot.length; i++) {
            Row[] rowsOnLevel = parkingLot[i].getRows();
            for (int j = 0; j < rowsOnLevel.length; j++) {
                if (rowsOnLevel[j].getMidSpotNum() > 0) {
                    rowsOnLevel[j].setMidSpotNum(rowsOnLevel[j].getMidSpotNum() - 1);
                    this.setParkLevel(i);
                    this.setParkRow(j);
                    this.setParkType(2);
                    return true;
                }
            }
        }
        for (int i = 0; i < parkingLot.length; i++) {
            Row[] rowsOnLevel = parkingLot[i].getRows();
            for (int j = 0; j < rowsOnLevel.length; j++) {
                if (rowsOnLevel[j].getLargeSpotNum() > 0) {
                    rowsOnLevel[j].setLargeSpotNum(rowsOnLevel[j].getLargeSpotNum() - 1);
                    this.setParkLevel(i);
                    this.setParkRow(j);
                    this.setParkType(3);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void unPark(Level[] parkingLot) {
        if (this.getParkType() == -1)return;
        int level = this.getParkLevel();
        int row = this.getParkRow();
        if (this.getParkType() == 2) {
            int parkingSiteNumber = parkingLot[level].getRows()[row].getMidSpotNum();
            parkingLot[level].getRows()[row].setMidSpotNum(parkingSiteNumber + 1);
            this.setParkType(-1);
            this.setParkLevel(-1);
            this.setParkRow(-1);
        } else if (this.getParkType() == 3) {
            int parkingSiteNumber = parkingLot[level].getRows()[row].getLargeSpotNum();
            parkingLot[level].getRows()[row].setLargeSpotNum(parkingSiteNumber + 1);
            this.setParkType(-1);
            this.setParkLevel(-1);
            this.setParkRow(-1);
        }
    }
}

class Bus extends Vehicle {
    // Write your code here
    @Override
    public boolean checkAvailable(Level[] parkingLot) {
        if (this.getParkType() != -1)return false;
        for (int i = 0; i < parkingLot.length; i++) {
            Row[] rowsOnLevel = parkingLot[i].getRows();
            for (int j = 0; j < rowsOnLevel.length; j++) {
                if (rowsOnLevel[j].getLargeSpotNum() >= 5) {
                    rowsOnLevel[j].setLargeSpotNum(rowsOnLevel[j].getLargeSpotNum() - 5);
                    this.setParkLevel(i);
                    this.setParkRow(j);
                    this.setParkType(3);
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public void unPark(Level[] parkingLot) {
        if (this.getParkType() == -1)return;
        int level = this.getParkLevel();
        int row = this.getParkRow();
        if (this.getParkType() == 3) {
            int parkingSiteNumber = parkingLot[level].getRows()[row].getLargeSpotNum();
            parkingLot[level].getRows()[row].setLargeSpotNum(parkingSiteNumber + 5);
            this.setParkType(-1);
            this.setParkLevel(-1);
            this.setParkRow(-1);
        }
    }
}
class Row {
    int smallSpotNum;
    int midSpotNum;
    int largeSpotNum;

    public Row(int k) {
        this.smallSpotNum = k/4;
        this.midSpotNum = k/4*3- k/4;
        this.largeSpotNum = k - k/4*3;
    }

    public void setSmallSpotNum(int smallSpotNum) {
        this.smallSpotNum = smallSpotNum;
    }

    public void setMidSpotNum(int midSpotNum) {
        this.midSpotNum = midSpotNum;
    }

    public void setLargeSpotNum(int largeSpotNum) {
        this.largeSpotNum = largeSpotNum;
    }

    public int getSmallSpotNum() {
        return smallSpotNum;
    }

    public int getMidSpotNum() {
        return midSpotNum;
    }

    public int getLargeSpotNum() {
        return largeSpotNum;
    }
}

class Level {
    private Row[] rows;
    public Level(int num_rows, int spots_per_row) {
        rows = new Row[num_rows];
        for (int i = 0; i < num_rows; i++) {
            rows[i] = new Row(spots_per_row);
        }
    }

    public Row[] getRows() {
        return rows;
    }

    public void setRows(Row[] rows) {
        this.rows = rows;
    }
}

public class ParkingLot {
    //n : level, num_rows : rows per level, spots_per_row : spots per row
    private Level[] parkingLot;
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        parkingLot = new Level[n];
        //Arrays.fill(parkingLot, new Level(num_rows, spots_per_row));
        for (int i = 0; i < n; i++) {
            parkingLot[i] = new Level(num_rows, spots_per_row);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        return vehicle.checkAvailable(parkingLot);
    }

    public void unParkVehicle(Vehicle vehicle) {
        vehicle.unPark(parkingLot);
    }

    public static void main(String[] args) {
        //test case 1
        ParkingLot park = new ParkingLot(1, 1, 11);
        Vehicle m1 = new Motorcycle();
        Vehicle c1 = new Car();
        Vehicle c2 = new Car();
        Vehicle c3 = new Car();
        Vehicle c4 = new Car();
        Vehicle c5 = new Car();
        Vehicle b1 = new Bus();

        System.out.println(park.parkVehicle(m1));
        System.out.println(park.parkVehicle(c1));
        System.out.println(park.parkVehicle(c2));
        System.out.println(park.parkVehicle(c3));
        System.out.println(park.parkVehicle(c4));
        System.out.println(park.parkVehicle(c5));
        System.out.println(park.parkVehicle(b1));
        park.unParkVehicle(c5);
        System.out.println(park.parkVehicle(b1));

        //test case 2
//        ParkingLot park = new ParkingLot(1, 1, 14);
//        Vehicle m1 = new Motorcycle();
//        Vehicle m2 = new Motorcycle();
//        Vehicle m3 = new Motorcycle();
//        Vehicle c1 = new Car();
//        Vehicle c2 = new Car();
//        Vehicle c3 = new Car();
//        Vehicle m4 = new Motorcycle();
//        Vehicle c4 = new Car();
//        Vehicle c5 = new Car();
//        Vehicle c6 = new Car();
//        Vehicle c7 = new Car();
//        Vehicle b1 = new Bus();
//
//
//        System.out.println(park.parkVehicle(m1));
//        System.out.println(park.parkVehicle(m2));
//        System.out.println(park.parkVehicle(m3));
//        System.out.println(park.parkVehicle(c1));
//        System.out.println(park.parkVehicle(c2));
//        System.out.println(park.parkVehicle(c3));
//        System.out.println(park.parkVehicle(m4));
//        System.out.println(park.parkVehicle(c4));
//        System.out.println(park.parkVehicle(c5));
//        System.out.println(park.parkVehicle(c6));
//        System.out.println(park.parkVehicle(c7));
//        System.out.println(park.parkVehicle(b1));
//        park.unParkVehicle(c1);
//        park.unParkVehicle(m4);
//        park.unParkVehicle(c3);
//        park.unParkVehicle(c6);
//        System.out.println(park.parkVehicle(b1));
//        park.unParkVehicle(c7);
//        System.out.println(park.parkVehicle(b1));

    }
}
