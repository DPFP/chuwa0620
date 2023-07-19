package com.chuwa.redbook.payload;

public class AuthorDto {
    private Long authorId;

    private String name;

    private String birthday;

    public AuthorDto(){}

    public AuthorDto(Long authorId, String name, String birthday) {
        this.authorId = authorId;
        this.name = name;
        this.birthday = birthday;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
