package com.example.chuwaproject.bean;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @Column(
            name = "id",
            updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotNull(message = "email is mandatory")
    @NotBlank(message = "email cannot be blank")
    @JsonProperty("email")
    private String email;
    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            name = "points"
    )
    private int points;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", points=" + points +
                '}';
    }
}
