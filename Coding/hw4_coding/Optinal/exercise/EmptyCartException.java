package exercise;

/**
 * @author b1go
 * @date 4/12/23 11:37 PM
 */
public class EmptyCartException extends RuntimeException {
    public EmptyCartException(String message) {
        super(message);
    }
}
