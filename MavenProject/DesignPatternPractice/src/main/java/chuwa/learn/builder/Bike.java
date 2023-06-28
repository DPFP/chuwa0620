package chuwa.learn.builder;

public class Bike {
    private String frame;
    private String seat;

    public Bike(String frame, String seat) {
        this.frame = frame;
        this.seat = seat;
    }

    public Bike() {

    }
    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
