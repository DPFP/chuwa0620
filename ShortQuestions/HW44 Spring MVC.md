# HW44
**2. What is MVC pattern?**
MVC stands for Model-View-Controller, and it is a software design pattern commonly used in web applications, including those built with SpringBoot. The MVC pattern separates an application into three interconnected components:
Model: Represents the data and business logic of the application. It encapsulates the data and provides methods to access and manipulate it.
View: Represents the presentation layer of the application. It is responsible for rendering the data to the users and displaying the user interface.
Controller: Acts as an intermediary between the Model and the View. It handles user requests, processes the data from the Model, and updates the View accordingly.
In SpringBoot, the MVC pattern is implemented using the Spring Web MVC module, which provides features like request mapping, data binding, and view resolution to create web applications following the MVC architectural pattern.

**3.  What is Front-Controller?** 
Front-Controller is a design pattern used in web applications, where a centralized controller handles all incoming requests and acts as a front door to the application. It receives incoming requests from clients (such as browsers or mobile apps), processes them, and then dispatches the requests to appropriate handlers or components.

In SpringBoot, the DispatcherServlet serves as the Front-Controller. It intercepts all incoming HTTP requests and then delegates the requests to the appropriate handler methods (controllers) based on the URL mappings configured in the application.

**4.  What is DispatcherServlet? please decribe how it works.**
When a client sends an HTTP request to the server, the DispatcherServlet intercepts the request, and its primary function is to manage the entire request-handling process. Here's how it works:
- When a request is received, the DispatcherServlet consults the registered handler mappings to determine the appropriate controller (handler) to process the request.
- The selected controller (handler) processes the request and performs any necessary business logic.
- After the controller has finished processing the request, it returns a ModelAndView object. The ModelAndView contains the data to be displayed and the logical view name (a template or JSP page).
- The DispatcherServlet then consults the view resolver to find the actual view (JSP, Thymeleaf template, etc.) based on the logical view name.
- Finally, the DispatcherServlet renders the view with the model data, and the generated response is sent back to the client.

**5.  What is JSP and What is ModelAndView？(please google to have a basic knowlege)**
JSP (JavaServer Pages) is a technology used to create dynamic web content by embedding Java code within HTML pages. JSP allows developers to write Java code directly into the HTML template, which is then compiled into a servlet and executed on the server-side to generate dynamic content.

ModelAndView is a specific class used in Spring Web MVC to represent both the model data and the view name. When a controller method returns a ModelAndView object, it contains the model data that needs to be displayed on the view and the logical view name. The view name is used by the DispatcherServlet to resolve the actual view template.

**6.  Could you please google any other servlets**
Apache Struts, JavaServer Faces (JSF), Play Framework, and SparkJava.

**7. How many web server do you know? (Tomcat, Jetty, Jboss)**
Some well-known web servers used to deploy Java web applications include:

- Apache Tomcat: It is one of the most popular and widely used Java Servlet containers. It's lightweight, easy to use, and is often used in development and production environments.
- Jetty: Jetty is another lightweight and versatile web server and servlet container. It is known for its fast startup time and is commonly used for embedded scenarios.
- JBoss (now known as WildFly): JBoss is a full-fledged Java EE application server that supports not only servlets but also Enterprise JavaBeans (EJB), Java Persistence API (JPA), and other Java EE technologies.

These web servers are responsible for handling HTTP requests, managing the lifecycle of servlets, and delivering responses back to clients in a Java web application environment.