package com.chuwa.codingassignment1.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/26/23$
 */
public class CustomerDto {
    private long id;
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    public CustomerDto () {}

    public CustomerDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public CustomerDto(long id, String name, String email) {
        this(name, email);
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
