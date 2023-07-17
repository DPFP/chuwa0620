
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


### Spring
- @AutoWire
  - annotation in Spring framework is used for automatic dependency injection.
```aidl
 @Autowired
 public MyClass(MyService myService) {
    this.myService = myService;
 }
```





