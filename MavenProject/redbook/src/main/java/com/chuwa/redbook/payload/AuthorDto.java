package com.chuwa.redbook.payload;


/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/16/23$
 */
public class AuthorDto {
    private long id;

    private String name;

    public AuthorDto() {

    }

    public AuthorDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
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
}
