package Factory;

public class Espresso extends Coffee{

    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public String getDescription() {
        return "Strong and concentrated coffee.";
    }
}
