package polymorphism;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Tiger tiger = new Tiger("Big Tiger");
        FlyTiger flyTiger = new FlyTiger("Big Fly Tiger");

        System.out.println("This is tiger named: "+tiger.getName());
        tiger.eat("banana");
        tiger.eat("apple", 20);
        System.out.println("This is fly tiger named: "+flyTiger.getName());
        flyTiger.eat("cherry");
        flyTiger.eat("mango", 50);
    }
}

class Tiger {
    private String name;

    public Tiger(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println("Tiger eat " + food);
    }

    public void eat(String food, int waterWeight) {
        System.out.println("Tiger eat " + food + ", with water in " + waterWeight + " lb");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class FlyTiger extends Tiger {
    public FlyTiger(String name) {
        super(name);
    }

    @Override
    public void eat(String food) {
        System.out.println("FlyTiger eat " + food);
    }

    @Override
    public void eat(String food, int waterWeight) {
        System.out.println("FlyTiger eat " + food + ", with water in " + waterWeight + " lb");
    }
}
