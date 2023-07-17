package com.chuwa.redbook.entity;

import jakarta.persistence.*;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/16/23$
 */
@Entity
@Table(
        name = "authors"
)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
