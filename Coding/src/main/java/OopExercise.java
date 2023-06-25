public class OopExercise {
    public static void main(String[] args) {
        Cat cat = new Cat("white");
        Dog dog = new Dog("black");
        Dog bulldog = new Bulldog("fawn");
        Dog poodle = new Poodle("brown");

        cat.makeSound();
        dog.makeSound();
        bulldog.makeSound();
        poodle.makeSound();
    }
}

interface Animal {
    void makeSound();
}

class Dog implements Animal {
    protected String color;

    public Dog(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void makeSound() {
        System.out.println(color + " " + getClass().getSimpleName() + " barks");
    }
}

class Bulldog extends Dog {
    public Bulldog(String color) {
        super(color);
    }
}

class Poodle extends Dog {

    public Poodle(String color) {
        super(color);
    }
}

class Cat implements Animal {
    protected String color;

    public Cat(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void makeSound() {
        System.out.println(color + " " + getClass().getSimpleName() +  " meows");
    }
}