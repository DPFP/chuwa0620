package inheritance;

public class InheritanceDemo {
    public static void main(String[] args) {
        Animal animal = new Animal(10);
        Animal cat = new Cat(20);

        animal.makeSound();
        cat.makeSound();
        System.out.println("Cat's height:"+cat.getHeight());
    }
}

class Animal {
    private int height;

    public Animal(int height){
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void makeSound(){
        System.out.println("Animal make sound~");
    }
}

class Cat extends Animal {
    public Cat(int height){
        super(height);
    }

    @Override
    public void makeSound() {
        System.out.println("Cat make sound: miu miu miu~");
    }
}