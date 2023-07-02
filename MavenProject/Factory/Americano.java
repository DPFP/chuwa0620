package Factory;

public class Americano extends Coffee{

    @Override
    public String getName() {
        return "Americano";
    }

    @Override
    public String getDescription() {
        return "a coffee beverage that is made by diluting espresso with hot water";
    }
}
