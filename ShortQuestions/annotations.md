### Annotations

- `@Bean`
  Declares a method as a provider of a bean instance to be managed by the Spring container.
- `@Repository`
  Identifies a class as a data access object (DAO) or repository, responsible for performing database or data access operations.
- `@Service`
  Marks a class as a service component, typically containing business logic and coordinating actions between the data access layer (DAO) and the presentation layer.
- `@RestController`
  Combines @Controller and @ResponseBody annotations. It identifies a class as a controller component that handles requests and generates responses, specifically for RESTful web services, returning data directly as the response body.
- `@OneToMany`, `@ManyToOne`, and `@ManyToMany` are annotations commonly used in Java ORM frameworks, such as JPA (Java Persistence API) and Hibernate, to establish relationships between entities in a database. These annotations help define how entities are related to each other, allowing for easy mapping of complex database relationships into Java objects.

- `@NamedQuery`
  @NamedQuery is an annotation used in JPA to declare a single named query on an entity class.
- `@NamedQueries`
  @NamedQueries is an annotation used in JPA to declare multiple named queries on an entity class.
