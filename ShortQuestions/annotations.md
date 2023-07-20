
### Java
- @FunctionalInterface
  - use for lambda, only one abstract method in interface
```
@FunctionalInterface
public interface Service {
    void sayHello(String name);
}
```

### JPA
- @Entity
    - This annotation is used at the class level to let it know that this class is an Entity (Table).
```aidl
@Entity
public class User {
   @Id
   private Long id;
   private String name;
   // getters and setters
}
```

- @Id
    - This annotation is used at the field level to denote the primary key of the entity.
```aidl
@Entity
public class User {
   @Id
   private Long id;
   // rest of the class
}
```

- @Table
    - This annotation is used to provide the details of the database table that will be used for mapping.
```aidl
@Entity
@Table(name="user_table")
public class User {
   // rest of the class
}
```

- @Column
  - define database column for entity conversion
```aidl
@Column(name="custom_column_name")
private String fieldName;
```


- @GeneratedValue
  - Used to specify how primary key values are generated for an entity. 
```aidl
@Entity
public class MyEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    // other fields, getters, and setters
}
```

- @ManyToOne
  - Used to define a many-to-one relationship between two entities.
```aidl
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // getters and setters
}
```

- @JoinColumn
  - Used to specify a column for joining an entity association or element collection.
```aidl
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    // ... other fields, getters, and setters ...
}
```
- @JoinTable
  - Used to define the table that maps a many-to-many association
```aidl
@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    
    @ManyToMany
    @JoinTable(
        name = "book_author", 
        joinColumns = @JoinColumn(name = "book_id"), 
        inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    // ... other fields, getters, and setters ...
}

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    // ... other fields, getters, and setters ...
}
```


### Spring
- @AutoWire
  - annotation in Spring framework is used for automatic dependency injection.
```aidl
 @Autowired
 public MyClass(MyService myService) {
    this.myService = myService;
 }
```

- @Repository
  - Indicates that the decorated class is a repository. A Repository is a generalization of a data access object (DAO). It is an abstraction that provides CRUD (Create, Read, Update, Delete) operations on objects of a specific type against an underlying data store.
```aidl
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
```




