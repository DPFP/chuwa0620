public class Polymorphism{
    public static void printSentence(int a){                                    //multiple methods with same name in the same class
        System.out.println("this is first method with int parameter!");
    }
    public static void printSentence(String a){
        System.out.println("this is second method with String parameter");
    }
    public static void printSentence(int a, String b){
        System.out.println("this is third method with multiple parameters");
    }

}