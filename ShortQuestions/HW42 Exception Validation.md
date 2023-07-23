# HW42 Exception Validation
**2. what is the @configuration and @bean?**
@Configuration is an annotation that marks a Java class as a configuration class. In a Spring application, it is used to define bean configurations programmatically rather than through XML-based configurations. When you annotate a class with @Configuration, it signals to the Spring container that this class will contain bean definitions and other configuration settings.

@Bean is an annotation used within a @Configuration-annotated class. It is used to indicate that a method in that class will produce a bean instance, which will be managed by the Spring container. The method should return the object that will be registered as a bean.

**3. How do you handle the exception in Spring?**
- Using @ControllerAdvice: The @ControllerAdvice annotation allows you to create a global exception handling component that can be shared across multiple controllers. It can contain multiple @ExceptionHandler methods for different exception types.
- Using @ExceptionHandler: Spring allows you to define exception handling methods in your controller classes using the @ExceptionHandler annotation. When an exception is thrown within the controller's method or any method invoked from it, Spring will look for the corresponding @ExceptionHandler method to handle that exception. You can then perform the necessary error handling or return a custom response to the client.

**4. How do you do the validations in Spring? And list some validation annotaitons you know.**
Add dependency
Add validation Rule to payload
Add @valid to controller to apply the Rule here

**5. What is the actuator?**
It allows you to monitor and manage your Spring Boot application when it is running in a production environment. Actuators expose various endpoints over HTTP or JMX (Java Management Extensions) that provide insights into the application's internal workings, health, and performance.