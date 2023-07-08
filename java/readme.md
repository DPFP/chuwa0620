6.  What is Runtime Exception? could you give me some examples?
    Runtime exception is exception that occurs in runtime, also known as unchecked exception, such as NPT and OutOfBound
    heres an example that i wrote
    class BalanceInSufficientException extends RuntimeException{
    public BalanceInSufficientException(){

    }

    public BalanceInSufficientException(int withdrawAmount, String username){
    super("Your balance in ur account is less than " + withdrawAmount+". Get outta here "+username);
    }

    public static void main(String[] args) {
    new AccountInfo(10,"Bob").withdraw(100);
    }
    }

class AccountInfo{
int balance;
String userName;

    public AccountInfo(int balance, String userName) {
        this.balance = balance;
        this.userName = userName;
    }

    public void withdraw(int amount){
        if(amount > balance) throw new BalanceInSufficientException(amount, userName);
        else balance -= amount;
    }
}
7. Could you give me one example of NullPointerException?
    int [] arr = {1}
    arr[1];
8.  What is the Optional class?
    So in java, NPE is probably the most common exception. When we write the code, it is very likely for us to forget doing the null check, thats why the Optional class came up, when people sees Optional as a return type, he should know that a null check is needed.
    A Optional class is like a container that may or may not have a null value.

9.  What are the advantages of using the Optional class?
    The Optional class promotes a more expressive and safer coding style by explicitly handling scenarios where a value may or may not be present, reducing the likelihood of unexpected null references.
10. What is the @FunctionalInterface?
    it is a interface that have one and only one abstract class
11. what is lamda?
    In Java, a lambda expression is a concise way to represent a block of code that can be treated as a function and passed around
12. What is Method Reference?
    it is a special type of lambda expression that allow us to refer a method by its name so that we can simplify the code
13. What is Java 8 new features?
    lambda, function interface, stream api, method references, default methods, optional
14. Lambda can use unchanged variable outside of lambda? what is the details?
    In Java, lambda expressions can capture and use variables from their surrounding context, including local variables and instance or static variables. However, there are certain rules and considerations to keep in mind regarding the usage of variables outside of lambdas.

Final or effectively final variables: Lambda expressions can access and use local variables that are declared as final or effectively final. An effectively final variable is one that is not explicitly declared as final but is never reassigned after its initialization. Lambda expressions treat such variables as if they are final. This means you can use them within the lambda expression without any issues.

Accessing variables from enclosing scope: Lambda expressions can access variables from the enclosing scope (the scope in which the lambda expression is defined). These variables must be either final or effectively final, as mentioned earlier. The lambda expression can read the values of these variables, but it cannot modify them.

Capture by value: When a lambda expression captures a variable from its surrounding context, it captures the value of the variable at the time the lambda expression is created. It does not capture the variable itself. This means that changes to the variable's value outside the lambda expression will not be reflected inside the lambda.

Effect on variable visibility: Lambda expressions do not create a new scope. They have access to variables from their enclosing scope, but they do not introduce new variables or affect the visibility of variables in their enclosing scope.