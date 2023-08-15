# HW45 Spring Security
**2.  What is the authentication?**
Authentication is the process of verifying the identity of a user or entity attempting to access a system or resource. It is a fundamental security measure used to ensure that only authorized users are granted access to protected information, services, or functionalities. Authentication is typically performed at the beginning of a user session or when accessing a secure resource.

**3.  What is the authorization?**
Authorization is the process of determining what actions or resources a user is allowed to access after they have been successfully authenticated. In other words, once a user's identity has been verified, authorization comes into play to define the permissions and access rights associated with that identity.

**4.  What is the difference between authentication and authorization?**
The main difference between authentication and authorization is their purpose and scope. Authentication is about verifying the user's identity, while authorization is about determining what actions or resources the authenticated user is allowed to access.

**5.  What is HTTP Session?**
HTTP Session is a mechanism used in web development to maintain stateful information between the server and the client over multiple requests. It allows the server to associate a user's interactions with a website across different pages and requests. The server assigns a unique identifier (session ID) to each user, and this identifier is typically stored as a cookie on the client's browser.

**6.  What is Cookie?**
A cookie is a small piece of data that a server sends to a user's web browser. The browser stores this data and sends it back to the server with each subsequent request. Cookies are often used for various purposes, such as session management, personalization, and tracking user behavior on websites.

**7. What is the difference between Session and Cookie?**
The main difference between Session and Cookie lies in their scope and where the data is stored. Session data is stored on the server, and the client's browser holds only the session ID in the form of a cookie. In contrast, cookies store data directly on the client's browser, which can include session IDs, user preferences, or other information.

**8.  How do we use session and cookie to keep user information across the the application?**
When a user logs in, their credentials are authenticated, and a session is created on the server. The server generates a unique session ID and sends it as a cookie to the client's browser.
The client's browser then sends the session ID with each subsequent request, allowing the server to identify the user's session and retrieve the associated data.
Server-side session data is used to store user-specific information, such as user preferences, shopping cart contents, or authentication status, which can be accessed and modified during the user's session.

**9.  What is JWT?**
JWT stands for JSON Web Token. It is a compact and self-contained way of transmitting information between parties as a JSON object. JWTs are often used for authentication and authorization purposes. They consist of three parts: a header, a payload, and a signature. The payload typically contains claims about the user and additional data, and the signature is used to verify the integrity of the token.

**10. What is the spring security filter?**
Spring Security filter is a crucial component of the Spring Security framework. It is responsible for intercepting HTTP requests and applying security-related operations, such as authentication, authorization, and other security mechanisms. Filters are configured in a chain and executed in a specific order to handle different security tasks.

**11. decribe how do JWT work**
Authentication: The user sends their credentials (e.g., username and password) to the server.
Server Verification: The server verifies the user's credentials and generates a JWT if the authentication is successful.
Token Issuance: The server sends the JWT back to the client as a response.
Token Storage: The client stores the JWT, usually in local storage or a cookie.
Token Transmission: For subsequent requests, the client includes the JWT in the Authorization header of the HTTP request.
Token Verification: The server verifies the JWT's signature and validates the claims to authenticate and authorize the user.

**12. Do you use any Encoder to encode Password?**
BCryptPasswordEncoder is commonly used in conjunction with Spring Security to handle password encryption. BCrypt is a one-way hash function that incorporates a salt and multiple rounds of hashing, making it difficult for attackers to reverse engineer the original password.

**13. What is UserDetailService? AuthenticationProvider?AuthenticationManager?AuthenticationFilter?**
UserDetailsService: In Spring Security, UserDetailsService is an interface that provides a way to retrieve user details (such as username, password, and authorities) from a data source, typically a database. It is used by the AuthenticationProvider during the authentication process to load user-specific data.

AuthenticationProvider: AuthenticationProvider is an interface that defines the contract for authenticating users based on their credentials. It is responsible for taking an Authentication request, validating the provided credentials, and returning a fully populated Authentication object if the authentication is successful.

AuthenticationManager: AuthenticationManager is an interface that acts as a container for AuthenticationProviders. When a user attempts to authenticate, the AuthenticationManager delegates the authentication request to its registered AuthenticationProviders to validate the user's credentials.

AuthenticationFilter: AuthenticationFilter is a Spring Security component responsible for intercepting incoming authentication requests and processing them. It checks if the request contains authentication information (e.g., JWT token, username/password), and if so, it attempts to authenticate the user using the configured AuthenticationManager.
 
**14. What is the disadvantage of Session? how to overcome the disadvantage?**
- Server-side storage: Sessions typically rely on server-side storage to maintain session data. This can lead to increased memory usage and additional server overhead, especially in high-traffic applications.

- Scalability: Server-side session management can become a bottleneck when trying to scale the application horizontally across multiple servers, as session data needs to be shared or synchronized.

- Resource consumption: Session data is often stored in memory, which can consume resources, particularly if the session contains large objects or if there are many active sessions.

- Stateful nature: Sessions introduce statefulness to the application, which can complicate the development and maintenance of the application, making it harder to follow the principles of a stateless RESTful architecture.

To overcome these disadvantages, stateless authentication mechanisms like JSON Web Tokens (JWT) are often used. JWTs are self-contained tokens that can carry user information and are digitally signed. They do not require server-side storage and can be easily validated by the server without the need for a database lookup. This makes JWTs scalable and suitable for distributed systems. Additionally, using JWTs promotes statelessness, which aligns well with the principles of RESTful APIs.

**15. how to get value from application.properties?**
You can use Spring's @Value annotation or the Environment class to access the property values.

**16. What is the role of configure(HttpSecurity http) and  configure(AuthenticationManagerBuilder auth)?**
configure(HttpSecurity http): This method is responsible for configuring how incoming HTTP requests are secured. It allows you to specify the security rules (e.g., authentication requirements, access control) based on URL patterns, roles, or other criteria. It also allows you to enable/disable features like CSRF protection, session management, and form-based login.
```
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .permitAll();
    }
} 
```

configure(AuthenticationManagerBuilder auth): This method is used to define how authentication should take place in the application. You can set up an in-memory user store, a JDBC-based user store, or use custom authentication providers. By overriding this method, you can configure the authentication mechanisms and specify the user details service.

**17.  What is Spring security authentication and authorization?**
Authentication: Spring Security provides multiple authentication mechanisms such as form-based authentication, basic authentication, OAuth, etc. It allows you to define how users are authenticated and how their credentials (like passwords) are verified securely.

Authorization: Once a user is authenticated, Spring Security helps you control what resources and actions the user is allowed to access. This is done through a system of roles and permissions, where you can define rules to restrict access based on user roles.