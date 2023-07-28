# 2. what is the @configuration and @bean?
@Configuration is an annotation used to indicate that a Java class contains Spring bean configuration.

@Bean is an annotation used within a @Configuration class to explicitly declare a bean. When you use @Bean to annotate a method, Spring will treat the return value of that method as a bean definition and register it in the application context.

# 3.  How do you handle the exception in Spring?
1. use the @ExceptionHandler - Define specific handling logic for a particular type of exception. When that specific exception is thrown within the controller's methods, Spring will invoke the corresponding @ExceptionHandler method to handle the exception.

2. use the @ControllerAdvice - By annotating a class with @ControllerAdvice, you can define global exception handling methods that will apply to all controllers within your application.

# 4.  How do you do the validations in Spring? And list some validation annotaitons you know
By using validation annotations on entity definition.

- @NotNull: Validates that the annotated element is not null.
- @NotEmpty: Validates that the annotated string, collection, or array is not empty.
- @NotBlank: Validates that the annotated string is not null, not empty, and not whitespace.
- @Min: Validates that the annotated number is greater than or equal to the specified minimum value.
- @Max: Validates that the annotated number is less than or equal to the specified maximum value.

# 5. What is the actuator?

Spring Boot Actuator provides production-ready features to help you monitor and manage your Spring Boot applications. It exposes various endpoints that allow you to gather information about your application's health, metrics, configuration, and more.