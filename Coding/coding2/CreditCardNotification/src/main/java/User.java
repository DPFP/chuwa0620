import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class User {
    private String firstName;
    private String notificationType;
    private Map<String, String> contactsMap;

    public User(String firstName) {
        this.firstName = firstName;
        this.notificationType = null;
        this.contactsMap = new HashMap<>();
    }
    public User(String firstName, String notificationType) {
        this.firstName = firstName;
        this.notificationType = notificationType;
        this.contactsMap = new HashMap<>();
        this.contactsMap.put(notificationType, null);
    }
    public User(String firstName, String notificationType, String id) {
        this.firstName = firstName;
        this.notificationType = notificationType;
        this.contactsMap = new HashMap<>();
        this.contactsMap.put(notificationType, id);
    }
    public int addContact(String notificationType, String id){
        if (this.contactsMap.containsKey(notificationType)) {
            System.out.println("This notification type has been registered");
            return -1;
        }
        this.contactsMap.put(notificationType, id);
        System.out.println(this.firstName + ". Adding successfully: " + notificationType + ":" + id);
        return 0;
    }
    public int updateContact(String notificationType, String id){
        if (!this.contactsMap.containsKey(notificationType)) {
            System.out.println("This notification type does not exist");
            return -1;
        }
        this.contactsMap.put(notificationType, id);
        System.out.println(this.firstName + ". Update successfully: " + notificationType + ":" + id);
        return 0;
    }
    public int changePrimaryContact(String notificationType) {
        if (!this.contactsMap.containsKey(notificationType)) {
            System.out.println("This notification type does not exist");
            return -1;
        }
        this.notificationType = notificationType;
        return 0;
    }

}
