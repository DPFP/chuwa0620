import lombok.Data;

@Data
public class Vehicle {

    private String plateNum;
    private String state;
    private String type;
    public Vehicle(String pNum, String state, String type) {
        this.plateNum = pNum;
        this.state = state;
        this.type = type;
    }
}
