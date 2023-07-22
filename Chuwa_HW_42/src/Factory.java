import java.util.HashMap;

public class Factory {
    public static void main(String[] args) {

    }
}

interface Human{
    void saySomething();
}

class StraightHuman implements Human{

    @Override
    public void saySomething() {
        System.out.println("I am straight");
    }
}
class GayHuman implements Human{

    @Override
    public void saySomething() {
        System.out.println("I am gay");
    }
}
class TransHuman implements Human{

    @Override
    public void saySomething() {
        System.out.println("I am trans");
    }
}

class HumanFactory{
    private static HashMap<String,Human> map;
    static{
        map = new HashMap<String,Human>();
        map.put("trans",new TransHuman());
        map.put("gay",new GayHuman());
        map.put("straight",new StraightHuman());
    }
    public static Human createHuman(String s){
        return map.get(s);
    }
}
