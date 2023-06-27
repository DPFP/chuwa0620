package DesignPattern.Factory;

import java.util.HashMap;
import java.util.Map;

public class PhoneFactory {
    Map<String, Phone> map;
    public PhoneFactory(){
        map = new HashMap<>();
        map.put("iphone", new Iphone());
        map.put("sony", new Sony());
    }

    public Phone getPhone(String phone){
        return map.get(phone);
    }
}
class Phone{

}
class Iphone extends Phone{
    String type = "Iphone";
    double size = 6.1;
    int id = 123;
}

class Sony extends Phone{
    String type = "Sony";
    double size = 5.5;
    int id = 345;

}
