2.  what is selenium?
    Selenium is an open-source testing framework for automating web applications. It allows testers to interact with web 
    elements, perform automated functional testing, and support multiple programming languages.
3.  what is cucumber?
    Cucumber is an open-source tool for behavior-driven development (BDD). It enables writing automated tests in a 
    human-readable Gherkin language format, fostering collaboration between stakeholders and testers.
4.  what is JMeter?
    JMeter is an open-source performance testing tool used to assess web application performance, simulate multiple users, 
    and generate test reports for analysis.
5.  What is the life circle of Junit?
    setup, test and cleanup
6.  Is @BeforeAll method should be Class level(static)?
    in junit, for each test method, a new instance of test is created,
    for the @BeforeAll method, it will only be called once in the entire tests execution cycle, 
    so they must be static
7. What is Mockito? and what is its limitations?  what kind of tools can give help?
   Mockito is an open-source Java testing framework used for creating mock objects in unit tests. It allows developers 
   to simulate the behavior of dependencies, such as databases or external services, during testing

   Cannot mock final classes or methods.
   Limited support for mocking static methods.
    
    we can use powermock
8.  What is @Mock and what is @InjectMocks?
    @Mock is used to create a mock object for a class or interface. It is applied to a field or a method parameter.
    The mock object created using @Mock behaves as a fake implementation of the class or interface, allowing developers 
    to define its behavior for testing purposes.
    By default, mock objects return default values for methods (e.g., null for object types, 0 for integers) unless 
    specific behavior is defined using stubbing.
    @InjectMocks is used to inject mock objects (created with @Mock) into the class being tested.
    It is applied to the class instance that needs to be tested, and Mockito automatically injects the mock objects into the corresponding fields or constructor parameters of the test class.
    @InjectMocks helps in reducing boilerplate code and makes it easier to set up the test environment by automatically wiring the mock dependencies.

9.  What is the stubbing (define behaviors)?
    Stubbing allows you to define these specific behaviors for the mock object so that it behaves as expected during the test. By specifying the return values or actions for mock methods, 
    you can control the flow of the test and test various scenarios without relying on the actual implementations of the mocked dependencies.
10. what is Mockito ArgumentMatchers
    Mockito ArgumentMatchers provide static methods that help match and specify argument values for method stubbing and verification in Mockito. They allow flexible handling of different 
    argument values without explicitly specifying exact values in test code. Commonly used ArgumentMatchers include any(), eq(value), startsWith(prefix), and more. They enhance test 
    readability and maintainability.
11. what is Hamcrest Matchers
    Hamcrest Matchers is a library that provides a collection of matchers for writing expressive and readable assertions in unit tests. 
    It is used in conjunction with testing frameworks like JUnit and Mockito to make assertions on the actual outcomes of the code being tested.
12. do you know @spy? what is difference between @spy and @Mock?
    @Spy is used to create a spy object, which is a partial mock. It means that the real implementation of the class is used by default, 
    and only the specified methods are mocked. All other methods will execute real code.
13. What is assertion?
    assertion is a statement or a piece of code that verifies whether a certain condition is true or false. It is a fundamental 
    concept used to validate that the expected behavior of the software is met during testing.
14. If you have developed a new feature, how many types of tests for this feature?
    and what kind of tests are written by you? what is the purpose of each type of
    tests?
    Unit, Integration, Regression, Performance, Stress, UAT
    Unit and Integration
15. Add unit test for CommentServiceImpl, the coverage should be 100%.
 