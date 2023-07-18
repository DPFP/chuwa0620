package com.chuwa.redbook.payload;

public class AuthorDto {
    private long id;
    private String username;
    private Integer age;

    public AuthorDto(long id) {
        this.id = id;
    }

    public AuthorDto(long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public AuthorDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
