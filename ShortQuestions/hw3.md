### 2 What is the checked exception and unchecked exception in Java, could you give one example?
checked exception: These are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using the throws keyword.  

unchecked exception: These are the exceptions that are not checked at compile time. In Java, exceptions under Error and RuntimeException classes are unchecked exceptions, everything else under throwable is checked.   

### 3 Can there be multiple finally blocks?
There can only be one finally block, and it must follow the catch blocks. If the try block exits normally (no exceptions occurred), then control goes directly to the finally block. After the finally block is executed, the statements following it get control.

### 4 When both catch and finally return values, what will be the final result?
If both catch and finally return, the receiving method will get the returned value from the finally block.


### 5 What is Runtime/unchecked exception? what is Compile/Checked Exception?
Runtime Exceptions are not caught at the time of compiling the program.  
The Runtime Exception is the parent class in all exceptions of the Java programming language that are expected to crash or break down the program or application when they occur. Unlike exceptions that are not considered as Runtime Exceptions, Runtime Exceptions are never checked.  

Comiple Exceptions are reported and handled at the time of compiling the program.  
The Compile Exceptions are checked by the compiler during the compilation process to confirm whether the exception is handled by the programmer or not. If not, then the system displays a compilation error.

### 6 What is the difference between throw and throws?
The throw keyword is used inside a function. It is used when it is required to throw an Exception logically. The throws keyword is used in the function signature. It is used when the function has some statements that can lead to exceptions.  

### 7 Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?
