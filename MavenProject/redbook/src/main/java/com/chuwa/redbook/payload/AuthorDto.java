package com.chuwa.redbook.payload;

public class AuthorDto {

    private long id;
    private String firstName;
    private String LastName;
    private String birthDate;

    public AuthorDto() {

    }

    public AuthorDto(long id, String firstName, String lastName, String birthDate) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

}
