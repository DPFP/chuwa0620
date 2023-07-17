package com.chuwa.redbook.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthorDto {

    private long id;

    private String name;

    private Integer gender;

    private Integer age;
}
