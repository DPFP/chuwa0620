1. See Annotation.md

2. Authentication (AuthN) is a process that verifies that someone or something is who they say they are. Technology systems typically use some form of authentication to secure access to an application or its data. 

3. Authorization is the security process that determines a user or service's level of access. In technology, we use authorization to give users or services permission to access some data or perform a particular action. 

4. Simply put, **authentication is the process of verifying who someone is, whereas authorization is the process of verifying what specific applications, files, and data a user has access to**.

5. HTTP sessions is an industry standard feature that allows Web servers to maintain user identity and to store user-specific data during multiple request/response interactions between a client application and a Web application.

6. Cookies *are text files with small pieces of data — like a username and password — that are used* to identify your computer as you use a computer network.

7. Cookies and sessions are used by websites to store users' data across different pages of the site. The key difference between sessions and cookies is that **sessions are saved on the server side while cookies are saved on the client side**. Cookies are small text files used to store user information on the user's computer

8. **The server creates a “session ID” which is a randomly generated number that temporarily stores the session cookie**. This cookie stores information such as the user's input and tracks the movements of the user within the website. There is no other information stored in the session cookie.

9. JSON Web Token (JWT) is an open standard ([RFC 7519](https://tools.ietf.org/html/rfc7519)) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object. This information can be verified and trusted because it is digitally signed. JWTs can be signed using a secret (with the **HMAC** algorithm) or a public/private key pair using **RSA** or **ECDSA**.

   

10. At its core, Spring Security is really just a bunch of servlet filters that **help you add authentication and authorization to your web application**.

11. In authentication, when the user successfully logs in using their credentials, a JSON Web Token will be returned. Since tokens are credentials, great care must be taken to prevent security issues. In general, you should not keep tokens longer than required.

12. Yes, or otherwise the password will be store in the database in the form of plain text which make these sensitive data very  vulnerable. 

13. UserDetailsService is **used by Dao AuthenticationProvider for retrieving a username, a password, and other attributes for authenticating with a username and password**. 

    An AuthenticationProvider is **an abstraction for fetching user information from a specific repository**.

    AuthenticationManager is **a static class that manages the authentication modules that an application uses**. When a request is made to protected resources, the AuthenticationManager calls the Authenticate method to get an Authorization instance to use in subsequent requests.

14. Session variables and cookies are synonymous. So if a user has set his browser not to accept any cookies, your Session variables won't work for that particular web surfer!

15. We can use @Value annotation to get value form application.properties.

16. **configure(AuthenticationManagerBuilder)** is used to establish an authentication mechanism by allowing AuthenticationProviders to be added easily: e.g. The following defines the in-memory authentication with the in-built 'user' and 'admin' logins. **configure(HttpSecurity)** allows configuration of web based security at a resource level, based on a selection match - e.g. The example below restricts the URLs that start with /admin/ to users that have ADMIN role, and declares that any other URLs need to be successfully authenticated.

17.  you need your users to *authenticate*. That means your application needs to verify if the user is *who* he claims to be, typically done with a username and password check.

18. In simpler applications, authentication might be enough: As soon as a user authenticates, she can access every part of an application.

    But most applications have the concept of permissions (or roles). Imagine: customers who have access to the public-facing frontend of your webshop, and administrators who have access to a separate admin area.

    Both type of users need to login, but the mere fact of authentication doesn’t say anything about what they are allowed to do in your system. Hence, you also need to check the permissions of an authenticated user, i.e. you need to *authorize* the user.